package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Department;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {

    public void run(BufferedReader in, PrintStream out, PrintStream err) {

        // choose WareHouse prompt
        String prompt1 = "WAREHOUSE: Choose warehouse";
        StringBuilder builder = new StringBuilder(100);
        builder.append(prompt1);
        builder.append(System.lineSeparator());
        int index = 1;

        WarehouseType[] wareHouseTypes = WarehouseType.values();
        for (WarehouseType type : wareHouseTypes) {
            builder.append(index++).append(". ").append(type).append(System.lineSeparator());
        }


        // Warehouse 선택 입력 받기
        int inputNumber = -1;

        do {
            out.print(builder.toString());

            String input;

            try {
                input = in.readLine();
            } catch (IOException e) {
                err.println(e);
                return;
            }

            if (input.equals("exit")) {
                return;
            }

            try {
                inputNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
            }
        } while (inputNumber <= 0 || inputNumber >= index);

        WarehouseType selectedType = wareHouseTypes[inputNumber - 1];



        User user = new User();
        Wallet wallet;
        int currDeposit;

        try {
            wallet = new SafeWallet(user);
            /*currDeposit = wallet.getAmount();

            if (currDeposit < 0) {
                throw new OverflowException("Overflow");
            }*/

        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return;
        }


        Warehouse warehouse = new Warehouse(selectedType);
        ArrayList<Product> products;


        do {
            currDeposit = wallet.getAmount();
            out.printf("BALANCE: %d%s", currDeposit, System.lineSeparator());

            // 선택한 Warehouse를 토대로 물품을 보여주기
            builder.setLength(0);
            builder.append("PRODUCT_LIST: Select one to buy");
            builder.append(System.lineSeparator());

            products = warehouse.getProducts();

            index = 1;
            for (Product p : products) {
                String format = String.format("%-30s, %30d", p.getName(), p.getPrice());
                builder.append(index++).append(". ").append(format).append(System.lineSeparator());
            }
            out.print(builder);


            // 입력을 받아서 처리
            int inputProductNumber = -1;

            String input;

            try {
                input = in.readLine();
            } catch (IOException e) {
                err.println(e);
                return;
            }

            if (input.equals("exit")) {
                return;
            }


            try {
                inputProductNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                continue;
            }
            if (inputProductNumber <= 0 || inputProductNumber > products.size()) {
                continue;
            }

            int choosePrice = products.get(inputProductNumber - 1).getPrice();

            if (wallet.withdraw(choosePrice)) {
                try {
                    warehouse.removeProduct(products.get(inputProductNumber - 1).getId());
                } catch (ProductNotFoundException e) {
                    wallet.deposit(choosePrice);
                }
            }
        } while (true);
    }
}
