package com.forecast;

import java.sql.*;

public class DBAccess {
    private String url = "jdbc:mysql://localhost:3306/forecast_schema";
    private String user = "root";
    private String password = "root";
    public ResultSet queryDB(String query){
        try {
            Connection myCon = DriverManager.getConnection(url, user, password);
            Statement myStmnt = myCon.createStatement();
            ResultSet rs= myStmnt.executeQuery(query);
            while(rs.next()){
                return rs;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
