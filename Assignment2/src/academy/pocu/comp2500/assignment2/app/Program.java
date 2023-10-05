package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.*;
import academy.pocu.comp2500.assignment2.registry.Registry;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        Product c1 = new BusinessCard(BusinessCard.StockType.LAID, BusinessCard.SideType.DOUBLE, BusinessCard.CardColor.GRAY, BannerAndCard.PrintOrientation.PORTRAIT);
        System.out.println(c1.getDisplayName());

        System.out.println("No Assert!!!");
    }


}
