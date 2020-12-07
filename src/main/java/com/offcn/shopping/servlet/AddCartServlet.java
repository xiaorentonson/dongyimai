package com.offcn.shopping.servlet;

import com.offcn.shopping.bean.Product;
import com.offcn.shopping.service.ProductService;
import com.offcn.shopping.service.impl.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*        //1.根据传递过来的ID 值 查出相对应的商品
        Integer id = Integer.parseInt(request.getParameter("proId"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductService productService = new ProductServiceImpl();
        Product product = productService.selectShopById(id);
        //2.创建一个购物车（Map） map的key存放要购买的商品 value存放此商品购买的数量
        Map<Product,Integer> cart = new HashMap<>();
        cart.put(product,quantity);
        //3.把购物车放到HttpSession中
        HttpSession session = request.getSession();
        session.setAttribute("cart" ,cart);

        request.getRequestDispatcher("/jsp/cart.jsp").forward(request,response);*/


        //第一次添加商品到购物车，创建一个购物车（Map),后面再加商品时，要加入到原来的购物车中
        Integer id=Integer.parseInt(request.getParameter("proId"));
        Integer quantity=Integer.parseInt(request.getParameter("quantity"));


    /*    ProductService productService=new ProductServiceImpl();
        Product product=productService.selectShopById(id);*/
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        ProductService productService = context.getBean("productService", ProductService.class);
Product product=productService.selectShopById(id);
        HttpSession session = request.getSession();
        Map<Product, Integer> cart = (Map<Product,Integer>)session.getAttribute("cart");


        if(null == cart)//表示购物车中没有cart 也就是说第一次购物  需要创建购物车
        {
            cart = new HashMap<>();
            cart.put(product,quantity);

            session.setAttribute("cart" ,cart);
        }
        else {
            //直接将商品放入购物车中即可

            // 判断购物车中是否包含正在操作的这个商品
            Set<Product> set = cart.keySet();
            boolean flag = false ;
            Product pro = null ;
            for(Product p : set)
            {
                if(product.getProId() == p.getProId())
                {
                    flag = true ;
                    pro = p;
                    break;
                }
            }
            if(flag)//说明购物车中有相同的商品 直接累积数量就可以了
            {
                Integer num = cart.get(pro);
                cart.put(pro , num + quantity);

            }
            else{
                //说明购物车中没有相同的商品 直接放入即可
                cart.put(product,quantity);
            }

        }
        double sum = 0 ;
        Set<Product> productSet =  cart.keySet();
        for(Product pro : productSet)
        {
            Integer num = cart.get(pro);
            sum = sum + pro.getShopPrice() * num;
        }
        request.setAttribute("totalPrice" , sum);

        request.getRequestDispatcher("/jsp/cart.jsp").forward(request,response);

    }


}
