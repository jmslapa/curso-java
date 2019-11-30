package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			st1 = conn.prepareStatement("DELETE FROM seller WHERE Name = 'Damon Hill'");
			int rowsAffected1 = st1.executeUpdate();
			/*
			int x = 1;
			if(x < 2) {
				throw new SQLException("Fake Error");
			}
			*/
			st2 = conn.prepareStatement("UPDATE seller SET BaseSalary = 2500 WHERE DepartmentId = 1");
			int rowsAffected2 = st2.executeUpdate();
			
			conn.commit();
			
			System.out.println("rowsAffected1: " + rowsAffected1);
			System.out.println("rowsAffected1: " + rowsAffected2);
		}catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back. Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback. Caused by: " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st2);
			DB.closeStatement(st1);
			DB.closeConnection();
		}
	}

}
