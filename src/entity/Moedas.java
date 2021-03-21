package entity;




public class Moedas {
	
	//VARIAVEIS  QUE  IRAO  ARMAZENAR  OS DADOS DO ARQUIVO JSON.
	private int id;
	private String code;
	private String codein;
	private String name;
	private String high;
	private String low;
	private String varBid;
	private String pctChange;
	private String bid;
	private String ask;
	private String timestamp;
	private String create_date;
	
	public Moedas() {
		
	}	
	
	public Moedas(int id, String code, String codein, String name, String high, String low, String varBid,
			String pctChange, String bid, String ask, String timestamp, String create_date) {
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
		this.create_date = create_date;
	}
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
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getVarBid() {
		return varBid;
	}
	public void setVarBid(String varBid) {
		this.varBid = varBid;
	}
	public String getPctChange() {
		return pctChange;
	}
	public void setPctChange(String pctChange) {
		this.pctChange = pctChange;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ask == null) ? 0 : ask.hashCode());
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((codein == null) ? 0 : codein.hashCode());
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + id;
		result = prime * result + ((low == null) ? 0 : low.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pctChange == null) ? 0 : pctChange.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((varBid == null) ? 0 : varBid.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moedas other = (Moedas) obj;
		if (ask == null) {
			if (other.ask != null)
				return false;
		} else if (!ask.equals(other.ask))
			return false;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (codein == null) {
			if (other.codein != null)
				return false;
		} else if (!codein.equals(other.codein))
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (high == null) {
			if (other.high != null)
				return false;
		} else if (!high.equals(other.high))
			return false;
		if (id != other.id)
			return false;
		if (low == null) {
			if (other.low != null)
				return false;
		} else if (!low.equals(other.low))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pctChange == null) {
			if (other.pctChange != null)
				return false;
		} else if (!pctChange.equals(other.pctChange))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (varBid == null) {
			if (other.varBid != null)
				return false;
		} else if (!varBid.equals(other.varBid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Moedas [id=" + id + ", code=" + code + ", codein=" + codein + ", name=" + name + ", high=" + high
				+ ", low=" + low + ", varBid=" + varBid + ", pctChange=" + pctChange + ", bid=" + bid + ", ask=" + ask
				+ ", timestamp=" + timestamp + ", create_date=" + create_date + "]";
	}
	
	
	
	
	
	
	
	
	

}
