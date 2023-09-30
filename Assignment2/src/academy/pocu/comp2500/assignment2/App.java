package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerRedStampCreator("RedStamp");
        registry.registerBlueStampCreator("GreenStamp");
        registry.registerGreenStampCreator("BlueStamp");
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
        registry.registerLaidBusinessCardCreator("LaidBusinessCard");
        registry.registerLinenBusinessCardCreator("LinenBusinessCard");
        registry.registerSmoothBusinessCardCreator("SmoothBusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("Banner", "addText");
        registry.registerLandscapeBannerImageApertureAdder("Banner", "addImagePath");
        registry.registerPortraitBannerTextApertureAdder("Banner", "addText");
        registry.registerPortraitBannerImageApertureAdder("Banner", "addImagePath");
        registry.registerGlossBannerTextApertureAdder("Banner", "addText");
        registry.registerGlossBannerImageApertureAdder("Banner", "addImagePath");
        registry.registerScrimBannerTextApertureAdder("Banner", "addText");
        registry.registerScrimBannerImageApertureAdder("Banner", "addImagePath");
        registry.registerMeshBannerTextApertureAdder("Banner", "addText");
        registry.registerMeshBannerImageApertureAdder("Banner", "addImagePath");
        registry.registerLandscapeBusinessCardTextApertureAdder("BusinessCard", "addText");
        registry.registerLandscapeBusinessCardImageApertureAdder("BusinessCard", "addImagePath");
        registry.registerPortraitBusinessCardTextApertureAdder("BusinessCard", "addText");
        registry.registerPortraitBusinessCardImageApertureAdder("BusinessCard", "addImagePath");
        registry.registerIvoryBusinessCardTextApertureAdder("BusinessCard", "addText");
        registry.registerIvoryBusinessCardImageApertureAdder("BusinessCard", "addImagePath");
        registry.registerGrayBusinessCardTextApertureAdder("BusinessCard", "addText");
        registry.registerGrayBusinessCardImageApertureAdder("BusinessCard", "addImagePath");
        registry.registerWhiteBusinessCardTextApertureAdder("BusinessCard", "addText");
        registry.registerWhiteBusinessCardImageApertureAdder("BusinessCard", "addImagePath");
        registry.registerLaidBusinessCardTextApertureAdder("BusinessCard", "addText");
        registry.registerLaidBusinessCardImageApertureAdder("BusinessCard", "addImagePath");
        registry.registerLinenBusinessCardTextApertureAdder("BusinessCard", "addText"); // 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("BusinessCard", "addImagePath"); // 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardTextApertureAdder("BusinessCard", "addText"); // 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("BusinessCard", "addImagePath"); // 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardTextApertureAdder("BusinessCard", "addText");  // 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("BusinessCard", "addImagePath"); // 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardTextApertureAdder("BusinessCard", "addText");  // 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("BusinessCard", "addImagePath"); // 양면 명함에 사진을 추가하는 메서드를 등록한다.
    }
}
