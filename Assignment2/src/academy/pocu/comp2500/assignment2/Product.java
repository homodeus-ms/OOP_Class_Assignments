package academy.pocu.comp2500.assignment2;

public class Product {
    private final ProductType productType;
    private final int widthInMilli;
    private final int heightInMilli;
    private final Color color;
    protected int price;
    private ShippingMethods shippingMethod = ShippingMethods.SHIPPING;

    protected Product(ProductType type, Color color, int price) {
        this.productType = type;
        this.widthInMilli = type.getWidthInMilli();
        this.heightInMilli = type.getHeightInMilli();
        this.color = color;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getWidthInMilli() {
        return widthInMilli;
    }

    public int getHeightInMilli() {
        return heightInMilli;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public ShippingMethods getShippingMethod() {
        return shippingMethod;
    }
    public void setShippingMethod(ShippingMethods shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
