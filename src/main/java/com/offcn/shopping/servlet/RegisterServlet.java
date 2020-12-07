package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.User;
import com.offcn.shopping.service.UserService;
import com.offcn.shopping.service.impl.UserServiceImpl;
import com.offcn.shopping.util.DBUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
       String username= request.getParameter("username");
       String password=request.getParameter("password");
       String email=request.getParameter("email");
       String name=request.getParameter("name");
       String sex=request.getParameter("sex");
       Date birthday=DBUtils.stringToDate(request.getParameter("birthday"));



       User user=new User();
       user.setUsername(username);
       user.setPassword(password);
       user.setEmail(email);
       user.setBirthday(birthday);
       user.setName(name);
       user.setSex(sex);
        //UserService userService=new UserServiceImpl();
       // boolean flag=userService.addUser(user);
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        UserService userService = context.getBean("UserService", UserService.class);
        boolean flag=userService.addUser(user);
        if(flag){
            System.out.println("注册成功");
            response.sendRedirect("/jsp/login.jsp");
        }else{
            System.out.println("注册失败");
            response.sendRedirect("/jsp/register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
