package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DbAccessInterface {
	 public Connection connect();   
	 public ResultSet retrieve(Connection con, String query);
	 public int create (Connection con, String query);
	 public int update (Connection con, String query);
	 public int delete (Connection con, String query);
	 public void disconnect(Connection con);
}
