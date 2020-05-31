package com.mashibing.uac.service;

import com.mashibing.uac.model.entity.Account;
import com.mashibing.uac.model.qo.DoLogQo;

public interface IAccountService {

    Account getAccountByLoginQo(DoLogQo logQo);

    boolean doLogin(DoLogQo logQo);
}
