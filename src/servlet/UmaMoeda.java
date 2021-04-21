package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CotationDao;
import entity.Moeda;

@WebServlet(name = "umamoeda", urlPatterns = { "/viewdollar/umamoeda" })
public class UmaMoeda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CotationDao cotationDao;

	public UmaMoeda() {
		this.cotationDao = new CotationDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valor = request.getParameter("code");
		ArrayList<Moeda> umaMoeda = cotationDao.selectOneCotation(valor);
		request.setAttribute("umaMoeda", umaMoeda);
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(umaMoeda));

	}

}
