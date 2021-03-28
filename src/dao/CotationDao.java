package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Dao;
import entity.Moeda;

public class CotationDao extends Dao{
	
	private static final String INSERT = "INSERT INTO Moedas (code,codein,name,high,low,varBid,ask,pctChange,bid,timestamp,create_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT = "SELECT * FROM Moedas";



	 
	//Salva no banco
	public void store(Moeda cotation){

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
//	public Moeda selectCotation(int id) {
//		Moeda cotation = null;
//
//		try(Connection connection = this.conectar();
//				PreparedStatement pst = connection.prepareStatement(SELECTCODE);)
//		{
//			pst.setInt(1, id);
//			ResultSet rs = pst.executeQuery();
//			
//			while(rs.next())
//			{
//				cotation = new Moeda();					
//				cotation.setId(rs.getInt("ID"));
//				cotation.setCode(rs.getString("CODE"));
//				cotation.setCodein(rs.getString("CODEIN"));
//				cotation.setName(rs.getString("NAME"));
//				cotation.setHigh(rs.getFloat("HIGH"));
//				cotation.setLow(rs.getFloat("LOW"));
//				cotation.setVarBid(rs.getFloat("VARBID"));
//				cotation.setAsk(rs.getFloat("ASK"));
//				cotation.setPctChange(rs.getFloat("PCTCHANGE"));
//				cotation.setBid(rs.getFloat("BID"));
//				cotation.setTimestamp(rs.getLong("TIMESTAMP"));
//				cotation.setCreate_date(rs.getString("CREATE_DATE"));
//				
//			}		
//			
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	//list All
	


	public  ArrayList<Moeda> selectAllCotation() {
		
		ArrayList<Moeda> listMoeda = new ArrayList<Moeda>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{				

				Moeda cotation = new Moeda();
				cotation.setId(rs.getInt("id"));
				cotation.setCode(rs.getString("code"));
				cotation.setCodein(rs.getString("codein"));
				cotation.setName(rs.getString("name"));
				cotation.setHigh(rs.getFloat("high"));
				cotation.setLow(rs.getFloat("low"));
				cotation.setVarBid(rs.getFloat("varBid"));
				cotation.setPctChange(rs.getFloat("pctChange"));
				cotation.setBid(rs.getFloat("bid"));
				cotation.setAsk(rs.getFloat("ask"));
				cotation.setTimestamp(rs.getLong("timestamp"));
				cotation.setCreate_date(rs.getString("create_date"));	
				
				listMoeda.add (cotation);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listMoeda;
		
	}

	
}
