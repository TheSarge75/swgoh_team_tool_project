package com.jonesGroup.swgoh.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Manufacturer {

    private String name;

    private static String GET_ALL_SQL = "SELECT * FROM MANUFACTURER";

    public Manufacturer(){}

    public Manufacturer(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    // Get the list of Manufacturer name Strings from the AWS RDS table MANUFACTURER
    public static ArrayList<Manufacturer> getAllManufacturers(){
        ArrayList<Manufacturer> manufacturerList = new ArrayList<>();

        try {
            System.out.println("Start of db operation");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://swgohtool.cxnhli5rhy3i.us-east-2.rds.amazonaws.com/innodb",
                    // The username and password need to be obtained dynamically, and not be hard-coded;
                    "some user name",
                    "some key"
            );
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_SQL);
            while (rs.next()){
                manufacturerList.add(new Manufacturer(rs.getString(1)));
            }
            System.out.println("End of db operation");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return manufacturerList;
    }
}
