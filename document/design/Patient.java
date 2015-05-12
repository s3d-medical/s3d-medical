

/**
 * @author Administrator
 * @version 1.0
 * @created 10-ÎåÔÂ-2015 10:19:12
 */
public class PatientInfo {

	private String fullName;
	private int sex;
	private Date birthDate;
	private int ageYear;
	private String nationality;
	private int ageMonth;
	private float birthWeight;
	private String idCardNo;
	private int maritalStatus;
	public Company company;
	public ContactPerson contactPerson;
	public NativePlace nativePlace;
	public PresentAddress presentAddress;
	public RegisteredResidence registeredResidence;

	public PatientInfo(){

	}

	public void finalize() throws Throwable {

	}
	public String getfullName(){
		return fullName;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setfullName(String newVal){
		fullName = newVal;
	}

	public int getsex(){
		return sex;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setsex(int newVal){
		sex = newVal;
	}

	public Date getbirthDate(){
		return birthDate;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setbirthDate(Date newVal){
		birthDate = newVal;
	}

	public int getage(){
		return age;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setage(int newVal){
		age = newVal;
	}

	public String getnationality(){
		return nationality;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnationality(String newVal){
		nationality = newVal;
	}

	public int getageMonth(){
		return ageMonth;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setageMonth(int newVal){
		ageMonth = newVal;
	}

	public float getBirthWeight(){
		return BirthWeight;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBirthWeight(float newVal){
		BirthWeight = newVal;
	}

	public String getidCardNo(){
		return idCardNo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setidCardNo(String newVal){
		idCardNo = newVal;
	}
}//end PatientInfo