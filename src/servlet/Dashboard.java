package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import controllers.DollarController;

@WebServlet(name = "dashboard", urlPatterns = { "/dashboard" })
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Dashboard() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: doGET").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("https://br.investing.com/currencies/usd-brl").get();
            
            Elements title = doc.getElementsByTag("h1");
            response.getWriter().append("\n" + title.text());
            
            Element dolar = doc.getElementById("last_last");
            response.getWriter().append("\n" + dolar.text());
            
            Elements buying = doc.getElementsByClass("pid-2103-bid");
            response.getWriter().append("\n" + buying.text());
            
            Elements selling = doc.getElementsByClass("pid-2103-ask");
            response.getWriter().append("\n" + selling.text());
            
            Elements variationLow = doc.getElementsByClass("pid-2103-low");
            response.getWriter().append("\n" + variationLow.text());
            
            Elements variationHigh = doc.getElementsByClass("pid-2103-high");
            response.getWriter().append("\n" + variationHigh.text());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
