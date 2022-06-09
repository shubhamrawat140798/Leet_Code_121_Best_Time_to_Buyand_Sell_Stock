package com.best_time_to_buy_and_sell;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * for taking input from user.
 */
final class Main {
    /**
     * for taking input from user.
     * @param args for taking input from command line.
     */
    public static void main(final String[] args) {
        try {
            List<Integer> stockPrice = new ArrayList<>();
            int transactionFee = 0;
            Scanner scanner = new Scanner(System.in);
            boolean isNumber = false;
            while (!isNumber) {
                System.out.print("\nEnter transaction fee: ");
                if (scanner.hasNextInt()) {
                    transactionFee = scanner.nextInt();
                    isNumber = true;
                } else {
                    System.out.print("\nWrong Input. Please enter Integer");
                    scanner.next();
                }

            }

            char choice = 'y';
            while (choice == 'y' || choice == 'Y') {
                isNumber = false;
                while (!isNumber) {
                    System.out.print("\nEnter element "
                            + (stockPrice.size() + 1)
                            + ": ");
                    if (scanner.hasNextInt()) {
                        stockPrice.add(scanner.nextInt());
                        isNumber = true;
                    } else {
                        System.out.println("\nWrong Input."
                                + " Please enter Integer");
                        scanner.next();
                    }
                }
                System.out.print("\nDo you want to continue? y/n: ");
                choice = scanner.next().charAt(0);
                while (choice != 'y' && choice != 'n'
                        && choice != 'Y' && choice != 'N') {
                    System.out.print("\nWrong input " + choice
                            + "\nDo you want to continue? y/n: ");
                    choice = scanner.next().charAt(0);
                }
            }
            BuyingAndSellingOfStocks buyingAndSellingOfStocks
                    = new BuyingAndSellingOfStocks();
            System.out.println("Maximum Profit : "
                    + buyingAndSellingOfStocks.maxProfit(stockPrice,
                    transactionFee));
        } catch (InputMismatchException exception) {
            System.out.println("Input does not match."
                    + "\nEnter integer only. \n"
                    + exception);
        } catch (Exception exception) {
            System.out.println("Error occur " + exception);
        }

    }
    private Main() {
        //Utility classes should not have a public or default constructor.
        // [HideUtilityClassConstructor]
    }
}
