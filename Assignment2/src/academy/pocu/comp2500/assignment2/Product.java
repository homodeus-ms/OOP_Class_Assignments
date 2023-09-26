package academy.pocu.comp2500.assignment2;

public class Product {
    private final ProductType productType;
    private final ColorType color;
    private final int widthInMilli;
    private final int heightInMilli;
    private final int price;

    protected Product(ProductType type, ColorType color, int width, int height, int price) {
        this.productType = type;
        this.color = color;
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.price = price;
    }

    public ProductType getType() {
        return productType;
    }

    public ColorType getColor() {
        return color;
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
}
