package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
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
            try {
                inputNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                continue;
            }

            if (input.equals("exit")) {
                return;
            }
        } while (inputNumber <= 0 && inputNumber >= count);

        WarehouseType chooseType = types[inputNumber - 1];


        User user = new User();

        do {
            // Wallet의 금액 보여주기
            Wallet wallet;
            try {
                wallet = new SafeWallet(user);
            } catch (IllegalAccessException e) {
                err.println("AUTH_ERROR");
                return;
            }
            builder.setLength(0);

            builder.append("BALANCE: ");
            int currDeposit = wallet.getAmount();
            builder.append(currDeposit);
            out.println(builder);



            // 선택한 Warehouse를 토대로 물품을 보여주기
            builder.setLength(0);
            builder.append("PRODUCT_LIST: choose one to buy");
            builder.append(System.lineSeparator());

            Warehouse warehouse = new Warehouse(chooseType);
            ArrayList<Product> products = warehouse.getProducts();
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
            try {
                inputProductNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                continue;
            }

            if (input.equals("exit")) {
                return;
            }

            int choosePrice = products.get(inputProductNumber - 1).getPrice();

            if (wallet.withdraw(choosePrice)) {
                warehouse.removeProduct(products.get(inputProductNumber - 1).getId());
                return;
            }
        } while (true);

    }
}
