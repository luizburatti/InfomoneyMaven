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

@WebServlet(name = "login", urlPatterns = { "/user/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userdao;
	private String name;
	private String email;

	public Login() {

		this.userdao = new UserDao();
		this.name = "";
		this.email = "";

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		// New location to be redirected
		String site = new String("http://localhost:8080/infomoney/viewdollar/dollar");

		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		email = request.getParameter("email");
		String senha = request.getParameter("senha");

		System.out.println(email + senha );
		
		ArrayList<Users> user = userdao.getUser(email);
		System.out.println(user);
		
		for (Users users : user) {

			System.out.println(users);
			if (users.getSenha().equals(senha)) {

				name = users.getNome();

				this.createToken(request, response);

			}

			else {

				response.getWriter().append(" Senha Invalida!").append(request.getContextPath());

			}

		}

	}

	private void createToken(HttpServletRequest request, HttpServletResponse response) {

		String resultJwt = new JwtAuth(name, email).jwt();

		System.out.println(resultJwt);

		if (resultJwt != null) {
			this.ValidToken(resultJwt, request, response);

		}

	}

	private void ValidToken(String Token, HttpServletRequest request, HttpServletResponse response) {

		try {

			Jws<Claims> decode = new JwtAuth(name, email).decodeToken(Token);

			if (decode != null) {

				response.addHeader("Authorization", "Bearer " + decode);
				
				System.out.println(decode);
				
				try {

					doGet(request, response);

				} catch (Exception e) {

					e.getStackTrace();
				}

			}

		} catch (MalformedJwtException e) {
			// TODO: handle exception
		}

	}

}
