package com.kpi.controller;

import com.kpi.services.InputUtility;
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
                    TechnoStoreView.printMessage("\t Enter type: \n");
                    String type = InputUtility.inputStringValue(this.view);
                    filterTechnoStoreByType(type);
                    break;
                case 2:
                    TechnoStoreView.printMessage("\t Enter min price: \n");
                    int min = InputUtility.inputIntValue(this.view);

                    TechnoStoreView.printMessage("\t Enter max price: \n");
                    int max = InputUtility.inputIntValue(this.view);

                    filterTechnoStoreByPrice(min, max);
                    break;
                case 3:
                    TechnoStoreView.printMessage("\t Enter firm: \n");
                    String firm = InputUtility.inputStringValue(this.view);
                    filterTechnoStoreByFirm(firm);
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
