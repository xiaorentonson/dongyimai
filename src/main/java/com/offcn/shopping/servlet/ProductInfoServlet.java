package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.Product;
import com.offcn.shopping.service.ProductService;
import com.offcn.shopping.service.UserService;
import com.offcn.shopping.service.impl.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductInfoServlet")
public class ProductInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受数据
        Integer id=Integer.parseInt(request.getParameter("proId"));
        //2.调用service方法
       // ProductService productService=new ProductServiceImpl();

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
       ProductService productService = context.getBean("productService", ProductService.class);
        Product  product=productService.selectShopById(id);
        //将查询出来的值放入request作用域
        request.setAttribute("product",product);
        //根据返回值跳转到对应得显示页面
        request.getRequestDispatcher("/jsp/product_info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
