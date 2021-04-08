package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Dao;
import entity.Moeda;

public class DashboardDao extends Dao{
	
	private static final String SELECT = "SELECT * FROM  (SELECT * FROM Moedas ORDER BY ID DESC LIMIT 15) SUB ORDER BY ID ASC";
	private static final String SELECTCODE_DASH = "SELECT * FROM MOEDAS where CODE = \"USD\" ORDER BY ID DESC LIMIT 2";
	 
	
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
	
public  ArrayList<Moeda> selectOneCotation() {
		
		ArrayList<Moeda> listOneMoeda = new ArrayList<Moeda>();
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODE_DASH);)
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
				
				listOneMoeda.add (cotation);
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return listOneMoeda;
		
	}

	
}
