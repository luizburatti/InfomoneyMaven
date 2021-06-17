package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.MalformedJwtException;
import jwtAuth.JwtAuth;

@WebServlet(name = "createuser", urlPatterns = { "/user/createuser" })
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userdao;

	public CreateUser() {
		this.userdao = new UserDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");

		Users user = new Users();
		user.setNome(name);
		user.setCpf(cpf);
		user.setSenha(senha);
		user.setEmail(email);

		userdao.store(user);

		// Set response content type
		response.setContentType("text/html");

		// New location to be redirected
		String site = new String("http://localhost:8080/infomoney/user/login3.0.jsp");

		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
		
		
		
		
		

	}

}
