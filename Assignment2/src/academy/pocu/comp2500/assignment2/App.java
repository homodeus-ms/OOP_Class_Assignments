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
        registry.registerLandscapeBannerTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerGlossBannerTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerLandscapeBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerIvoryBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerGrayBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerGrayBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerLaidBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");
        registry.registerLaidBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture");
        registry.registerLinenBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture"); // 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture"); // 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture"); // 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture"); // 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");  // 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture"); // 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardTextApertureAdder("BannerAndCard", "addTextAperture");  // 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("BannerAndCard", "addImageAperture"); // 양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}
