package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DashboardDao;
import entity.Moeda;

@WebServlet(name = "dashboard", urlPatterns = { "/viewdollar/dashboard" })
public class GraficoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DashboardDao dashboardDao;

	public GraficoServlet() {
		this.dashboardDao = new DashboardDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Moeda> lista = dashboardDao.selectAllCotation();
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(lista));
	}
}