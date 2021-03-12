package com.kpi.services;

import com.kpi.models.HomeAppliance;

public class DataService {
    public static HomeAppliance[] getTechnoStoreFromDatabase(){
        HomeAppliance[] list = new HomeAppliance[]{
                new HomeAppliance(
                        1,
                        "Refrigerator",
                        "RR20A1Z2YU8",
                        "Samsung Single Door ",
                        "Samsung",
                        8,
                        12000,
                        2018
                ),
                new HomeAppliance(
                        2,
                        "Cooktop",
                        "HD4928",
                        "Philips Induction Cook",
                        "Philips",
                        4,
                        2900,
                        2017
                ),
                new HomeAppliance(
                        3,
                        "Cooktop",
                        "PIC 20.0",
                        "Prestige Induction Cooktop",
                        "Prestige",
                        8,
                        3100,
                        2018
                ),
                new HomeAppliance(
                        4,
                        "Kettle",
                        "PKGSS 1.7L",
                        "Prestige Electric Kettle",
                        "Prestige",
                        8,
                        1100,
                        2019
                ),
                new HomeAppliance(
                        5,
                        "Microwave ",
                        "23SC3",
                        "IFB Convection Microwave",
                        "IFB",
                        8,
                        9000,
                        2019
                ),
                new HomeAppliance(
                        6,
                        "Microwave",
                        "CE1041DSB2",
                        "Samsung Convection Microwave",
                        "Samsung",
                        8,
                        11590,
                        2018
                ),
                new HomeAppliance(
                        7,
                        "Fryer",
                        "4.0",
                        "Prestige Litres Air Fryer",
                        "Prestige",
                        8,
                        6450,
                        2019
                ),
                new HomeAppliance(
                        8,
                        "Fryer",
                        "OF-KOA15CJ3",
                        "Kenstar Aster Oxy Fryer",
                        "Kenstar",
                        8,
                        8800,
                        2018
                ),
                new HomeAppliance(
                        9,
                        "Sandwich maker",
                        "01012053",
                        "Pigeon Sandwich Maker",
                        "Pigeon",
                        8,
                        12000,
                        2018
                ),
                new HomeAppliance(
                        10,
                        "Refrigerator",
                        "GL-D201ABPY",
                        "LG Single Door Refrigerator",
                        "LG",
                        11,
                        15000,
                        2019
                )
            };

        return list;
    }
}
