package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, "Damon Hill");
			st.setString(2, "d.hill@f1.com.uk");
			st.setDate(3, new Date(sdf.parse("17/09/1960").getTime()));
			st.setDouble(4, 1000000.00);
			st.setInt(5, 4);
			
			int rowsAffecteds = st.executeUpdate();
			if(rowsAffecteds > 0) {
				ResultSet rs = st.getGeneratedKeys();
				System.out.println("Insertions:");
				while(rs.next()) {
					System.out.println(Integer.toString(rs.getInt(1)));
				}
				DB.closeResultSet(rs);
			}else {
				System.out.println("No rows affected");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
