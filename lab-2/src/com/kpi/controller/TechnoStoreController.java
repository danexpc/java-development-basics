package com.kpi.controller;

import com.kpi.custom.exceptions.EmptyRequestException;
import com.kpi.custom.exceptions.InvalidFormatTypeException;
import com.kpi.custom.exceptions.PriceLessZeroException;
import com.kpi.services.InputUtility;
import com.kpi.custom.validators.Validator;
import com.kpi.view.TechnoStoreView;
import com.kpi.models.TechnoStore;


public class TechnoStoreController {
    private final TechnoStore model;
    private final TechnoStoreView view;

    public TechnoStoreController(){
        this.model = new TechnoStore();
        this.view = new TechnoStoreView();
    }

    public void filterTechnoStoreByType(String type) {
        view.printTechnoStoreDetails(model.filterByType(type));
    }

    public void filterTechnoStoreByFirm(String firm) {
        view.printTechnoStoreDetails(model.filterByFirm(firm));
    }

    public void filterTechnoStoreByPrice(int min, int max) {
        view.printTechnoStoreDetails(model.filterByPrice(min, max));
    }

    private void filterByFirmCase() {
        TechnoStoreView.printMessage("\t Enter firm: \n");
        String firm = InputUtility.inputStringValue(this.view);
        filterTechnoStoreByFirm(firm);
    }

    private void filterByPriceCase() {
        boolean isCorrect = false;
        int min = 0;
        int max = 0;
        while(!isCorrect) {
            try {
                TechnoStoreView.printMessage("\t Enter min price: \n");
                min = InputUtility.inputIntValue(this.view);
                Validator.checkPrice(min);
                isCorrect = true;
            } catch (PriceLessZeroException err) {
                TechnoStoreView.printErrorMessage(err.getMessage());
            }
        }

        isCorrect = false;
        while(!isCorrect) {
            try {
                TechnoStoreView.printMessage("\t Enter max price: \n");
                max = InputUtility.inputIntValue(this.view);
                Validator.checkPrice(max);
                isCorrect = true;
            } catch (PriceLessZeroException err) {
                TechnoStoreView.printMessage(err.getMessage());
            }
        }

        filterTechnoStoreByPrice(min, max);
    }

    private void filterByTypeCase() {
        String type = "";
        boolean isCorrect = false;
        while(!isCorrect) {
            try {
                TechnoStoreView.printMessage("\t Enter type: \n");
                type = InputUtility.inputStringValue(this.view);
                Validator.checkType(type);
                isCorrect = true;
            } catch (InvalidFormatTypeException | EmptyRequestException err) {
                TechnoStoreView.printErrorMessage(err.getMessage());
            }
        }
        filterTechnoStoreByType(type);
    }

    public void showAll() {
        view.printTechnoStoreDetails(model.getStock());
    }

    public void proceed() {
        this.model.updateData();
        TechnoStoreView.printMessage(TechnoStoreView.GREETING_MESSAGE);
        while (true) {
            TechnoStoreView.printMenu();
            int option = InputUtility.inputIntValue(this.view);
            switch (option) {
                case 1:
                    filterByTypeCase();
                    break;
                case 2:
                    filterByPriceCase();
                    break;
                case 3:
                    filterByFirmCase();
                    break;
                case 4:
                    showAll();
                    break;
                case 0:
                    TechnoStoreView.printMessage("\tThanks...\n");
                    return;
                default:
                    TechnoStoreView.printMessage("\tOption does not exist\n");
            }
        }
    }

}
