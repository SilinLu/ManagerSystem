package lsl.managersystem.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果类：使用链式编程，返回类本身。
 *
 * @author gukr
 *
 */
public class ResponseData implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();
    private ResponseData() {}

    //通用返回成功
    public static ResponseData success() {
        ResponseData r = new ResponseData();
        r.setCode(ResponseCode.SUCCESS.getCode());
        r.setMessage(ResponseCode.SUCCESS.getMessage());
        return r;
    }

    //通用返回失败
    public static ResponseData fail() {
        ResponseData r = new ResponseData();
        r.setCode(ResponseCode.UNSUCCESS.getCode());
        r.setMessage(ResponseCode.UNSUCCESS.getMessage());
        return r;
    }

    //自定义状态码
    public ResponseData code(Integer code) {
        this.setCode(code);
        return this;
    }

    //自定义状态信息
    public ResponseData msg(String message) {
        this.message = message;
        return this;
    }

    //自定义data
    public ResponseData data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    //自定义data
    public ResponseData data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }


    private void setCode(Integer code) {
        this.code = code;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
 
