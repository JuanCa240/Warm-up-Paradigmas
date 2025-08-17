package Store_Inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final Scanner keyboard;
    private Inventory inventory;

    public Main() {
        keyboard = new Scanner(System.in);
        inventory = new Inventory(); 
    }

    public void system(){
        showProducts();
        
        printElectronicStock();
        
        printHomeStock();
        
        calculateTotalRevenueByCategory();
        
    }
    
    public void printElectronicStock(){
        ArrayList<Product> products = inventory.getProducts();
        
        inventory.alphabeticalOrder();
        
        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            
            if(p.getCategory().equals("Electronic") && p.getStock() > 0){
                System.out.println(p);
            }
        }
    }
    
    public void printHomeStock(){
        ArrayList<Product> products = inventory.getProducts();
        
        showNewPrice();
        
        for(int i = 0; i < products.size();i++){
            Product p = products.get(i);
            
           if(p.getCategory().equals("Home")){
               System.out.println(p);
           }
        }
    }
    
    public void showProducts(){
        Product p1 = new Product("Laptop","Electronic",1200,10,5);
        inventory.create(p1);
        
        Product p2 = new Product("Smartphone","Electronic",1500,6,4);
        inventory.create(p2);
        
        Product p3 = new Product("Pc","Electronic",1600,6,4);
        inventory.create(p3);
        
        Product p4 = new Product("Bed","Home",2200,10,6);
        inventory.create(p4);
        
        Product p5 = new Product("rug","Home",2500,4,3);
        inventory.create(p5);
    }
    
    public void showNewPrice(){
        inventory.increasePrice();
    }
    
    public void calculateTotalRevenueByCategory() {
        ArrayList<Product> products = inventory.getProducts(); 

        double totalElectronic = 0;
        double totalHome = 0;

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            double revenue = product.getPrice() * product.getUnitSolds();

            if (product.getCategory().equals("Electronic")) {
                totalElectronic += revenue;
            } else if (product.getCategory().equals("Home")) {
                totalHome += revenue;
            }
        }

        System.out.println("\nTotal Revenue Electronic: " + totalElectronic);
        System.out.println("Total Revenue Home: " + totalHome);
    }


    
    public static void main(String[] args) {
        Main execute = new Main();
        execute.system();
    }
}
