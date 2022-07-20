package club.chishazi.ecsservice.utils;

public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(400, "失败"),
    /**
     * 未认证
     */
    UNAUTHORIZED(401, "未认证"),
    /**
     * 接口不存在
     */
    NOT_FOUND(404, "接口不存在"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
