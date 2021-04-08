package com.kpi.models.interfaces;

public interface Store<T> extends Updatable {
    T[] getStock();

    T[] filterByFirm(String filterFirm);
    T[] filterByPrice(double minPrice, double maxPrice);
    T[] filterByType(String filterType);
}
