package com.kpi.models;

import com.kpi.interfaces.Store;
import com.kpi.services.DataService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class TechnoStore implements Store<HomeAppliance> {
    private HomeAppliance[] stock;
    private HomeAppliance[] lastRequest;

    public TechnoStore() {}

    public void updateData() throws Exception {
        try {
            stock = DataService.getTechnoStoreFromDatabase();
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("The shop is currently inaccessible\n");
        }
    }
    public void saveData() throws Exception {
        try {
            DataService.saveTechnoStoreToDatabase(stock);
        } catch (Exception e) {
            throw new Exception("Data may not be saved due to problems in our shop. Try check your orders later\n");
        }
    }
    public String saveLastRequest() throws Exception {
        try {
            String message = DataService.saveInterimDataToDatabase(lastRequest);
            return "Your data was successfully saved in file " + message + "\n";
        } catch (Exception e) {
            throw new Exception("Your data could not save. Try again later\n");
        }
    }

    public HomeAppliance[] filterByType(String filterType) {
        HomeAppliance[] filteredItems = new HomeAppliance[stock.length];
        int idx = 0;

        for (HomeAppliance item : this.stock) {
            if (item.getType().toLowerCase(Locale.ROOT).equals(filterType)) {
                filteredItems[idx++] = item;
            }
        }

        lastRequest = Arrays.copyOf(filteredItems, idx);
        return Arrays.copyOf(filteredItems, idx);
    }

    public HomeAppliance[] filterByPrice(double minPrice, double maxPrice) {
        HomeAppliance[] filteredItems = new HomeAppliance[stock.length];
        int idx = 0;

        for (HomeAppliance item : this.stock) {
            if (item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
                filteredItems[idx++] = item;
            }
        }

        lastRequest = Arrays.copyOf(filteredItems, idx);
        return Arrays.copyOf(filteredItems, idx);
    }

    public HomeAppliance[] filterByFirm(String filterFirm) {
        HomeAppliance[] filteredItems = new HomeAppliance[stock.length];
        int idx = 0;

        for (HomeAppliance item : this.stock) {
            if (item.getFirm().toLowerCase(Locale.ROOT).equals(filterFirm)) {
                filteredItems[idx++] = item;
            }
        }

        lastRequest = Arrays.copyOf(filteredItems, idx);
        return Arrays.copyOf(filteredItems, idx);
    }

    public HomeAppliance[] getStock() {
        return stock;
    }
}
