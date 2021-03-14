package entity;

public class Cotation {

	private int id;
	private String name;
	
	public Cotation(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Cotation(String name) {
		super();
		this.name = name;
	}
	
	public Cotation() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
