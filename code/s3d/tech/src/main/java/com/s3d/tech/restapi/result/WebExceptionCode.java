package com.s3d.tech.restapi.result;

public enum WebExceptionCode {

    NORMAL(0, "OK"),
    ERROR(1, "ERROR"),
    EXPIRE(2, "ERROR"),

    // 系统级
    DEFAULT_ERROR_MSG(10000, "服务器接口异常，请稍后再试!"),
    SERVEREXCEPTION(10001, "Server exception!"), // 服务器异常
    METHODDOESNOTEXIST(10002, "Method does not exist!"), // 接口不存在
    CLIENTAPIERROR(10003, "client cabinet error!"), // 接口不存在
    CLIENT_EXCEPTION(10004, "客户端异常"),

    ACCOUNTEXCEPTION(20000, "Invalid accessToken!"), // 无效的accessToken
    INVALIDACCESSTOKEN(20001, "Invalid accessToken!"), // 无效的accessToken
    PARAMEXCEPTION(20101, "Param to bean exception!"), // Param参数转换异常
    USERNOTEMPTY(20102, "User cannot be empty!"),
    ONEPARAMISEMPTY(20103, "One dto is empty!"),
    MISSINGPARAMETER(20104, "Missing parameter!"),
    UPLOADFILEEXCEPTION(20105, "upload file exception!"),

    ;
    public final Integer errorCode;
    public final String errorMsg;

    private WebExceptionCode(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
