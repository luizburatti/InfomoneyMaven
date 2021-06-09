package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Dao;
import entity.Request;

public class RequestDao extends Dao {

	 private static final String INSERT = "INSERT INTO request (code) VALUES (?)" ;
	
	// Salva no banco
		public void store(Request request) {

			try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INSERT);) {

				pst.setString(1, request.getCode());
				pst.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	
}
