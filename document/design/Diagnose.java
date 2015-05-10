package entity;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-ÎåÔÂ-2015 14:14:05
 */
public class Diagnose {

	private String name;
	private String code;

	public Diagnose(){

	}

	public void finalize() throws Throwable {

	}
	public String getname(){
		return name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setname(String newVal){
		name = newVal;
	}

	public String getcode(){
		return code;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcode(String newVal){
		code = newVal;
	}
}//end Diagnose