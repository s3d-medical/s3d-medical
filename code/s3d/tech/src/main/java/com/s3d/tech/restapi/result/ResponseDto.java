package com.s3d.tech.restapi.result;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.s3d.tech.utils.JacksonParser;

/**
 * 远程api
 * restful api 返回值, 使用jackson进行转换.
 * @author wind.chen
 * @since 2016/9/22.
 */
public class ResponseDto implements Serializable{

    private static final long serialVersionUID = 8020750576392154044L;

    private Integer errCode = WebExceptionCode.NORMAL.errorCode;
    private String errMsg = WebExceptionCode.NORMAL.errorMsg;
    private final Map<String, Object> result = new HashMap<String, Object>();
    private String systemTime;

    public ResponseDto() {
    }

    public ResponseDto(Integer errorCode, String errorMsg,String systemTime) {
        this.systemTime = systemTime;
        this.errCode = errorCode;
        this.errMsg = errorMsg;
    }

    

    public Map<String, Object> getResult() {
        return result;
    }

    public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

   

    public String getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(String systemTime) {
        this.systemTime = systemTime;
    }

    @JsonIgnore
    public <T> T getObjInResult(String resultKey){
        return (T)this.result.get(resultKey);
    }

    /**
     *
     * @param resultKey
     * @param resultClass         list中的对象类型
     * @param <T>
     * @return
     */
    @JsonIgnore
    public <T> List<T> getObjInResult(String resultKey, Class<T> resultClass){
        // TODO 临时解决方案.
        Object resultObj = this.result.get(resultKey);
        if(resultObj == null){
            return null;
        }
        String objectInJson = JacksonParser.convertToJSONString(resultObj);

        List<T> result = JacksonParser.convertToCollection(objectInJson, List.class, resultClass);
        return result;
    }

    public boolean isSuccess(){
        return WebExceptionCode.NORMAL.errorCode.equals(this.errCode);
    }

}
