package lsl.managersystem.config;

public enum ResponseCode {
    SUCCESS(200, "成功"),
    NOT_FOUND(404, "连接未找到"),
    BAD_REQUEST(400, "请求无效"),
    UNSUCCESS(10000,"失败"),
    //....等等
    ;
    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}