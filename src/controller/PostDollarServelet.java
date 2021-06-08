package controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.CotationDao;
import entity.Moeda;

public class PostDollarServelet implements Runnable {

	private String url;
	private String nomeThread;
//	private boolean estaSuspensa;
//	private boolean terminar;

	public PostDollarServelet(String url, String nomeThread) {
		this.url = url;	
		this.nomeThread = nomeThread;
//		this.estaSuspensa = false;
	    new Thread(this).start();

//	    Thread t = new Thread(this);
//	    t.start();
//	    
//	    try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}


	@Override
	public void run() {	
		
		System.out.println(this.nomeThread + " Iniciada");
		
		synchronized(this) {
			while (true) {
				try {
					String sURL = this.url;
					URL url = new URL(sURL);
					URLConnection json = url.openConnection();
					json.connect();
					JsonParser jp = new JsonParser();
					JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent(), "UTF-8"));
					this.convertToElement(root);
					Thread.sleep(3000);
//					synchronized (this) {
//						while(estaSuspensa) {
//							wait();
//						}
//						if(this.terminar) {
//							break;
//						}
//						
//					}					
					
				} catch (Exception e) {
					e.printStackTrace();
				}       	        
			}
		}
		

	}

	public synchronized void convertToElement(JsonElement root) {
		JsonObject rootobj = root.getAsJsonObject();
		JsonElement code = rootobj;
		this.convertToGson(code);
	}

	private synchronized void convertToGson(JsonElement code) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String JsonConvertido = gson.toJson(code);
		this.convertToJsonObject(JsonConvertido);
	}

	private synchronized void convertToJsonObject(String JsonConvertido) {
		JSONObject jsonObjectMoedas = new JSONObject(JsonConvertido);
		this.addToIterator(jsonObjectMoedas);
	}

	private synchronized void addToIterator(JSONObject jsonObjectMoedas) {

		Iterator<String> iteratormoedas = jsonObjectMoedas.keys();

		List<Moeda> listaDeMoedas = new ArrayList<Moeda>();

		CotationDao cotationDao = new CotationDao();

		while (iteratormoedas.hasNext()) {
			JSONObject dadosMoedas = jsonObjectMoedas.getJSONObject(iteratormoedas.next());
           
			System.out.println("Thread que esta executando: " + Thread.currentThread().getName());
			
			Moeda moedas = new Moeda();
			moedas.setCode(dadosMoedas.getString("code"));
			moedas.setCodein(dadosMoedas.getString("codein"));
			moedas.setName(dadosMoedas.getString("name"));
			moedas.setCompra(dadosMoedas.getFloat("bid"));
			moedas.setVenda(dadosMoedas.getFloat("ask"));
			moedas.setMaximo(dadosMoedas.getFloat("high"));
			moedas.setMinimo(dadosMoedas.getFloat("low"));
			moedas.setDiferenca_maxima_minima(dadosMoedas.getFloat("high") - dadosMoedas.getFloat("low"));
			moedas.setVariacao(dadosMoedas.getFloat("varBid"));
			moedas.setPorcentagem_de_variacao(dadosMoedas.getFloat("pctChange"));
			moedas.setValor_convertido(1 / dadosMoedas.getFloat("bid"));
			moedas.setData_de_criacao(dadosMoedas.getString("create_date"));

			listaDeMoedas.add(moedas);
			cotationDao.store(moedas);
			
			System.out.println(this.nomeThread + " Finalizada");			
		}
		
		
	}
//	void suspend() {
//		this.estaSuspensa = true;
//	}
//	synchronized void resume() {
//		this.estaSuspensa = false;
//		notify();
//	}
//	synchronized void stop() {
//		this.terminar = true;
//		notify();
//	}
}
