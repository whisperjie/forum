package com.whisper.forum.response;

public enum CommentResponse implements CommentResult {
    SUCCESS(1, true, "操作成功"),
    FAILED(2, false, "操作失败"),
    PARAMS_ILL(3, false, "参数错误"),
    PERMISSION_DENIED(4, false, "权限不够"),
    NOT_LOGIN(5, false, "账号未登录"),
    LOGIN_SUCCESS(6,true, "登录成功"),
    NO_FOUND(7,false,"找不到");


    int code;
    boolean isSuccess;
    String message;

    CommentResponse(int code, boolean isSuccess, String message) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public int getCode() {
        return code;
    }

}
