package model;

public class IdAndInsurer {

	public IdAndInsurer(String id, String insurer) {
		super();
		this.id = id;
		this.insurer = insurer;
	}
	private String id;
	private String insurer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInsurer() {
		return insurer;
	}
	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}
}
