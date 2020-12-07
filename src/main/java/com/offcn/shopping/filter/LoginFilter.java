package com.offcn.shopping.filter;

import com.offcn.shopping.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns={"/jsp/AddCartServlet","/jsp/DeleteCartServlet","/jsp/cart.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;
       HttpSession session=request.getSession();
       User user=(User)session.getAttribute("user");
       if(user==null){
      response.sendRedirect(request.getContextPath()+"/jsp/login.jsp?message=pleaselogin");
       }
       else {
           chain.doFilter(req, resp);
           System.out.println("离开过滤器");
       }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化");
    }

}
