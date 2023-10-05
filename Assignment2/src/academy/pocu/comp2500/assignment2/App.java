package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerRedStampCreator("RedStamp");
        registry.registerBlueStampCreator("BlueStamp");
        registry.registerGreenStampCreator("GreenStamp");
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
        registry.registerLandscapeBannerTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerGlossBannerTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerGlossBannerImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerScrimBannerTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerScrimBannerImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerMeshBannerTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerMeshBannerImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerLandscapeBusinessCardTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerIvoryBusinessCardTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerGrayBusinessCardTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerGrayBusinessCardImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerLaidBusinessCardTextApertureAdder("BannerAndCard", "addAperture");
        registry.registerLaidBusinessCardImageApertureAdder("BannerAndCard", "addAperture");
        registry.registerLinenBusinessCardTextApertureAdder("BannerAndCard", "addAperture"); // 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("BannerAndCard", "addAperture"); // 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardTextApertureAdder("BannerAndCard", "addAperture"); // 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("BannerAndCard", "addAperture"); // 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardTextApertureAdder("BannerAndCard", "addAperture");  // 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("BannerAndCard", "addAperture"); // 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardTextApertureAdder("BannerAndCard", "addAperture");  // 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("BannerAndCard", "addAperture"); // 양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}
