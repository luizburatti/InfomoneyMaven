package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Dao;
import entity.Moeda;
import entity.Request;

public class DashboardDao extends Dao {

	private static final String SELECT = "SELECT * FROM  (SELECT * FROM Moedas ORDER BY ID DESC LIMIT 11) SUB ORDER BY ID ASC";
	private static final String SELECTCODE_DASH = "SELECT * FROM Moedas WHERE CODE = 'USD' ORDER BY ID ASC";
	private static final String SELECTCODE_REQUESTS = "SELECT *, COUNT(*) AS request FROM Request GROUP BY code";

	public ArrayList<Moeda> selectAllCotation() {

		ArrayList<Moeda> listMoeda = new ArrayList<Moeda>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(SELECT);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Moeda cotation = new Moeda();
				cotation.setId(rs.getInt("id"));
				cotation.setCode(rs.getString("code"));
				cotation.setCodein(rs.getString("codein"));
				cotation.setName(rs.getString("name"));
				cotation.setCompra(rs.getFloat("compra"));
				cotation.setVenda(rs.getFloat("venda"));
				cotation.setMaximo(rs.getFloat("maximo"));
				cotation.setMinimo(rs.getFloat("minimo"));
				cotation.setDiferenca_maxima_minima(rs.getFloat("diferenca_maxima_minima"));
				cotation.setVariacao(rs.getFloat("variacao"));
				cotation.setPorcentagem_de_variacao(rs.getFloat("porcentagem_de_variacao"));
				cotation.setValor_convertido(rs.getFloat("valor_convertido"));
				cotation.setData_de_criacao(rs.getString("data_de_criacao"));

				listMoeda.add(cotation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listMoeda;

	}

	public ArrayList<Moeda> selectOneCotation() {

		ArrayList<Moeda> listOneMoeda = new ArrayList<Moeda>();
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODE_DASH);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Moeda cotation = new Moeda();
				cotation.setId(rs.getInt("id"));
				cotation.setCode(rs.getString("code"));
				cotation.setCodein(rs.getString("codein"));
				cotation.setName(rs.getString("name"));
				cotation.setCompra(rs.getFloat("compra"));
				cotation.setVenda(rs.getFloat("venda"));
				cotation.setMaximo(rs.getFloat("maximo"));
				cotation.setMinimo(rs.getFloat("minimo"));
				cotation.setDiferenca_maxima_minima(rs.getFloat("diferenca_maxima_minima"));
				cotation.setVariacao(rs.getFloat("variacao"));
				cotation.setPorcentagem_de_variacao(rs.getFloat("porcentagem_de_variacao"));
				cotation.setValor_convertido(rs.getFloat("valor_convertido"));
				cotation.setData_de_criacao(rs.getString("data_de_criacao"));

				listOneMoeda.add(cotation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOneMoeda;

	}

	public ArrayList<Request> selectRequest() {

		ArrayList<Request> listRequest = new ArrayList<Request>();
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODE_REQUESTS);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Request request = new Request();
				request.setId(rs.getInt("id"));
				request.setCode(rs.getString("code"));
				request.setRequest(rs.getInt("request"));

				listRequest.add(request);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listRequest;

	}

}
