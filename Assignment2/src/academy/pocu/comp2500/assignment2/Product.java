package academy.pocu.comp2500.assignment2;

public class Product {
    private final ProductType productType;
    private final String productName;
    private final ColorType color;
    private final int colorValue;
    private final int widthInMilli;
    private final int heightInMilli;
    private final int price;
    private ShippingMethod shippingMethod = ShippingMethod.SHIPPING;

    protected Product(ProductType type, ColorType color, int width, int height, int price) {
        this.productType = type;
        this.productName = type.getName();
        this.color = color;
        this.colorValue = color.getColorValue();
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }
    public String getProductName() {
        return this.productName;
    }

    public ColorType getColor() {
        return color;
    }
    public int getColorValue() {
        return this.colorValue;
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
