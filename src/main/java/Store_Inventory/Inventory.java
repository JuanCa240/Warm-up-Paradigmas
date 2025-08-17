package Store_Inventory;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }
    
    public void create(Product product){
        products.add(product);
    }
    
    public void alphabeticalOrder(){
        for(int i = 0; i < products.size(); i++){
            for(int j = 0; j < products.size()-1; j++){
                if(products.get(j).getName().compareTo(products.get(j+1).getName()) > 0){
                   Product aux = products.get(j);
                   products.set(j, products.get(j+1));
                   products.set(j + 1, aux);
                }
            }
        }
    }
    
    public void increasePrice(){
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            if(product.getCategory().equals("Home") && product.getStock() < 5){
                double newPrice = product.getPrice()*1.10;
                product.setPrice(newPrice);
            }
        }
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }
}
