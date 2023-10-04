package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Cart {

    private final ArrayList<Product> cart;
    private int itemCount;
    private int totalPrice;

    public Cart() {
        cart = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return cart;
    }
    public ShippingMethod getShippingMethod(int index) {
        return cart.get(index).getShippingMethod();
    }

    public void setShippingMethods(Product product, ShippingMethod shippingMethod) {
        for (int i = 0; i < itemCount; ++i) {
            if (cart.get(i) == product) {
                cart.get(i).setShippingMethod(shippingMethod);
                break;
            }
        }
    }

    public void addProduct(Product product) {
        cart.add(product);
        totalPrice += product.getPrice();
        ++itemCount;
    }

    public void removeProduct(Product product) {

        for (int i = 0; i < itemCount; ++i) {
            if (cart.get(i) == product) {
                cart.remove(i);
                break;
            }
        }

        totalPrice -= product.getPrice();
        --itemCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
