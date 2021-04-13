package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO {

	public boolean esisteParola(String parola) {
		
		String sql = "select * "
				   + "from parola "
				   + "where nome = ?";
		
		String result = "";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			
			result = rs.getString("nome");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(result=="") {
			return false;
		} else {
			return true;
		}
		
	}
	
}
