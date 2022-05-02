package com.hakim.shopManagementSystem.seller;

import com.hakim.shopManagementSystem.accounting.Memo;
import com.hakim.shopManagementSystem.products.Product;
import com.hakim.shopManagementSystem.customer.Customer;

public class Seller {
    private final String sellerName;
    private final int sellerId;

    public Seller(String name,int id){
        sellerName=name;
        sellerId=id;
    }

    public void sell(Product product,int amountInGM,int price,boolean due,Customer customer){
        boolean available=product.productAvailableInKg() > amountInGM/1000;
        boolean rightPrice=(int)((amountInGM/1000.0) * product.get1KGPrice()) == price;
        if(!available){
            System.out.println("Not Available..");
            return;
        }else if(!rightPrice){
            System.out.println("Not enough price...");
            return;
        }

        product.decreaseProduct(amountInGM);

        Memo.sellProductMemo(sellerName,sellerId,product,amountInGM,due,customer);
    }

    public void buy(Product product,int amountInGM,int price100GM){
        product.addProduct(amountInGM);
        product.change100gmPrice(price100GM);

        Memo.buyProductMemo(sellerName,sellerId,product,amountInGM);
    }


    @Override
    public String toString(){
        return "Seller "+sellerName+" with id NO: "+sellerId;
    }
}
