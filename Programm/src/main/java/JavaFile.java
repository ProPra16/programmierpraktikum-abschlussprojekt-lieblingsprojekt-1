
public class JavaFile {
	String lName, lCode;
	
	public JavaFile(String Name, String Code){
		this.lName = Name;
		this.lCode = Code;
	}
	
	public void setName(String newName){
		this.lName = newName;
	}
	
	public void setCode(String newCode){
		this.lCode = newCode;
	}
	
	public String getName(){
		return this.lName;
	}
	
	public String getCode(){
		return this.lCode;
	}
}
