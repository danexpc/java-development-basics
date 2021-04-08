package com.kpi.view;

import com.kpi.services.InputUtility;
import com.kpi.models.HomeAppliance;

public class TechnoStoreView {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String WRONG_INPUT_DATA = ANSI_RED + "\nWrong input! Repeat please!\n";
    public static final String EMPTY_DATA = ANSI_YELLOW + "\nNothing to show!\n";
    public static final String GREETING_MESSAGE = ANSI_GREEN + "\tWelcome to our Techno Country!\n";
    public static final String THANKS_MESSAGE = ANSI_GREEN + "\tThanks...\n";
    public static final String UNKNOWN_OPTION = ANSI_YELLOW + "\tOption does not exist\n";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String SAVE_QUESTION = "\nDo you want to save result of the last request?(Yes/No)\n";
    public static final String SAVE_AGREE = "yes";


    public static void printTechnoStoreDetails(HomeAppliance[] stock){
        if (stock.length == 0) {
            printMessage(EMPTY_DATA);
            return;
        }
        StringBuilder table = new StringBuilder("\n");

        for (HomeAppliance homeAppliance : stock) {
            table.append(homeAppliance.toString()).append("\n");
        }

        System.out.println(ANSI_GREEN + table.toString());
    }

    public static void printMenu() {
        System.out.println(ANSI_CYAN + """
                 
                 \t Choose option:   \s
                 \t 1)Filter by type \s
                 \t 2)Filter by price\s
                 \t 3)Filter by firm \s
                 \t 4)Show all items \s
                 \t 0)Exit
                """
        );
    }

    public static void printMessage(String message) {
        System.out.print(ANSI_CYAN + message);
    }

    public static void printErrorMessage(String message) {
        System.out.print(ANSI_RED + message);
    }


    public int getMenuOption() {
        return InputUtility.inputIntValue(this);
    }

    public String getTypeField() {
        printMessage("\t Enter type: \n");
        return InputUtility.inputStringValue(this);
    }

    public String getFirmField() {
        printMessage("\t Enter firm: \n");
        return InputUtility.inputStringValue(this);
    }

    public int getMinPriceField() {
        printMessage("\t Enter min price: \n");
        return InputUtility.inputIntValue(this);
    }

    public int getMaxPriceField() {
        printMessage("\t Enter max price: \n");
        return InputUtility.inputIntValue(this);
    }

    public boolean getIsSaveField() {
        printMessage(TechnoStoreView.SAVE_QUESTION);
        String answer = InputUtility.inputStringValue(this);
        return TechnoStoreView.SAVE_AGREE.equals(answer);
    }
}
