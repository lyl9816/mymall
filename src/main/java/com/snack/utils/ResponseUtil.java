package com.snack.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.snack.utils.MsgConstant;

import java.util.Map;


public class ResponseUtil {

    /**
     * 返回结果
     *
     * @param errCode 错误代码
     * @param errMsg  错误信息
     * @param o       返回数据
     * @return
     */
    public static String toClient(String errCode, String errMsg, Object o) {
        JSONObject jb = new JSONObject();
        jb.put("errCode", errCode);
        jb.put("errMsg", errMsg);
        jb.put("data", o);
        return jb.toString();
    }

    /**
     * 返回结果
     *
     * @param o 返回数据
     */
    public static String successToClient(Object o) {
        return toClient(MsgConstant.MSG_000000, MsgConstant.getMsg(MsgConstant.MSG_000000), o);
    }


    /**
     * 返回结果
     *
     * @param o 返回数据
     */
    public static String successToClientStr(Object o) {
        return toClient(MsgConstant.MSG_000000, MsgConstant.getMsg(MsgConstant.MSG_000000), JSON.toJSONString(o));
    }

    /**
     * 返回结果
     */
    public static String successToClient() {
        return toClient(MsgConstant.MSG_000000, MsgConstant.getMsg(MsgConstant.MSG_000000));
    }

    /**
     * 返回结果
     *
     * @param errMsg
     */
    public static String errorMsgToClient(String errMsg) {
        return toClient(MsgConstant.MSG_000001, errMsg);
    }


    /**
     * 返回结果
     *
     * @param o 返回数据
     */
    public static String errorToClient(Object o) {
        return toClient(MsgConstant.MSG_000001, MsgConstant.getMsg(MsgConstant.MSG_000001), o);
    }

    /**
     * 返回结果
     *
     * @param errCode
     */
    public static String errorToClient(String errCode) {
        return toClient(errCode, MsgConstant.getMsg(errCode));
    }

    /**
     * 返回结果
     */
    public static String errorToClient() {
        return toClient(MsgConstant.MSG_000001, MsgConstant.getMsg(MsgConstant.MSG_000001));
    }

    /**
     * 返回结果
     *
     * @param o 返回数据
     */
    public static String successToClient(Object o, Map<String, Object> other) {
        return toClient(MsgConstant.MSG_000000, MsgConstant.getMsg(MsgConstant.MSG_000000), o, other);
    }

    /**
     * 返回结果
     *
     * @param errCode 错误代码
     * @param errMsg  错误信息
     * @param o       返回数据
     * @param other   一级参数
     * @return
     */
    public static String toClient(String errCode, String errMsg, Object o, Map<String, Object> other) {
        JSONObject jb = new JSONObject();
        jb.put("errCode", errCode);
        jb.put("errMsg", errMsg);
        jb.put("data", o);
        jb.putAll(other);
        return jb.toString();
    }

    /**
     * 返回结果
     *
     * @param errCode 错误代码
     * @param errMsg  错误信息
     * @return
     */
    public static String toClient(String errCode, String errMsg) {
        return toClient(errCode, errMsg, "");
    }

    /**
     * 返回结果
     *
     * @param errCode 错误代码
     * @return
     */
    public static String toClient(String errCode) {
        return toClient(errCode, MsgConstant.getMsg(errCode), "");
    }

    /**
     * 返回结果
     *
     * @param errCode 错误代码
     * @param o 返回数据
     * @return
     */
    public static String toClient(String errCode, Object o) {
        return toClient(errCode, MsgConstant.getMsg(errCode), o);
    }
}
