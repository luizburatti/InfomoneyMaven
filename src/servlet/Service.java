package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connection.Dao;


@WebServlet(name = "teste", urlPatterns = { "/Service" })
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao = new Dao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Testa conexão com o banco myqsl);
		dao.TesteConexao();		
	}

}
