package academy.pocu.comp2500.assignment2;

public class Product {

    private ProductType productType;
    //private String displayName;
    private int color;
    private int widthInMilli;
    private int heightInMilli;
    private int price;
    protected String text;
    private ShippingMethod shippingMethod = ShippingMethod.SHIPPING;

    protected Product(ProductType type, int color, int width, int height, int price) {
        this(type, color, width, height, price, "");
    }
    protected Product(ProductType type, int color, int width, int height, int price, String text) {
        this.productType = type;
        this.color = color;
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.price = price;
        this.text = text;
    }

    public ProductType getProductType() {
        return this.productType;
    }


    public int getColor() {
        return this.color;
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



    public String getText() {
        return this.text;
    }

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
