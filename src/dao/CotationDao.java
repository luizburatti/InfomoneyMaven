 package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Dao;
import entity.Moeda;

public class CotationDao extends Dao {

	private static final String INSERT = "INSERT INTO Moedas (code,codein,name,compra,venda,maximo,minimo,diferenca_maxima_minima,variacao,porcentagem_de_variacao,valor_convertido,data_de_criacao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT = "SELECT * FROM  (SELECT * FROM Moedas ORDER BY ID DESC LIMIT 11) SUB ORDER BY ID ASC";
	private static final String SELECTCODE = "SELECT * FROM Moedas WHERE code = ?";
	private static final String SELECTCODEANDDATE = "SELECT * FROM Moedas WHERE code = ? AND data_de_criacao BETWEEN ? and ?";

	// Salva no banco
	public void store(Moeda cotation) {

		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INSERT);) {

			pst.setString(1, cotation.getCode());
			pst.setString(2, cotation.getCodein());
			pst.setString(3, cotation.getName());
			pst.setFloat(4, cotation.getCompra());
			pst.setFloat(5, cotation.getVenda());
			pst.setFloat(6, cotation.getMaximo());
			pst.setFloat(7, cotation.getMinimo());
			pst.setFloat(8, cotation.getDiferenca_maxima_minima());
			pst.setFloat(9, cotation.getVariacao());
			pst.setFloat(10, cotation.getPorcentagem_de_variacao());
			pst.setFloat(11, cotation.getValor_convertido());
			pst.setString(12, cotation.getData_de_criacao());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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

	public ArrayList<Moeda> selectOneCotation(String code ) {
		ArrayList<Moeda> listOneMoeda = new ArrayList<Moeda>();
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODE);) {
			
			pst.setString(1, code);
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
	
	public ArrayList<Moeda> selectCodeAndDate(String code, String start, String end) {
		ArrayList<Moeda> listOneMoeda = new ArrayList<Moeda>();
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODEANDDATE);) {
			
			pst.setString(1, code);
			pst.setString(2, start);
			pst.setString(3, end);
			
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

}
