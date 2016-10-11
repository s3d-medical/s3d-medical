/**
 * 
 */
package com.s3d.tech.exception;


/**
 * 用户自定义的non check类型的exception
 * @author chenzhigang
 * @since 2016-09-20
 *
 */
public class CustException extends RuntimeException implements ICustError {
	private static final long serialVersionUID = -4258230578179000594L;

    /**
     * 自定义的错误, 包含描述和
     */
	private ICustError err;

    /**
     * 没有预先定义的error code，只是简单暴露出错误
     * @param errDesc     用户给定的错误描述, 主要用于错误日志记录,不做为用户提示， 也可显示给客户端
     */
    public CustException(String errDesc) {
        super(errDesc);
        this.err = new CustError("uncategoried", errDesc);
    }

    /**
     * @param errorCode       自定义的错误码
     * @param errDesc
     */
	public CustException(String errorCode, String errDesc) {
		super(errDesc);
		this.err = new CustError(errorCode, errDesc);
	}

    /**
     *  try catch到其他类型的exception, 进行抛出时使用.
     *  (如果给定是CustException类型的错误， 多次try catch抛出后，可能会出现丢失code的问题).
     * @param errDesc
     * @param throwable
     */
    public CustException(String errorCode, String errDesc, Throwable throwable) {
        super(errDesc, throwable);
        this.err = new CustError(errorCode, errDesc);
    }

    /**
     *  已知 ICustError
     * @param err
     */
    public CustException(ICustError err) {
        super(err.getErrDesc());
        this.err = err;
    }

	/**
	 * try catch 到的其他类型的exception.
	 * @param err
	 * @param throwable
	 */
	public CustException(ICustError err, Throwable throwable) {
		super(err.getErrDesc(), throwable);
		this.err = err;
	}

    public ICustError getError(){
		return this.err;
	}

    /**
     * 返回错误代码
     * @return
     */
    public String getErrCode() {
        return this.err.getErrCode();
    }

    @Override
    public String getErrDesc() {
        return this.err.getErrDesc();
    }
}
