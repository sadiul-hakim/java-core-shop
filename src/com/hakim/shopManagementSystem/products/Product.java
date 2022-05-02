package com.hakim.shopManagementSystem.products;

import javax.print.attribute.standard.MediaSize;

abstract public class Product {
    private final String NAME;
    private  int PRICE_100GM=0;
    private int amountInGM=0;

    public Product(String name){
        this.NAME=name;
    }

    public void change100gmPrice(int price){
        PRICE_100GM=price;
    }

    public int productAvailableInKg(){
        return amountInGM/1000;
    }

    public void addProduct(int amountInGM){
        this.amountInGM+=amountInGM;
    }

    public void decreaseProduct(int amountInGM){
        this.amountInGM-=amountInGM;
    }

    public int get250GMPrice(){
        return  (int)(PRICE_100GM * 2.5);
    }

    public int get500GMPrice(){
        return PRICE_100GM*5;
    }

    public int get1KGPrice(){
        return PRICE_100GM*10;
    }

    public String  getName(){
        return this.NAME;
    }

}
