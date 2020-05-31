package com.mashibing.service.impl;

import com.mashibing.domain.Account;
import com.mashibing.mapper.AccountMapper;
import com.mashibing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountMapper accountMapper;

    public List<Account> getAccountAll() {
        return accountMapper.listAll();
    }


}
