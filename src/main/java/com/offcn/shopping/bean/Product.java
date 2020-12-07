package com.offcn.shopping.bean;

import java.io.Serializable;

/**
 * Created by 金喆
 */

public class Product implements Serializable {

    private Integer proId;
    private String proName ;
    private String proNum ;
    private Double marketPrice ;
    private Double shopPrice ;
    private String proColor ;
    private Integer proTotalCount ;
    private String proMaxImg ;
    private String proMinImg ;
    private Integer proState ;


    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProNum() {
        return proNum;
    }

    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public Integer getProTotalCount() {
        return proTotalCount;
    }

    public void setProTotalCount(Integer proTotalCount) {
        this.proTotalCount = proTotalCount;
    }

    public String getProMaxImg() {
        return proMaxImg;
    }

    public void setProMaxImg(String proMaxImg) {
        this.proMaxImg = proMaxImg;
    }

    public String getProMinImg() {
        return proMinImg;
    }

    public void setProMinImg(String proMinImg) {
        this.proMinImg = proMinImg;
    }

    public Integer getProState() {
        return proState;
    }

    public void setProState(Integer proState) {
        this.proState = proState;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proNum='" + proNum + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", proColor='" + proColor + '\'' +
                ", proTotalCount=" + proTotalCount +
                ", proMaxImg='" + proMaxImg + '\'' +
                ", proMinImg='" + proMinImg + '\'' +
                ", proState=" + proState +
                '}';
    }
}
