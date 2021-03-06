package com.whisper.forum.response;

public class ResponseResult {
    private String message;
    private boolean success;
    private int code;


    private Object data;
    public ResponseResult(CommentResult commentResult){
    this.message=commentResult.getMessage();
    this.success=commentResult.isSuccess();
    this.code=commentResult.getCode();
    }
    public static ResponseResult SUCCESS() {
        return new ResponseResult(CommentResponse.SUCCESS);
    }

    public static ResponseResult SUCCESS(String message) {
        ResponseResult success = SUCCESS();
        success.setMessage(message);
        return success;
    }
    public static ResponseResult LOGIN_SUCCESS() {
        return new ResponseResult(CommentResponse.LOGIN_SUCCESS);
    }

    public static ResponseResult LOGIN_SUCCESS(String message) {
        ResponseResult success = LOGIN_SUCCESS();
        success.setMessage(message);
        return success;
    }

    public static ResponseResult FAILED() {
        return new ResponseResult(CommentResponse.FAILED);
    }
    public static ResponseResult NOFOUND() {
        return new ResponseResult(CommentResponse.NO_FOUND);
    }
    public static ResponseResult FAILED(String message) {
        ResponseResult failed = FAILED();
        failed.setMessage(message);
        return failed;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
