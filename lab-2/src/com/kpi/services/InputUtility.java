package com.kpi.services;

import com.kpi.view.TechnoStoreView;

import java.util.Locale;
import java.util.Scanner;

public class InputUtility {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputIntValue(TechnoStoreView view){
        while(!sc.hasNextInt()) {
            TechnoStoreView.printMessage(TechnoStoreView.WRONG_INPUT_DATA);

            sc.next();
        }

        return sc.nextInt();
    }

    public static String inputStringValue(TechnoStoreView view){

        String req = sc.nextLine();
        boolean touched = false;

        while(req.strip().isEmpty()) {
            if (touched) {
                TechnoStoreView.printMessage(TechnoStoreView.WRONG_INPUT_DATA);
            } else {
                touched = true;
            }
            req = sc.nextLine();
        }

        return req.toLowerCase(Locale.ROOT);
    }
}
