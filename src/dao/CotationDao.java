package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Dao;
import entity.Cotation;

public class CotationDao extends Dao{
	
	private static final String INSERT = "INSERT INTO VALUES_COTATION (CODE, NAME, PRICE, BUYING, SELLING, VARIATION_LOW, VARIATION_HIGH) VALUES (?,?,?,?,?,?,?)";
	private static final String SELECT = "SELECET * FROM VALUES_COTATION";
	private static final String SELECTCODE = "SELECET * FROM VALUES_COTATION WHERE CODE = ?";
	private static final String DELETE = "DELETE FROM VALUES_COTATION WHERE ID = ?";

	 
	//Salva no banco
	public void store(Cotation cotation){

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(INSERT);) {
			pst.setString(1, cotation.getCode());
			pst.setString(2, cotation.getName());
			pst.setString(3, cotation.getPrice());
			pst.setString(4, cotation.getBuying());
			pst.setString(5, cotation.getSelling());
			pst.setString(6, cotation.getVariation_high());
			pst.setString(7, cotation.getVariation_high());
			pst.executeUpdate();
			
			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}
	
	//Select pela id
	public Cotation selectCotation(int id) {
		Cotation cotation = null;
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODE);)
		{
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				cotation = new Cotation();					
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
	
	public List<Cotation> selectAllCotation() {
		List<Cotation> listCotation = new ArrayList<Cotation>();
		
		try(Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECT);)
		{
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Cotation cotation = new Cotation();					
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
	public void deleta(Cotation cotation)
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
