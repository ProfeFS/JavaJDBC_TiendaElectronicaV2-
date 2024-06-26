package edu.cesurformacion.programacion.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection instance;

	private DatabaseConnection() {
	}

	public static Connection getConnection() {

		try {
			if (instance == null || instance.isClosed()) {
				String url = "jdbc:postgresql://localhost:5432/db_tienda_e";
				String user = "postgres";
				String password = "1234";
				instance = DriverManager.getConnection(url, user, password);
				System.out.println("New connection succesfully");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to the database", e);
		}

		return instance;
	}

	public static void closeConnection() {
		if (instance != null) {
			try {
				instance.close();
				instance = null;
			} catch (SQLException e) {
				throw new RuntimeException("Error closing the database connection", e);
			}
		}
	}

}
