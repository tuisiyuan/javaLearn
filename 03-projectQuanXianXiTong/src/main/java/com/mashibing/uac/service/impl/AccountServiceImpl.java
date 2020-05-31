package com.mashibing.uac.service.impl;

import com.mashibing.uac.mapper.AccountMapper;
import com.mashibing.uac.model.entity.Account;
import com.mashibing.uac.model.qo.DoLogQo;
import com.mashibing.uac.service.IAccountService;
import com.mashibing.uac.utils.Current;
import com.mashibing.uac.utils.ParseDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    RedisTemplate redisTemplate;


    public Account getAccountByLoginQo(DoLogQo logQo) {
        logQo.setPassword(ParseDataUtils.passwordEncrypt(logQo.getPassword()));
        return accountMapper.selectByLoginNameAndPassword(logQo);
    }

    public boolean doLogin(DoLogQo logQo) {
        Account account = this.getAccountByLoginQo(logQo);

        if (account == null) {
            return false;
        }

        String sessionId = Current.getRequest().getSession().getId();
        redisTemplate.opsForValue().set(ParseDataUtils.sessionIdToCacheKey(sessionId), account.getId(), 1, TimeUnit.DAYS);

        return true;
    }
}
