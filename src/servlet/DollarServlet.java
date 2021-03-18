package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dao.CotationDao;


@WebServlet(name = "dollar", urlPatterns = { "/viewdollar/dollar" })
public class DollarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	private CotationDao cotationDao;
	
    public DollarServlet() {
       this.cotationDao = new CotationDao();
    }
    
    private static HttpURLConnection connection;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sURL = "https://economia.awesomeapi.com.br/json/all"; //just a string

	    // Connect to the URL using java's native library
	    URL url = new URL(sURL);
	    URLConnection json = url.openConnection();
	    json.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent())); //Convert the input stream to a json element
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
	    JsonElement codigo = rootobj.get("USD"); // Get value by code name
	    
	    //Get values by name from CODIGO 
	    JsonElement name = ((JsonObject) codigo).get("name");
	    JsonElement price = ((JsonObject) codigo).get("high");
	    JsonElement buying = ((JsonObject) codigo).get("bid");
	    JsonElement selling = ((JsonObject) codigo).get("ask");
	    JsonElement variation_high = ((JsonObject) codigo).get("high");
	    JsonElement variation_low = ((JsonObject) codigo).get("low");
	    JsonElement date = ((JsonObject) codigo).get("create_date");
		response.getWriter().append(codigo+""+ name + price + buying + selling + variation_high + variation_low + date);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
