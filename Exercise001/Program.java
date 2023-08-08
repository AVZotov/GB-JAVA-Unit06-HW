package ru.geekbrains.api.Seminar006.HW.Exercise001;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    private Scanner scanner = new Scanner(System.in);

    public Program() {
    }

    /**
     * @apiNote method to start e-shop filter system simulation
     */
    public void Start() {
        System.out.print("Enter the amount of notebooks to be generated (minimal recommended 20): ");
        Notebooks notebooks = new Notebooks(getInt());
        boolean flag = true;

        while (flag) {
            printMainMenu();
            String ANSI_RESET = "\u001B[0m";
            String ANSI_RED = "\u001B[31m";

            switch (getInt()) {
                case 1 -> notebooks.PrintAll();
                case 2 -> notebooks.PrintSelected(getUserFilters());
                case 3 -> flag = false;
                default -> System.out.println(ANSI_RED + "\nEnter value from 1 to 3\n" + ANSI_RESET);
            }
        }
    }

    /**
     * @apiNote method to get user preferences from console interface
     * @return returning Map with user preferences
     */
    private Map<String, Object> getUserFilters(){
        boolean flag = true;
        Map<String, Object> filters = new HashMap<>();
        System.out.println("Enter minimal required RAM size in Mb: ");
        filters.put("RAM", getInt());
        System.out.println("Enter minimal required HDD size in Gb: ");
        filters.put("HDD", getInt());
        System.out.println("Select required Windows version. 10 or 11: ");
        PrintOSSelectionMenu();

        while (flag) {
            switch (getInt()) {
                case 1 -> {
                    filters.put("OS", "Win10Home");
                    flag = false;
                }
                case 2 -> {
                    filters.put("OS", "Win10Professional");
                    flag = false;
                }
                case 3 -> {
                    filters.put("OS", "Win11Home");
                    flag = false;
                }
                case 4 -> {
                    filters.put("OS", "Win11Professional");
                    flag = false;
                }
                case 5 -> {
                    filters.put("OS", "All");
                    flag = false;
                }
                default -> System.out.print("Please select required version: ");
            }
        }
        flag = true;
        System.out.println("Select required Color: ");
        PrintColorSelectionMenu();

        while (flag) {
            switch (getInt()) {
                case 1 -> {
                    filters.put("Color", "Black");
                    flag = false;
                }
                case 2 -> {
                    filters.put("Color", "Grey");
                    flag = false;
                }
                case 3 -> {
                    filters.put("Color", "Silver");
                    flag = false;
                }
                case 4 -> {
                    filters.put("Color", "White");
                    flag = false;
                }
                case 5 -> {
                    filters.put("Color", "All");
                    flag = false;
                }
                default -> System.out.print("Please enter value from 1 to 5: ");
            }
        }
        return filters;
    }

    private void PrintColorSelectionMenu() {
        System.out.print("1. Black\n2. Gray\n3. Silver\n4. White\n5. Skip\n\nSelect your choice: ");
    }

    private void PrintOSSelectionMenu() {
        System.out.print("1. Win10Home\n2. Win10Professional\n3. Win11Home\n4. Win11Professional\n5. Skip\n\nSelect your preferences: ");
    }

    private void printMainMenu() {
        System.out.print("1. Print all Notebooks\n2. Filtered Search\n3. Exit\n\nSelect your choice: ");
    }

    /**
     * @apiNote Method with Scanner to read user entered digits with functionality to check if value is digit
     * @return returning an Integer
     */
    private int getInt() {
        int result = 0;
        boolean flag = true;

        while (flag) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                flag = false;
            } else {
                System.out.print("Enter correct value: ");
                scanner = new Scanner(System.in);
            }
        }
        scanner.reset();
        return result;
    }
}
