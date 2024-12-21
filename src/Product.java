
class Product {
    private final String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product addStock(int quantity) {
        this.quantity += quantity;
        return this;
    }

    public void reduceStock(int quantity) {
        this.quantity -= quantity;
    }
}
