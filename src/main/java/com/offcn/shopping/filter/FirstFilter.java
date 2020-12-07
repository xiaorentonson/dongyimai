package com.offcn.shopping.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/LoginServlet"})
public class FirstFilter implements Filter {
    public void destroy() {
        System.out.println("销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        System.out.println("进入过滤器");
        chain.doFilter(req, resp);
        System.out.println("离开过滤器");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化");
    }

}
