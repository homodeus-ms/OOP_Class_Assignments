package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerDrawPixelCommandCreator("DrawOnePixel");
        registry.registerIncreasePixelCommandCreator("IncreaseCharByOne");
        registry.registerDecreasePixelCommandCreator("DecreaseCharByOne");
        registry.registerToUppercaseCommandCreator("ToUpper");
        registry.registerToLowercaseCommandCreator("ToLower");
        registry.registerFillHorizontalLineCommandCreator("FillHorizontalByOne");
        registry.registerFillVerticalLineCommandCreator("FillVerticalByOne");
        registry.registerClearCommandCreator("Clear");
    }
}
