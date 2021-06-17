package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Dao;
import entity.Moeda;
import entity.Users;

public class UserDao extends Dao {
	private static final String INSERT = "INSERT INTO user (nome,cpf,senha,email) VALUES (?,?,?,?)";
	private static final String SELECTEMAIL = "SELECT * FROM user WHERE email = ?";

	// Salva no banco
	public void store(Users user) {

		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INSERT);) {

			pst.setString(1, user.getNome());
			pst.setString(2, user.getCpf());
			pst.setString(3, user.getSenha());
			pst.setString(4, user.getEmail());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Users> getUser (String email) {
		ArrayList<Users> findUser = new ArrayList<Users>();
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTEMAIL);) {

			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setCpf(rs.getString("cpf"));
				user.setSenha(rs.getString("senha"));
				user.setEmail(rs.getString("email"));
				

				findUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return findUser;

	}

}
