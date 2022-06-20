
public class User {
	private String id,password,name;
	private boolean isAdm; //�O�_���޲z�̡A�_�������b��
	
	public User(String id, String password, String name, boolean isAdm) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.isAdm = isAdm;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getIsAdm() {
		return this.isAdm;
	}
}
