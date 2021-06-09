package entity;

public class Request {

	private int id;
	private String code;
	private int request;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getRequest() {
		return request;
	}

	public void setRequest(int request) {
		this.request = request;
	}

	public Request(int id, String code, int request) {
		super();
		this.id = id;
		this.code = code;
		this.request = request;
	}

	public Request() {
		super();

	}

}
