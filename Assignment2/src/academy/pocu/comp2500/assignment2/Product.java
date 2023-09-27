package academy.pocu.comp2500.assignment2;

public class Product {

    private String displayName;
    private RGB color;
    private int widthInMilli;
    private int heightInMilli;
    private int price;
    private ShippingMethod shippingMethod = ShippingMethod.SHIPPING;

    protected Product(String displayName, RGB Color, int width, int height, int price) {
        this.displayName = displayName;
        this.color = color;
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.price = price;
    }

    public String getProductName() {
        return this.displayName;
    }

    public RGB getColor() {
        return this.color;
    }
    public int getColorValue() {
        return this.color.getColorValue();
    }

    public int getWidthInMilli() {
        return widthInMilli;
    }

    public int getHeightInMilli() {
        return heightInMilli;
    }

    public int getPrice() {
        return price;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
