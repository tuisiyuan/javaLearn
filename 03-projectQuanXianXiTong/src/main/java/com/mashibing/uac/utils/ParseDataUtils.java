package com.mashibing.uac.utils;

import cn.hutool.crypto.SecureUtil;
import com.mashibing.uac.enums.CommonConstant;

public class ParseDataUtils {

    public static String sessionIdToCacheKey(String sessionId) {
        return CommonConstant.adminSessionPreKey + sessionId;
    }

    public static String passwordEncrypt(String password) {
        return SecureUtil.md5(CommonConstant.accountSalt + password);
    }
}
