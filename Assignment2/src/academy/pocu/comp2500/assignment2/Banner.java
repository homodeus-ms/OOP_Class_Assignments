package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends BannerAndCard {

    private static final int GLOSS_1XHALF_PRICE = 5000;
    private static final int GLOSS_1X1_PRICE = 5200;
    private static final int GLOSS_2XHALF_PRICE = 5300;
    private static final int GLOSS_3X1_PRICE = 6000;
    private static final int OTHER_1XHALF_PRICE = 5100;
    private static final int OTHER_1X1_PRICE = 5300;
    private static final int OTHER_2XHALF_PRICE = 5400;
    private static final int OTHER_3X1_PRICE = 6100;

    private final BannerType bannerType;
    private final BannerSize bannerSize;

    public Banner(BannerType type, BannerSize size, RGB color, PrintOrientation orientation) {
        super(type.getType(), color, size.getSize(), getPrice(type, size), orientation);
        this.bannerType = type;
        this.bannerSize = size;
    }

    public BannerType getBannerType() {
        return bannerType;
    }
    public BannerSize getBannerSize() {
        return bannerSize;
    }

    private static int getPrice(BannerType type, BannerSize size) {
        switch (type) {
            case GLOSS:
                switch (size) {
                    case TINY_1XHALF:
                        return GLOSS_1XHALF_PRICE;
                    case SMALL_1X1:
                        return GLOSS_1X1_PRICE;
                    case MEDIUM_2XHALF:
                        return GLOSS_2XHALF_PRICE;
                    case LARGE_3X1:
                        return GLOSS_3X1_PRICE;
                    default:
                        assert (false);
                        return -1;
                }
            case SCRIM:
                // intentional fall through
            case MESH:
                switch (size) {
                    case TINY_1XHALF:
                        return OTHER_1XHALF_PRICE;
                    case SMALL_1X1:
                        return OTHER_1X1_PRICE;
                    case MEDIUM_2XHALF:
                        return OTHER_2XHALF_PRICE;
                    case LARGE_3X1:
                        return OTHER_3X1_PRICE;
                    default:
                        assert (false);
                        return -1;
                }
            default:
                assert (false);
                return -1;
        }
    }
}
