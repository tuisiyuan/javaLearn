package com.mashibing.uac.controller.admin;

import cn.hutool.json.JSONUtil;
import com.mashibing.uac.model.qo.DoLogQo;
import com.mashibing.uac.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/login")
public class LoginController {

    @Autowired
    IAccountService iAccountService;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {

        return "admin/login";
    }

    /**
     * 执行登录
     * @return
     */
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@RequestBody DoLogQo doLogQo) {

        boolean loginRes = iAccountService.doLogin(doLogQo);

        Map resMap = new HashMap() ;
        resMap.put("data", loginRes ? "succ" : "fail");

        return JSONUtil.toJsonStr(resMap);
    }

}
