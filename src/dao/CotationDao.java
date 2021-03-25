package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Dao;
import entity.Moedas;

public class CotationDao extends Dao{
	
	private static final String INSERT = "INSERT INTO Moedas (code,codein,name,high,low,varBid,ask,pctChange,bid,timestamp,create_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT = "SELECET * FROM VALUES_COTATION";
	private static final String SELECTCODE = "SELECET * FROM VALUES_COTATION WHERE CODE = ?";
	private static final String DELETE = "DELETE FROM VALUES_COTATION WHERE ID = ?";

	 
	//Salva no banco
	public void store(Moedas cotation){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
		
			pst.setString(1, cotation.getCode());
			pst.setString(2, cotation.getCodein());
			pst.setString(3, cotation.getName());
			pst.setFloat(4, cotation.getHigh());
			pst.setFloat(5, cotation.getLow());
			pst.setFloat(6, cotation.getVarBid());
			pst.setFloat(7, cotation.getPctChange());
			pst.setFloat(8, cotation.getBid());
			pst.setFloat(9, cotation.getAsk());
			pst.setLong(10, cotation.getTimestamp());
			pst.setString(11, cotation.getCreate_date());
			pst.executeUpdate();	
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	//Select pela id
	public Moedas selectCotation(int id) {
		Moedas cotation = null;
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODE);)
		{
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				cotation = new Moedas();					
				cotation.setId(rs.getInt("ID"));
				cotation.setName(rs.getString("NOME"));
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cotation;
	}
	
	//list All
	
	public List<Moedas> selectAllCotation() {
		List<Moedas> listCotation = new ArrayList<Moedas>();
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Moedas cotation = new Moedas();					
				cotation.setId(rs.getInt("ID"));
				cotation.setName(rs.getString("NOME"));
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listCotation;
	}

	//Delete
	public void deleta(Moedas cotation)
	{
		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(DELETE);)
		{
			pst.setInt(1, cotation.getId());
			pst.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	 
		
	}	
	
	
	
}
