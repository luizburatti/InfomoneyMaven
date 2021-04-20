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

public class PostDollarServelet {

	public void store() {

		try {
			CotationDao cotationDao = new CotationDao();

			String sURL = "https://economia.awesomeapi.com.br/last/USD-BRLT,USD-BRL,CAD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,JPY-BRL,CHF-BRL,AUD-BRL,CNY-BRL,ILS-BRL"; // just a string

			// Connect to the URL using java's native library
			URL url = new URL(sURL);
			URLConnection json = url.openConnection();
			json.connect();

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); // from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent(), "UTF-8")); // Convert the input
																									// stream
																									// to a json element
			JsonObject rootobj = root.getAsJsonObject(); // May be an array, may be an object.
			JsonElement code = rootobj; // Get value by code name

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			// Convertendo um objeto Java para JSON e retorna uma String JSON formatada.
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
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
