package xyz.xzgone.assemblyline.utils;


import lombok.Data;

/**
 * 全局统一返回结果类
 */
@Data
public class TheResult<T> {
    // 返回码
    private Integer code;
    // 返回消息
    private String message;
    // 返回数据
    private T data;
    public TheResult(){}
    // 返回数据
    protected static <T> TheResult<T> build(T data) {
        TheResult<T> theResult = new TheResult<T>();
        if (data != null)
            theResult.setData(data);
        return theResult;
    }
    public static <T> TheResult<T> build(T body, Integer code, String message) {
        TheResult<T> theResult = build(body);
        theResult.setCode(code);
        theResult.setMessage(message);
        return theResult;
    }
    public static <T> TheResult<T> build(T body, ResultCodeEnum resultCodeEnum) {
        TheResult<T> theResult = build(body);
        theResult.setCode(resultCodeEnum.getCode());
        theResult.setMessage(resultCodeEnum.getMessage());
        return theResult;
    }
    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> TheResult<T> ok(T data){
        TheResult<T> theResult = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }
    public TheResult<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
    public TheResult<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}
