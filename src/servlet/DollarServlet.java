package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PostDollarServelet;
import dao.CotationDao;
import entity.Moeda;
import thread.PostThreadMoeda;


@WebServlet(name = "dollar", urlPatterns = { "/viewdollar/dollar" })
public class DollarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	private CotationDao cotationDao;
	
    public DollarServlet() {
       this.cotationDao = new CotationDao();
    }
    
//    private static HttpURLConnection connection;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Moeda> lista = cotationDao.selectAllCotation();
		request.setAttribute("listaTodas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewdollar/exibeContations.jsp");
		rd.forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PostDollarServelet postDollarServelet = new PostDollarServelet();
//		postDollarServelet.store();
		
		
		PostThreadMoeda post = new PostThreadMoeda("https://economia.awesomeapi.com.br/last/");
		post.start();

	}	

}
