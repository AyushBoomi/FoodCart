package com.example.foodcart;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDbUtil {

    public static List<Food> getFoodList() throws ClassNotFoundException, SQLException {

        ArrayList<Food> foodList=new ArrayList<>();
        Dotenv dotenv = Dotenv.configure()
                .directory("/Users/ayushparihar/Documents/Java_practice/foodcart/.env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        String url=dotenv.get("url");
        String userName=dotenv.get("userName");
        String password=dotenv.get("password");



        Class.forName("com.mysql.jdbc.Driver");

        Connection con=DriverManager.getConnection(url,userName,password);

        Statement statement=con.createStatement();

        ResultSet rs = statement.executeQuery("select * from food");

        while (rs.next()){
            int id=rs.getInt(1);
            String item= rs.getString(2);
            float price=rs.getFloat(3);

            Food food=new Food(id,item,price);
            foodList.add(food);
        }

        con.close();
        return foodList;
        }



}
