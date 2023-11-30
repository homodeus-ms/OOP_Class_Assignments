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

        String prompt1 = "WAREHOUSE: Choose warehouse";
        StringBuilder builder = new StringBuilder(100);
        builder.append(prompt1);
        builder.append(System.lineSeparator());
        int count = 1;

        WarehouseType[] types = WarehouseType.values();
        for (WarehouseType type : types) {
            builder.append(count++).append(". ").append(type).append(System.lineSeparator());
        }

        // Warehouse 고르기
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
                continue;
            }

        } while (inputNumber <= 0 || inputNumber >= count);

        WarehouseType chooseType = types[inputNumber - 1];



        User user = new User();
        Wallet wallet;
        int currDeposit;

        try {
            wallet = new SafeWallet(user);
            currDeposit = wallet.getAmount();

            if (currDeposit < 0) {
                throw new OverflowException("Overflow");
            }

        } catch (IllegalAccessException e) {
            err.println("AUTH_ERROR");
            return;
        }
        /*builder.setLength(0);

        builder.append("BALANCE: ");
        int currDeposit = wallet.getAmount();
        builder.append(currDeposit);
        String promptCurrBalance = builder.toString();*/

        Warehouse warehouse = new Warehouse(chooseType);
        ArrayList<Product> products = warehouse.getProducts();

        do {
            builder.setLength(0);

            builder.append("BALANCE: ");
            currDeposit = wallet.getAmount();
            builder.append(currDeposit);
            out.println(builder);


            // 선택한 Warehouse를 토대로 물품을 보여주기


            builder.setLength(0);
            builder.append("PRODUCT_LIST: choose one to buy");
            builder.append(System.lineSeparator());

            products = warehouse.getProducts();

            count = 1;
            for (Product p : products) {
                String format = String.format("%-30s, %30d", p.getName(), p.getPrice());
                builder.append(count++).append(". ").append(format).append(System.lineSeparator());
            }
            out.print(builder);


            // input을 받아서 처리
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
