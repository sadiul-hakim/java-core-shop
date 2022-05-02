package com.hakim.shopManagementSystem.accounting;

import com.hakim.shopManagementSystem.customer.Customer;
import com.hakim.shopManagementSystem.products.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Memo {
    private static final String userDir=System.getProperty("user.dir");
    protected static final Path invoiceRootDir=Path.of(userDir+ File.separator+"invoice");
    private static final  Path rootDir=Path.of(userDir+File.separator+"memo");
    private static final Path memo= Path.of(userDir + File.separator+"memo"+File.separator+"memo.txt");
    public static void buyProductMemo(String sellerName, int sellerId, Product product,int amountInGM){
        String newMemo= """
                    Seller: %s , Id : %d .
                    Bought %.3f kg %s .
                    Price : %d taka.
                    ---------------+++------------------
                    
                    """.formatted(sellerName,sellerId,amountInGM/1000.0,product.getName(),((int)((amountInGM/1000.0) * product.get1KGPrice())));
        checkMemo();
        try(OutputStream os=new FileOutputStream(memo.toFile(),true)){
            byte[] bytes=newMemo.getBytes();
            checkMemo();
            os.write(bytes);
            os.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void sellProductMemo(String sellerName, int sellerId, Product product, int amountInGM, boolean due, Customer customer){
        String newMemo= """
                    Seller: %s , Id : %d .
                    Customer : %s From :  %s.
                    Sold %.3f kg %s.
                    Price : %d taka.
                    %s
                    ---------------+++------------------
                    
                    """.formatted(sellerName,sellerId,customer.name,customer.address,amountInGM/1000.0,product.getName(),((int)((amountInGM/1000.0) * product.get1KGPrice())),due ? "In Due.":"");
        checkMemo();
        try(OutputStream os=new FileOutputStream(memo.toFile(),true)){
            byte[] bytes=newMemo.getBytes();
            checkMemo();
            os.write(bytes);
            os.flush();

           if(due){
               Path userDueFile=Path.of(invoiceRootDir+File.separator+(customer.name+"-"+customer.customerNumber+".txt"));
               checkMemo();
               if(!Files.exists(userDueFile)){
                   Files.createFile(userDueFile);
               }

               String text= """
                    Customer : %s FRom :  %s.
                    Id : %d.
                    Bought : %s product.
                    Due : %d.
                    
                    ------------+++----------
                    
                    """.formatted(customer.name,customer.address,customer.customerNumber,product.getName(),((int)((amountInGM/1000.0) * product.get1KGPrice())));

                checkMemo();
               try(OutputStream dueOs=new FileOutputStream(userDueFile.toFile(),true)){
                   dueOs.write(text.getBytes());
                   dueOs.flush();
               }catch (IOException e){
                   System.out.println();
               }
           }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void checkMemo(){
        try{
            if(!Files.exists(rootDir)){
                Files.createDirectory(rootDir);
            }
            if(!Files.exists(memo)){
                Files.createFile(memo);
            }
            if(!Files.exists(invoiceRootDir)){
                Files.createDirectory(invoiceRootDir);
            }
        }catch (IOException e){
            System.out.println("Error occurred while creating the memo....");
        }
    }
}
