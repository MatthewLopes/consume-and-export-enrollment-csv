package model;

public class User {
	
	public User(String id, String fullName, int version, String insurer) {
		this.id = id;
		this.fullName = fullName;
		this.version = version;
		this.insurer = insurer;
	}
	
	private String id;
	private String fullName;
	private int version;
	private String insurer;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getInsurer() {
		return insurer;
	}
	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}
}
