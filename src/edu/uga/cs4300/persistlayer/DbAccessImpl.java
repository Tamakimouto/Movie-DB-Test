package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccessImpl extends DbAccessConfiguration implements DbAccessInterface {

    public Connection connect() {
        Connection con = null;
        try {
            Class.forName(DB_DRIVE_NAME);
            con = DriverManager.getConnection(DB_CONNECTION_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public ResultSet retrieve(Connection con, String query) {
        ResultSet rset = null;
        try {
            Statement stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            return rset;
        } catch (SQLException e) {
            e.printStackTrace();
            return rset;
        }
    }

    public int create(Connection con, String query) {
        int numCreated = 0;
        try {
            Statement st = con.createStatement();
            numCreated = st.executeUpdate(query);
            return numCreated;
        } catch (SQLException e) {
            e.printStackTrace();
            return numCreated;
        }
    }

    public int update(Connection con, String query){
        int numUpdated = 0;
        try {
            Statement st = con.createStatement();
            numUpdated = st.executeUpdate(query);
            return numUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
            return numUpdated;
        }
    }

    public int delete(Connection con, String query) {
        int numDeleted = 0;
        try {
            Statement st = con.createStatement();
            numDeleted = st.executeUpdate(query);
            return numDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
            return numDeleted;
        }
    }

    public void disconnect(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
