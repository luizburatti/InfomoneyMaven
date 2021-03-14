package controllers;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DollarController {

	public static void main(String[] args) {
		Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("https://br.investing.com/currencies/usd-brl").get();
            
            Elements title = doc.getElementsByTag("h1");
            System.out.println(title.text());
            Element dolar = doc.getElementById("last_last");
            System.out.println("Valor " + dolar.text());
            Elements buying = doc.getElementsByClass("pid-2103-bid");
            System.out.println("Valor de compra: " + buying.text());
            Elements selling = doc.getElementsByClass("pid-2103-ask");
            System.out.println("Valor de venda: " + selling.text());
            Elements variationLow = doc.getElementsByClass("pid-2103-low");
            Elements variationHigh = doc.getElementsByClass("pid-2103-high");
            System.out.println("Variação: " + variationLow.text() + " - " + variationHigh.text());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
