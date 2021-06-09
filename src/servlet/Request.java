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

@WebServlet(name = "request", urlPatterns = { "/viewdollar/request" })
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DashboardDao dashboardDao;

	public Request() {
		this.dashboardDao = new DashboardDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<entity.Request> listaRequest = dashboardDao.selectRequest();
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(listaRequest));
	}
}