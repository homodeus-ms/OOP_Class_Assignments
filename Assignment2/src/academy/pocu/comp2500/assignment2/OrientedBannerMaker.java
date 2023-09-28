package academy.pocu.comp2500.assignment2;

public class OrientedBannerMaker {

    Banner banner;

    public OrientedBannerMaker(BannerType type, BannerSize size, RGB color, PrintOrientation orientation) {
        switch (type) {
            case GLOSS:
                this.banner = new GlossBanner(size, color, orientation);
                break;
            case SCRIM:
                this.banner = new ScrimBanner(size, color, orientation);
                break;
            case MESH:
                this.banner = new MeshBanner(size, color, orientation);
                break;
            default:
                assert (false);
        }
    }
}
