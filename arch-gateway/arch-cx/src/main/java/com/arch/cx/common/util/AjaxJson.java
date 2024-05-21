package com.arch.cx.common.util;


import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApiModel(value = "AjaxJson", description = "通用Web端接口请求应答对象")
public class AjaxJson<T> implements Serializable {


    public final static String SUCCESS_CODE = "0000";

    public final static String ERROR_CODE = "9999";


    private String status = SUCCESS_CODE;// 是否成功

    private String statusMsg = "操作成功";// 提示信息

    private T data = null;// 其他信息

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 泛型化支持
     *
     * @param <T> 数据类型
     */
    public static <T> AjaxJson<T> okGeneric() {
        AjaxJson<T> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(SUCCESS_CODE);
        return ajaxJson;
    }

    /**
     * 泛型化支持
     *
     * @param obj 数据内容
     * @param <T> 数据类型
     */
    public static <T> AjaxJson<T> okGeneric(T obj) {
        AjaxJson<T> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(SUCCESS_CODE);
        ajaxJson.setData(obj);
        return ajaxJson;
    }

    /**
     * 泛型化支持
     *
     * @param obj 数据内容
     * @param <T> 数据类型
     */
    public static <T> AjaxJson<List<T>> okGeneric(List<T> obj) {
        AjaxJson<List<T>> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(SUCCESS_CODE);
        ajaxJson.setData(obj);
        return ajaxJson;
    }

    /**
     * 泛型化支持
     *
     * @param obj 数据内容
     * @param <T> 数据类型
     */
    public static <T, S> AjaxJson<S> okGeneric(T obj, Function<T, S> converter) {
        AjaxJson<S> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(SUCCESS_CODE);
        ajaxJson.setData(converter.apply(obj));
        return ajaxJson;
    }

    /**
     * 泛型化支持
     *
     * @param obj 数据内容
     * @param <T> 数据类型
     */
    public static <T, S> AjaxJson<List<S>> okGeneric(List<T> obj, Function<T, S> converter) {
        AjaxJson<List<S>> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(SUCCESS_CODE);
        List<S> convertedData = obj.stream().map(converter).collect(Collectors.toList());
        ajaxJson.setData(convertedData);
        return ajaxJson;
    }


    public static <T> AjaxJson<T> errorGeneric() {
        AjaxJson<T> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(ERROR_CODE);
        ajaxJson.setStatusMsg("操作失败");
        return ajaxJson;
    }

    public static <T> AjaxJson<T> errorGeneric(String errorCode, String msg) {
        AjaxJson<T> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(errorCode);
        ajaxJson.setStatusMsg(msg);
        return ajaxJson;
    }

    public static <T> AjaxJson<T> errorGeneric(String msg) {
        AjaxJson<T> ajaxJson = new AjaxJson<>();
        ajaxJson.setStatus(ERROR_CODE);
        ajaxJson.setStatusMsg(msg);
        return ajaxJson;
    }


}
