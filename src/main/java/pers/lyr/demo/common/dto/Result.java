package pers.lyr.demo.common.dto;

/**
 * @Author lyr
 * @create 2020/7/14 0:53
 */

public class Result<T> {

    private Boolean flag;//是否成功
    private Integer code;//返回码
    private String message;//返回消息


    private T data;//返回数据

    public static<T> Result<T> from(String msg,Integer code,Boolean flag,T data) {
        return from(msg,code,data).setFlag(flag);
    }
    public static <Object> Result<Object> from(String msg,Integer code) {
        return new Result<Object>().setMessage(msg).setCode(code);
    }

    public static<T> Result<T> from(String msg,Integer code,T data) {
        return Result.<T>from(msg,code)
                .setData(data);
    }

    public Boolean getFlag() {
        return flag;
    }

    public Result<T> setFlag(Boolean flag) {
        this.flag = flag;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
