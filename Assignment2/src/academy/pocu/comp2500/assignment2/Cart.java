package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {
    private final ArrayList<Product> cart;
    private int totalPrice;

    public Cart() {
        cart = new ArrayList<>();
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product) {
        this.cart.add(product);
        totalPrice += product.getPrice();
    }
    public void removeProduct(int index) {
        if (isIndexValid(index)) {
            totalPrice -= cart.get(index).getPrice();
            cart.remove(index);
        }
    }
    public void changeShippingMethod(int index, ShippingMethods shippingMethod) {
        if (isIndexValid(index)) {
            cart.get(index).setShippingMethod(shippingMethod);
        }
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < cart.size();
    }
}
