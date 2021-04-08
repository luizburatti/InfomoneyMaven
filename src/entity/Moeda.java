package entity;

import lombok.Data;

@Data
public class Moeda {
	
	//VARIAVEIS  QUE  IRAO  ARMAZENAR  OS DADOS DO ARQUIVO JSON.
	private int id;
	private String code;
	private String codein;
	private String name;
	private float high;
	private float low;
	private float varBid;
	private float pctChange;
	private float bid;
	private float ask;
	private long timestamp;
	private float cents;
	private String create_date;
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
	public String getCodein() {
		return codein;
	}
	public void setCodein(String codein) {
		this.codein = codein;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getVarBid() {
		return varBid;
	}
	public void setVarBid(float varBid) {
		this.varBid = varBid;
	}
	public float getPctChange() {
		return pctChange;
	}
	public void setPctChange(float pctChange) {
		this.pctChange = pctChange;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public float getCents() {
		return cents;
	}
	public void setCents(float cents) {
		this.cents = cents;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public Moeda(int id, String code, String codein, String name, float high, float low, float varBid, float pctChange,
			float bid, float ask, long timestamp, float cents, String create_date) {
		super();
		this.id = id;
		this.code = code;
		this.codein = codein;
		this.name = name;
		this.high = high;
		this.low = low;
		this.varBid = varBid;
		this.pctChange = pctChange;
		this.bid = bid;
		this.ask = ask;
		this.timestamp = timestamp;
		this.cents = cents;
		this.create_date = create_date;
	}
	public Moeda() {
		super();
	}

	

	
}
