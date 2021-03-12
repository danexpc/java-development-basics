package com.kpi.models;

import com.kpi.interfaces.Store;
import com.kpi.services.DataService;

import java.util.Arrays;
import java.util.Locale;

public class TechnoStore implements Store<HomeAppliance> {
    private HomeAppliance[] stock;

    public TechnoStore() {}

    public void updateData(){
        stock = DataService.getTechnoStoreFromDatabase();
    }

    public HomeAppliance[] filterByType(String filterType) {
        HomeAppliance[] filteredItems = new HomeAppliance[stock.length];
        int idx = 0;

        for (HomeAppliance item : this.stock) {
            if (item.getType().toLowerCase(Locale.ROOT).equals(filterType)) {
                filteredItems[idx++] = item;
            }
        }

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

        return Arrays.copyOf(filteredItems, idx);
    }

    public HomeAppliance[] getStock() {
        return stock;
    }
}
