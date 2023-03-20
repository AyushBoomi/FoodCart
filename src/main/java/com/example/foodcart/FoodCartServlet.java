package com.example.foodcart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FoodCartServlet", value = "/food")
public class FoodCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Food> foodItems = FoodCartDbUtil.getFoodList();
            request.setAttribute("foodItems",foodItems);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        String[] foodItems = {"item1","item2","item3"};

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show_food.jsp");
        requestDispatcher.forward(request,response);
    }


}
