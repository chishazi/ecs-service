package club.chishazi.ecsservice.utils;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {
    private Long timestamp;
    private int code;
    private String msg;
    private String trace;
    private T data;
    private Long count;

    public ApiResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public ApiResponse(ResponseCode responseCode) {
        this.timestamp = System.currentTimeMillis();
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public ApiResponse(ResponseCode responseCode, String msg) {
        this(responseCode);
        this.trace = msg;
    }

    public ApiResponse(ResponseCode responseCode, T data) {
        this(responseCode);
        this.data = data;
    }

    public ApiResponse(ResponseCode responseCode, String msg, T data) {
        this(responseCode);
        this.trace = msg;
        this.data = data;
    }

    public ApiResponse(ResponseCode responseCode, T data, Long count) {
        this(responseCode);
        this.data = data;
        this.count = count;
    }

    public ApiResponse(ResponseCode responseCode, String msg, T data, Long count) {
        this(responseCode);
        this.trace = msg;
        this.data = data;
        this.count = count;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "timestamp=" + timestamp +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", trace='" + trace + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
