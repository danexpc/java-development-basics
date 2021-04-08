package com.kpi.controller;

import com.kpi.custom.exceptions.*;
import com.kpi.controller.validators.Validator;
import com.kpi.view.TechnoStoreView;
import com.kpi.models.TechnoStore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TechnoStoreController {
    private final TechnoStore model;
    private final TechnoStoreView view;

    private static final Logger LOGGER = LogManager.getLogger(TechnoStoreController.class.getName());

    public TechnoStoreController(){
        this.model = new TechnoStore();
        this.view = new TechnoStoreView();
    }

    public void filterTechnoStoreByType(String type) {
        TechnoStoreView.printTechnoStoreDetails(model.filterByType(type));
    }

    public void filterTechnoStoreByFirm(String firm) {
        TechnoStoreView.printTechnoStoreDetails(model.filterByFirm(firm));
    }

    public void filterTechnoStoreByPrice(int min, int max) {
        TechnoStoreView.printTechnoStoreDetails(model.filterByPrice(min, max));
    }

    private void filterByFirmCase() {
        String firm = view.getFirmField();
        filterTechnoStoreByFirm(firm);
    }

    private void filterByPriceCase() {
        boolean isCorrect = false;
        int min = 0;
        int max = 0;
        while(!isCorrect) {
            try {
                min = view.getMinPriceField();
                Validator.checkPrice(min);
                isCorrect = true;
            } catch (PriceLessZeroException err) {
                LOGGER.error(err.getMessage());
                TechnoStoreView.printErrorMessage(err.getMessage());
            }
        }

        isCorrect = false;
        while(!isCorrect) {
            try {
                max = view.getMaxPriceField();
                Validator.checkPrice(max);
                isCorrect = true;
            } catch (PriceLessZeroException err) {
                LOGGER.error(err.getMessage());
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
                type = view.getTypeField();
                Validator.checkType(type);
                isCorrect = true;
            } catch (InvalidFormatTypeException | EmptyRequestException err) {
                LOGGER.error(err.getMessage());
                TechnoStoreView.printErrorMessage(err.getMessage());
            }
        }
        filterTechnoStoreByType(type);
    }

    public void showAll() {
        TechnoStoreView.printTechnoStoreDetails(model.getStock());
    }

    public void saveLastRequest() {
        if(view.getIsSaveField()){
            try {
                String message = model.saveLastRequest();
                TechnoStoreView.printMessage(message);
            } catch (SaveUserDataException e) {
                LOGGER.error(e.getDevMessage());
                TechnoStoreView.printErrorMessage(e.getUserMessage());
            }
        }

    }

    public void proceed() {

        LOGGER.info("Started application proceed");
        try {
            this.model.updateData();
        } catch (UpdateDataException e) {
            LOGGER.error(e.getDevMessage());
            TechnoStoreView.printErrorMessage(e.getUserMessage());
            return;
        }
        TechnoStoreView.printMessage(TechnoStoreView.GREETING_MESSAGE);
        while (true) {
            TechnoStoreView.printMenu();
            int option = view.getMenuOption();
            switch (option) {
                case 1 -> {
                    filterByTypeCase();
                    saveLastRequest();
                }
                case 2 -> {
                    filterByPriceCase();
                    saveLastRequest();
                }
                case 3 -> {
                    filterByFirmCase();
                    saveLastRequest();
                }
                case 4 -> showAll();
                case 0 -> {
                    try {
                        this.model.saveData();
                    } catch (SaveStoreDataException e) {
                        LOGGER.error(e.getDevMessage());
                        TechnoStoreView.printErrorMessage(e.getUserMessage());
                        return;
                    }
                    TechnoStoreView.printMessage(TechnoStoreView.THANKS_MESSAGE);
                    LOGGER.info("Ended application proceed");
                    return;
                }
                default -> TechnoStoreView.printMessage(TechnoStoreView.UNKNOWN_OPTION);
            }
        }
    }

}
