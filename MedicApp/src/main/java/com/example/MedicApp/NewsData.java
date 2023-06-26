package com.example.MedicApp;

public class NewsData {
    private String NewsTitle;
    private String NewsDesc;
    private String NewsPrice;
    private String NewsURLImg;

    public NewsData(String newsTitle, String newsDesc, String newsPrice, String newsURLImg) {
        NewsTitle = newsTitle;
        NewsDesc = newsDesc;
        NewsPrice = newsPrice;
        NewsURLImg = newsURLImg;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewsDesc() {
        return NewsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        NewsDesc = newsDesc;
    }

    public String getNewsPrice() {
        return NewsPrice;
    }

    public void setNewsPrice(String newsPrice) {
        NewsPrice = newsPrice;
    }

    public String getNewsURLImg() {
        return NewsURLImg;
    }

    public void setNewsURLImg(String newsURLImg) {
        NewsURLImg = newsURLImg;
    }
}
