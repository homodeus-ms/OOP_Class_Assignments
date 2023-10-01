package academy.pocu.comp2500.assignment2;

public class Product {

    private final ProductType productType;
    //private String displayName;
    private final RGB color;
    private final int widthInMilli;
    private final int heightInMilli;
    private final ProductSize size;


    protected int price;
    //protected String text;
    private ShippingMethod shippingMethod = ShippingMethod.SHIPPING;

    protected Product(ProductType type, RGB color, ProductSize size, int price) {
        //this(type, color, width, height, price, "");
        this.productType = type;
        this.color = color;
        this.widthInMilli = size.getWidthInMilli();
        this.heightInMilli = size.getHeightInMilli();
        this.size = size;
        this.price = price;
        //this.text = text;
    }
    /*protected Product(ProductType type, RGB color, int width, int height, int price, String text) {
        this.productType = type;
        this.color = color;
        this.widthInMilli = width;
        this.heightInMilli = height;
        this.price = price;
        this.text = text;
    }*/
    public ProductSize getSize() {
        return this.size;
    }
    public int getWidth() {
        return this.widthInMilli;
    }
    public int getHeight() {
        return this.heightInMilli;
    }
    public ProductType getProductType() {
        return this.productType;
    }
    public String getDisplayName() {
        return this.productType.getName();
    }


    public RGB getColor() {
        return this.color;
    }


    public int getPrice() {
        return price;
    }



    /*public String getText() {
        return this.text;
    }*/

    public ShippingMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
