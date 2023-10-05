package academy.pocu.comp2500.assignment2;

public class Product {

    public enum ShippingMethods {
        PICKUP,
        SHIPPING
    }

    private final ProductType productType;
    private final String displayName;
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
        displayName = type.getDisplayName();
    }

    public ProductType getProductType() {
        return productType;
    }
    public String getDisplayName() {
        return displayName;
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
