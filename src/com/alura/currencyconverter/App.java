package com.alura.currencyconverter;

import com.alura.currencyconverter.api.ExchangeRateApiClient;
import com.alura.currencyconverter.service.CurrencyConversionService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final String API_KEY = "YOUR_API_KEY_HERE";

        ExchangeRateApiClient apiClient = new ExchangeRateApiClient(API_KEY);
        CurrencyConversionService conversionService = new CurrencyConversionService(apiClient);

        System.out.println("*************************************************");
        System.out.println("   Welcome to the Currency Converter =]");
        System.out.println("*************************************************");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.displayMenu();
            int option = getValidMenuOption(scanner);

            if (option == 7) {
                System.out.println("Exiting the program. Thank you for using the currency converter!");
                break;
            }

            double amount = getValidPositiveDouble(scanner);

            try {
                String result = conversionService.convert(option, amount);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        scanner.close();

    }

    private static int getValidMenuOption(Scanner scanner) {
        while (true) {
            System.out.print("Enter a menu option: ");
            String input = scanner.nextLine();
            try {
                int option = Integer.parseInt(input);
                if (option >= 1 && option <= 7) {
                    return option;
                } else {
                    System.out.println("Invalid option. Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static double getValidPositiveDouble(Scanner scanner) {
        while (true) {
            System.out.print("Enter a valid amount: ");
            String input = scanner.nextLine();
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("Invalid amount. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }
    }
}
