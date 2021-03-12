package com.kpi.interfaces;

import com.kpi.models.HomeAppliance;

public interface Store<T> extends Updatable {
    T[] getStock();

    T[] filterByFirm(String filterFirm);
    T[] filterByPrice(double minPrice, double maxPrice);
    T[] filterByType(String filterType);
}
