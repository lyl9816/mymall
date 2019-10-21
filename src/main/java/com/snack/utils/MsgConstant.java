package com.snack.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息封装
 */
public class MsgConstant {

    final static Map<String, String> msg = new HashMap<String, String>();

    public final static String MSG_000000 = "000000";
    public final static String MSG_000001 = "000001";
    public final static String MSG_000002 = "000002";

    static {
        //正常返回
        msg.put(MSG_000000, "ok");
        //系统异常
        msg.put(MSG_000001, "exception");
        msg.put(MSG_000002, "用户名错误！");
    }

    public static String getMsg(String key) {
        return msg.get(key);
    }
}
