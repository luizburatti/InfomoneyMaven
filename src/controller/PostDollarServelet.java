package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import dao.CotationDao;
import entity.Moeda;





public class PostDollarServelet {

public List<Moeda> findAll(){
		
		String sURL = "https://economia.awesomeapi.com.br/json/all"; //just a string

	    // Connect to the URL using java's native library
	    URL url = null;
		try {
			url = new URL(sURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    URLConnection json = null;
		try {
			json = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			json.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = null;
		try {
			root = jp.parse(new InputStreamReader((InputStream) json.getContent()));
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Convert the input stream to a json element
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
	    JsonElement code = rootobj; // Get value by code name

		
		CotationDao conect = new  CotationDao();
		  Gson gson = new GsonBuilder().setPrettyPrinting().create();
		   
		   //Convertendo um objeto Java para JSON e retorna uma String JSON formatada.
		   String JsonConvertido = gson.toJson(code);
		   
		   
		   JSONObject jsonObjectMoedas = new JSONObject(JsonConvertido);

		   List<Moeda> listaDeMoedas = new ArrayList<Moeda>();
		   
		   
		   Iterator<String> iteratormoedas = jsonObjectMoedas.keys();
		   while (iteratormoedas.hasNext()) {
			   
		      JSONObject dadosMoedas = jsonObjectMoedas.getJSONObject(iteratormoedas.next());


		      Moeda moedas = new Moeda();
		      moedas.setCode(dadosMoedas.getString("code"));
		      moedas.setCodein(dadosMoedas.getString("codein"));
		      moedas.setName(dadosMoedas.getString("name"));
		      moedas.setHigh(dadosMoedas.getFloat("high"));
		      moedas.setLow(dadosMoedas.getFloat("low"));
		      moedas.setVarBid(dadosMoedas.getFloat("varBid"));
		      moedas.setPctChange(dadosMoedas.getFloat("pctChange"));
		      moedas.setBid(dadosMoedas.getFloat("bid"));
		      moedas.setAsk(dadosMoedas.getFloat("ask"));
		      moedas.setTimestamp(dadosMoedas.getLong("timestamp"));
		      moedas.setCreate_date(dadosMoedas.getString("create_date"));

		      listaDeMoedas.add(moedas);
		      conect.store(moedas);
		   }
		return listaDeMoedas;  
		   
		
	}
	
}
