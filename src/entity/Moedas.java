package entity;


import lombok.Data;

@Data
public class Moedas {
	
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
	private String create_date;

	public Moedas() {

	}
}
