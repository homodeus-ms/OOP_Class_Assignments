package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("Aperture", "addApertureToBanner");
        registry.registerLandscapeBannerImageApertureAdder("Aperture", "addApertureToBanner");
        registry.registerPortraitBannerTextApertureAdder("Aperture", "addApertureToBanner");
        registry.registerPortraitBannerImageApertureAdder("Aperture", "addApertureToBanner");
        registry.registerGlossBannerTextApertureAdder("Aperture", "addApertureToBanner");
        registry.registerGlossBannerImageApertureAdder("Aperture", "addApertureToBanner");
        registry.registerScrimBannerTextApertureAdder("Aperture", "addApertureToBanner");
        registry.registerScrimBannerImageApertureAdder("Aperture", "addApertureToBanner");
        registry.registerMeshBannerTextApertureAdder("Aperture", "addApertureToBanner");
        registry.registerMeshBannerImageApertureAdder("Aperture", "addApertureToBanner");
        registry.registerLandscapeBusinessCardTextApertureAdder("Aperture", "addApertureToCard");
        registry.registerLandscapeBusinessCardImageApertureAdder("Aperture", "addApertureToCard");
        registry.registerPortraitBusinessCardTextApertureAdder("Aperture", "addApertureToCard");
        registry.registerPortraitBusinessCardImageApertureAdder("Aperture", "addApertureToCard");
        registry.registerIvoryBusinessCardTextApertureAdder("Aperture", "addApertureToCard");
        registry.registerIvoryBusinessCardImageApertureAdder("Aperture", "addApertureToCard");
        registry.registerGrayBusinessCardTextApertureAdder("Aperture", "addApertureToCard");
        registry.registerGrayBusinessCardImageApertureAdder("Aperture", "addApertureToCard");
        registry.registerWhiteBusinessCardTextApertureAdder("Aperture", "addApertureToCard");
        registry.registerWhiteBusinessCardImageApertureAdder("Aperture", "addApertureToCard");
        registry.registerLaidBusinessCardTextApertureAdder("Aperture", "addApertureToCard");
        registry.registerLaidBusinessCardImageApertureAdder("Aperture", "addApertureToCard");
        registry.registerLinenBusinessCardTextApertureAdder("Aperture", "addApertureToCard"); // 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("Aperture", "addApertureToCard"); // 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardTextApertureAdder("Aperture", "addApertureToCard"); // 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("Aperture", "addApertureToCard"); // 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardTextApertureAdder("Aperture", "addApertureToCard");  // 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("Aperture", "addApertureToCard"); // 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardTextApertureAdder("Aperture", "addApertureToCard");  // 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("Aperture", "addApertureToCard"); // 양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}
