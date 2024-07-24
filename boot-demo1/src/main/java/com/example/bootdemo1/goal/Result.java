package com.example.bootdemo1.goal;
import java.util.List;

public class Result {
    private int code;
    private String message;
    private List<Recommend> data;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Recommend> getData() {
        return data;
    }

    public void setData(List<Recommend> data) {
        this.data = data;
    }

}
