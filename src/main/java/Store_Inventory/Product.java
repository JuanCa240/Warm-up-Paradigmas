package Store_Inventory;

public class Product {
    
    private String name;
    private String category;
    private double price;
    private int stock;
    private int unitSolds;

    public Product(String name, String category, double price, int stock, int unitSolds) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.unitSolds = unitSolds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getUnitSolds() {
        return unitSolds;
    }

       @Override
    public String toString() {
        return "\n name: " + name + 
               "\n category: " + category + 
               "\n price: " + price + 
               "\n stock: " + stock + 
               "\n unitSolds: " + unitSolds;
    }

}
