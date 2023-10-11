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
            NoHeavyMeal m1 = new NoHeavyMeal();
            m1.setAppetizers(Appetizer.CALAMARI, Appetizer.GYOZA);
            m1.setDessert(Dessert.APPLE_PIE);
            ArrayList<Appetizer> zers =  m1.getAppetizers();

            for (Appetizer a : zers) {
                System.out.println(a);
            }

            
        }


            HousePizza housePizza = new HousePizza();

            assert (!housePizza.isValid());

            assert (housePizza.addBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());

            assert (!housePizza.addSausages());

            assert (housePizza.isValid());

            assert (!housePizza.removeSausages());

            assert (housePizza.removeBacon());

            assert (!housePizza.isValid());

            assert (housePizza.addPeperoni());

            assert (housePizza.isValid());


            HousePizza housePizza2 = new HousePizza();

            assert (!housePizza2.isValid());

            assert (housePizza2.addBacon());

            assert (!housePizza2.isValid());

            assert (housePizza2.addPeperoni());

            assert (housePizza2.isValid());

            assert (!housePizza2.addSausages());

            assert (housePizza2.isValid());

            assert (!housePizza2.removeSausages());

            assert (housePizza2.removeBacon());

            assert (!housePizza2.isValid());

            assert (housePizza2.addPeperoni());

            assert (housePizza2.isValid());


        {
            MeatLoverPizza meatLoverPizza = new MeatLoverPizza();

            assert (!meatLoverPizza.isValid());

            assert (meatLoverPizza.addGreenPeppers());
            assert (!meatLoverPizza.addGreenPeppers());

            assert (meatLoverPizza.isValid());

            assert (meatLoverPizza.removeGreenPeppers());

            assert (!meatLoverPizza.isValid());
        }

        {
            VeggiePizza veggiePizza = new VeggiePizza();

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addFetaCheese());

            assert (veggiePizza.isValid());

            assert (veggiePizza.removeCheddarCheese());

            assert (!veggiePizza.isValid());

            assert (veggiePizza.addMozzarellaCheese());

            assert (veggiePizza.isValid());
        }

        {
            FreeSoulPizza freeSoulPizza = new FreeSoulPizza();

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.FETA_CHEESE));
            assert (!freeSoulPizza.addTopping(Topping.CHEDDAR_CHEESE));

            assert (freeSoulPizza.addTopping(Topping.BLACK_OLIVES));
            assert (freeSoulPizza.addTopping(Topping.RED_ONIONS));

            assert (!freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.GREEN_PEPPERS));
            assert (!freeSoulPizza.removeTopping(Topping.GREEN_PEPPERS));

            assert (!freeSoulPizza.isValid());

            assert (freeSoulPizza.addTopping(Topping.CHICKEN));
            assert (freeSoulPizza.addTopping(Topping.SAUSAGES));

            assert (freeSoulPizza.isValid());

            assert (!freeSoulPizza.addTopping(Topping.PEPERONI));
        }
        {
            System.out.println("No Assert!");
        }
    }
}