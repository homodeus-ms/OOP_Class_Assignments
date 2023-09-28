package academy.pocu.comp2500.assignment2;

public class MeshBanner extends Banner {
    /*private static final int TINY_PRICE = 5100;
    private static final int SMALL_PRICE = 5300;
    private static final int MEDIUM_PRICE = 5400;
    private static final int LARGE_PRICE = 6100;*/


    public MeshBanner(BannerSize size, RGB color, PrintOrientation orientation) {
        super(BannerType.MESH, size, color, orientation);
    }
    /*private static int getPrice(BannerSize size) {
        switch (size) {
            case TINY:
                return TINY_PRICE;
            case SMALL:
                return SMALL_PRICE;
            case MEDIUM:
                return MEDIUM_PRICE;
            case LARGE:
                return LARGE_PRICE;
            default:
                assert (false);
                return -1;
        }
    }*/
}
