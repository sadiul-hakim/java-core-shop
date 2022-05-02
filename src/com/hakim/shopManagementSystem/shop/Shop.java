package com.hakim.shopManagementSystem.shop;

import com.hakim.shopManagementSystem.customer.Customer;
import com.hakim.shopManagementSystem.products.*;
import com.hakim.shopManagementSystem.seller.Seller;

public class Shop {
    public static void main(String[] args) {
        Product milk=new Milk("Milk");
        Product meat=new Meat("Meat");
        Product sugar=new Sugar("Sugar");
        Product rice=new Rice("Rice");
        Product vermicelli=new Rice("Vermicelli");

        Seller Hakim=new Seller("Hakim",1234);
        Seller Jim =new Seller("Jim",3456);

        Hakim.buy(meat,50_000,60);
        Hakim.buy(sugar,20_000,7);
        Jim.buy(milk,10_000,8);
        Jim.buy(vermicelli,5_000,4);
        Hakim.buy(rice,100_000,4);


        Customer ashik=new Customer("Ashikur","Dhaka",237);
        Customer jisan=new Customer("Jisan","Dhaka",123);
        Customer antor=new Customer("Antor","Dhaka",4567);
        Customer shahed=new Customer("Shahed","Dhaka",3456);
        Customer rakib=new Customer("Rakibul","Dhaka",6789);

//        Hakim.sell(rice,10_000,10* rice.get1KGPrice(),false,ashik);
//        Hakim.sell(milk,1_000, milk.get1KGPrice(),true,antor);
//        Jim.sell(meat,2_000,2*meat.get1KGPrice(),false,jisan);
//        milk.change100gmPrice(12);
//        Hakim.sell(milk,2_000,2*milk.get1KGPrice(),false,shahed);
//        Hakim.sell(milk,1_000, milk.get1KGPrice(), true,ashik);
//        Hakim.sell(meat,1_000, meat.get1KGPrice(), true,ashik);
//        Jim.sell(vermicelli,250, vermicelli.get250GMPrice(), false,rakib);



    }
}
