package com.mashibing.controller;

import com.mashibing.domain.Account;
import com.mashibing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MainController {

    @Autowired
    IAccountService iAccountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap modelMap) {
        modelMap.put("name", "ruhua");

        List<Account> accountAll = iAccountService.getAccountAll();

        return "list";
    }

}
