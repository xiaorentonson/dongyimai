<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.offcn.shopping.bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        onload=function(){
            var j=8;
            setInterval(function fun(){
                j++;
                var img=document.getElementById("imgs");
                img.src="../img/img"+j+".jpg";
                if(j==9){
                    j=7;
                }
            },2000);
        }
    </script>
</head>
<body>

<table width="100%">
    <!--第一行：存放logo信息   嵌套一个一行三列的表格 -->
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td>
                        <img src="../img/logo.jpg">
                    </td>
                    <td align="center">
                        <img src="../img/img5.jpg">&nbsp;&nbsp;&nbsp;
                        <img src="../img/img6.jpg">&nbsp;&nbsp;&nbsp;
                        <img src="../img/img7.jpg">&nbsp;&nbsp;&nbsp;
                        <img src="../img/img4.jpg">&nbsp;&nbsp;&nbsp;
                    </td>
                    <%--                    <td align="center">--%>
                    <%--                        <c:choose>--%>
                    <%--                            <c:when test="${SessionScope.user!=null}">--%>
                    <%--                                <font color="#337AB7">欢迎您，${SessionScope.user.username}</font>--%>
                    <%--                                <a href="#"><font color="#337AB7">退出</font></a>&nbsp;&nbsp; &nbsp;--%>
                    <%--                                <a href="#"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;--%>
                    <%--                            </c:when>--%>

                    <%--                        <c:otherwise>--%>
                    <%--                        <a href="#"><font color="#337AB7">注册</font></a>&nbsp;&nbsp;--%>
                    <%--                        <a href="#"><font color="#337AB7">登陆</font></a>&nbsp;&nbsp;--%>
                    <%--                        <a href="#"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;--%>
                    <%--                        </c:otherwise>--%>
                    <%--                        </c:choose>--%>
                    <%--                    </td>--%>
                    <td align="center">
                        <c:choose>
                            <c:when test="${sessionScope.user != null}">
                                <font color="#337AB7">欢迎您，${sessionScope.user.username}</font>&nbsp;&nbsp;
                                <a href="/jsp/login.jsp"><font color="#337AB7">退出</font></a>&nbsp;&nbsp;
                                <a href="#"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;
                            </c:when>
                            <c:otherwise>
                                <a href="#"><font color="#337AB7">注册</font></a>&nbsp;&nbsp;
                                <a href="#"><font color="#337AB7">登陆</font></a>&nbsp;&nbsp;
                                <a href="#"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <!--第二行：存放菜单信息  背景黑色 超链接颜色为白色-->

    <tr bgcolor="#808080" height="50px">
        <td>
            <a href=""><font color="white">首页</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">精品手机</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">数码时尚</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">办公设备</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">主板显卡</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">智能设备</font></a>&nbsp;&nbsp;&nbsp;
            <a href=""><font color="white">MacBook</font></a>&nbsp;&nbsp;&nbsp;
        </td>

    </tr>


    <!--第三行： 轮播图-->

    <tr>
        <td>
            <p></p>
            <img src="../img/img8.jpg" id="imgs" width="100%" height="350px">

        </td>

    </tr>

    <!--第四行：存放热门商品信息  需要嵌套一个四行五列的表格  涉及到行列合并-->
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td colspan="5">
                        <font size="5">热门商品</font>
                        <img src="../img/title2.jpg">
                    </td>
                </tr>
                <tr align="center">
                    <c:forEach items="${hotList}" var="product" begin="0" end="4">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductInfoServlet?proId=${product.proId}">
                                <img src="${product.proMinImg}" width="70%"/><br />
                                <font color="red">${product.shopPrice}</font><br />
                                <span>${product.proName}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
                <tr align="center">
                    <%--                    <% for(int i=0;i<10;i++){--%>
                    <%--                    %>--%>
                    <%--                    <font color="red"><%=i%></font>--%>
                    <%--                    <%--%>
                    <%--                        }--%>
                    <%--                    %>--%>
                    <%--                    <c:forEach items="${hostList}" var="product" begin="0" end="4">--%>
                    <%--                            <td>--%>
                    <%--                                <a href="${pageContext.request.contextPath}/ProductInfoServlet?proId=${product.proId}">--%>
                    <%--                                    <img src="${product.proMinImg}" width="70%"/><br />--%>
                    <%--                                    <font color="red">${product.shopPrice}</font><br />--%>
                    <%--                                    <span>${product.proName}</span>--%>
                    <%--                                </a>--%>
                    <%--                            </td>--%>

                    <%--                    </c:forEach>--%>
                    <%--                </tr>--%>
                <tr align="center">
                    <c:forEach items="${hotList}" var="product" begin="5" end="9">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductInfoServlet?proId=${product.proId}">
                                <img src="${product.proMinImg}" width="70%"/><br />
                                <font color="red">${product.shopPrice}</font><br />
                                <span>${product.proName}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
                <tr align="center">
                    <c:forEach items="${hotList}" var="product" begin="10" end="14">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductInfoServlet?proId=${product.proId}">
                                <img src="${product.proMinImg}" width="70%"/><br />
                                <font color="red">${product.shopPrice}</font><br />
                                <span>${product.proName}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <p></p>
            <p></p>
            <img src="../img/img2.webp" width="100%">
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%">
                <%--                <%--%>
                <%--               List<Product> optList=(List<Product>)request.getAttribute("optList");--%>
                <%--               %>--%>
                <%--                <tr>--%>
                <%--                    <%--%>
                <%--                        for(int j=0;j<optList.size();j++){--%>
                <%--                    %>--%>
                <%--                    <td>--%>
                <%--                        <img src="<%=hotList.get(j).getProMinImg()%>" width="70%"/><br />--%>
                <%--                        <font color="red"><%=hotList.get(j).getShopPrice()%></font><br />--%>
                <%--                        <span><%=hotList.get(j).getProName()%></span>--%>
                <%--                    </td>--%>

                <%--                    <%--%>
                <%--                        }--%>
                <%--                    %>--%>
                <%--                </tr>--%>
                <%--                <tr>--%>
                <%--                    <td colspan="5">--%>
                <%--                        <font size="5">优选商品</font>--%>
                <%--                        <img src="../img/title2.jpg">--%>
                <%--                    </td>--%>
                <%--                </tr>--%>
                <%--                <tr align="center">--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00001min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：1499</font><br />--%>
                <%--                        <span>荣耀9X</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/ry00003min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：3210</font><br />--%>
                <%--                        <span>荣耀20 李现同款</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00003min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：999</font><br />--%>
                <%--                        <span>荣耀20i 3200万</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00004min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：1999</font><br />--%>
                <%--                        <span>Redmi 8A 5000m</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00005min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：1399</font><br />--%>
                <%--                        <span>Redmi Note8Pro </span>--%>
                <%--                    </td>--%>
                <%--                </tr>--%>
                <%--                <tr align="center">--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00001min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：1499</font><br />--%>
                <%--                        <span>荣耀9X</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/ry00003min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：3210</font><br />--%>
                <%--                        <span>荣耀20 李现同款</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00003min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：999</font><br />--%>
                <%--                        <span>荣耀20i 3200万</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00004min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：1999</font><br />--%>
                <%--                        <span>Redmi 8A 5000m</span>--%>
                <%--                    </td>--%>
                <%--                    <td>--%>
                <%--                        <img src="../img/hm00005min.jpg" width="70%"/><br />--%>
                <%--                        <font color="red">￥：1399</font><br />--%>
                <%--                        <span>Redmi Note8Pro </span>--%>
                <%--                    </td>--%>
                <%--                </tr>--%>
                <tr>
                    <td colspan="5">
                        <font size="5">优选商品</font>
                        <img src="${pageContext.request.contextPath}/img/title2.jpg">
                    </td>
                </tr>
                <tr align="center">
                    <c:forEach items="${optList}" var="product" begin="0" end="4">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductInfoServlet?proId=${product.proId}">
                                <img src="${product.proMinImg}" width="70%"/><br />
                                <font color="red">${product.shopPrice}</font><br />
                                <span>${product.proName}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>

                <tr align="center">
                    <c:forEach items="${optList}" var="product" begin="5" end="9">
                        <td>
                            <a href="${pageContext.request.contextPath}/ProductInfoServlet?proId=${product.proId}">
                                <img src="${product.proMinImg}" width="70%"/><br />
                                <font color="red">${product.shopPrice}</font><br />
                                <span>${product.proName}</span>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <p></p>
            <p></p>
            <img src="../img/img1.webp" width="100%">
        </td>
    </tr>
    <!--第八行：存放友情链接-->
    <tr>
        <td>
            <p align="center">
                <a href=""><font color="#337AB7">关于我们</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">联系我们</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">联系客服</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">合作招商</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">商家帮助</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">营销中心</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">手机帮助</font></a>&nbsp;&nbsp;
                <a href=""><font color="#337AB7">销售联盟</font></a>&nbsp;&nbsp;
            </p>
        </td>
    </tr>
    <!--第九行：存放版权信息-->
    <tr>
        <td align="center">
            &copy;  2005-2020 东易买 版权所有，并保留所有权利
        </td>
    </tr>

</table>

</body>

</html>
