package entity;




public class Moeda {

	// VARIAVEIS QUE IRAO ARMAZENAR OS DADOS DO ARQUIVO JSON.
	private int id;
	private String code;
	private String codein;
	private String name;
	private float compra;
	private float venda;
	private float maximo;
	private float minimo;
	private float variacao;
	private float porcentagem_de_variacao;
	private float diferenca_maxima_minima;
	private float valor_convertido;
	private String data_de_criacao;
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
	public float getCompra() {
		return compra;
	}
	public void setCompra(float compra) {
		this.compra = compra;
	}
	public float getVenda() {
		return venda;
	}
	public void setVenda(float venda) {
		this.venda = venda;
	}
	public float getMaximo() {
		return maximo;
	}
	public void setMaximo(float maximo) {
		this.maximo = maximo;
	}
	public float getMinimo() {
		return minimo;
	}
	public void setMinimo(float minimo) {
		this.minimo = minimo;
	}
	public float getVariacao() {
		return variacao;
	}
	public void setVariacao(float variacao) {
		this.variacao = variacao;
	}
	public float getPorcentagem_de_variacao() {
		return porcentagem_de_variacao;
	}
	public void setPorcentagem_de_variacao(float porcentagem_de_variacao) {
		this.porcentagem_de_variacao = porcentagem_de_variacao;
	}
	public float getDiferenca_maxima_minima() {
		return diferenca_maxima_minima;
	}
	public void setDiferenca_maxima_minima(float diferenca_maxima_minima) {
		this.diferenca_maxima_minima = diferenca_maxima_minima;
	}
	public float getValor_convertido() {
		return valor_convertido;
	}
	public void setValor_convertido(float valor_convertido) {
		this.valor_convertido = valor_convertido;
	}
	public String getData_de_criacao() {
		return data_de_criacao;
	}
	public void setData_de_criacao(String data_de_criacao) {
		this.data_de_criacao = data_de_criacao;
	}
	public Moeda(int id, String code, String codein, String name, float compra, float venda, float maximo, float minimo,
			float variacao, float porcentagem_de_variacao, float diferenca_maxima_minima, float valor_convertido,
			String data_de_criacao) {
		super();
		this.id = id;
		this.code = code;
		this.codein = codein;
		this.name = name;
		this.compra = compra;
		this.venda = venda;
		this.maximo = maximo;
		this.minimo = minimo;
		this.variacao = variacao;
		this.porcentagem_de_variacao = porcentagem_de_variacao;
		this.diferenca_maxima_minima = diferenca_maxima_minima;
		this.valor_convertido = valor_convertido;
		this.data_de_criacao = data_de_criacao;
	}
	public Moeda() {
		super();
	}

	
	
}
