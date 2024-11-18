package top.vertical.common;



import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @author: lly
 * @param <T>
 */


@Data
public class R<T> implements Serializable {

    private Integer code; // 状态码
    private String msg; // 状态信息
    private T data; // 返回的数据

    public static <T> R<T> success(T data) {
        R<T> result = new R<T>();
        result.msg = "操作成功"; // 设置成功的msg
        result.code = 1;
        result.data = data;
        return result;
    }
    public static <T> R<T> success() {
        R<T> result = new R<T>();
        result.msg = "操作成功"; // 设置成功的msg
        result.code = 1;
        return result;
    }

    public static <T> R<T> error(String msg) {
        R<T> result = new R<T>();
        result.code = 0;
        result.msg = msg;
        return result;
    }





}
