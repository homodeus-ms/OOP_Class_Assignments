package academy.pocu.comp2500.lab6.app;

import academy.pocu.comp2500.lab6.Appetizer;
import academy.pocu.comp2500.lab6.DeathByDesserts;
import academy.pocu.comp2500.lab6.Dessert;
import academy.pocu.comp2500.lab6.FreeSoulPizza;
import academy.pocu.comp2500.lab6.HousePizza;
import academy.pocu.comp2500.lab6.MainCourse;
import academy.pocu.comp2500.lab6.MeatLoverPizza;
import academy.pocu.comp2500.lab6.NoHeavyMeal;
import academy.pocu.comp2500.lab6.ThreeCourseMeal;
import academy.pocu.comp2500.lab6.Topping;
import academy.pocu.comp2500.lab6.VeggiePizza;
import academy.pocu.comp2500.lab6.Menu;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        {
            NoHeavyMeal n1 = new NoHeavyMeal();

            n1.setAppetizers(Appetizer.GYOZA, Appetizer.NACHOS);
            n1.setDessert(Dessert.APPLE_PIE);
            for (Appetizer a : n1.getAppetizers()) {
                System.out.println(a);
            }
            for (Dessert d : n1.getDesserts()) {
                System.out.println(d);
            }

            n1.setAppetizers(Appetizer.CALAMARI, Appetizer.SPINACH_DIP);
            n1.setDessert(Dessert.CHOCOLATE_MOUSSE);
            System.out.println(n1.isValid());
            for (Appetizer a : n1.getAppetizers()) {
                System.out.println(a);
            }
            for (Dessert d : n1.getDesserts()) {
                System.out.println(d);
            }
        }

        {
            System.out.println("No Assert!");
        }
    }
}