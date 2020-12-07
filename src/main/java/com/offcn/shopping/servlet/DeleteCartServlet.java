package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("proId"));

        HttpSession session = request.getSession();
        Map<Product, Integer>  cart  = (Map<Product,Integer>)session.getAttribute("cart");

       // Product p = null ;
        for(Product pro : cart.keySet())
        {
            if(pro.getProId() == id)
            {
               // p = pro ;
                cart.remove(pro);
                break;
            }
        }
        //cart.remove(p);

        double sum = 0 ;
        Set<Product> productSet =  cart.keySet();
        for(Product pro : productSet)
        {
            Integer num = cart.get(pro);
            sum = sum + pro.getShopPrice() * num;
        }
        session.setAttribute("totalPrice" , sum);
        
        response.sendRedirect("/jsp/cart.jsp");
    }


}
