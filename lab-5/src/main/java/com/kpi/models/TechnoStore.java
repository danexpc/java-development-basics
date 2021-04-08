package com.kpi.models;

import com.kpi.custom.exceptions.SaveStoreDataException;
import com.kpi.custom.exceptions.SaveUserDataException;
import com.kpi.custom.exceptions.UpdateDataException;
import com.kpi.models.interfaces.Store;
import com.kpi.models.entity.HomeAppliance;
import com.kpi.services.TechnoStoreDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class TechnoStore implements Store<HomeAppliance> {

    private static final Logger LOGGER = LogManager.getLogger(TechnoStore.class.getName());

    private HomeAppliance[] stock;
    private HomeAppliance[] lastRequest;

    public TechnoStore() {
    }

    public void updateData() throws UpdateDataException {
        try {
            stock = TechnoStoreDao.getTechnoStoreFromDatabase();
            LOGGER.info("Updated store data");
        } catch (IOException | ClassNotFoundException e) {
            throw new UpdateDataException("The shop is currently inaccessible\n",
                    UpdateDataException.class.getName() +
                            " " + e.getMessage());
        }
    }
    public void saveData() throws SaveStoreDataException {
        try {
            TechnoStoreDao.saveTechnoStoreToDatabase(stock);
            LOGGER.info("Saved store data");
        } catch (Exception e) {
            throw new SaveStoreDataException("Data may not be saved due to problems in our shop. Try check your orders later\n",
                    SaveStoreDataException.class.getName() +
                            " " + e.getMessage());
        }
    }
    public String saveLastRequest() throws SaveUserDataException {
        try {
            String message = TechnoStoreDao.saveInterimDataToDatabase(lastRequest);
            LOGGER.info("Saved user data in file " + message);
            return "Your data was successfully saved in file " + message + "\n";
        } catch (Exception e) {
            throw new SaveUserDataException("Your data could not save. Try again later\n",
                    SaveUserDataException.class.getName() +
                            " " + e.getMessage());
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
