package com.kpi.services;

import com.kpi.models.entity.HomeAppliance;

import java.io.*;
import java.util.Arrays;

public class TechnoStoreDao {
    private static final String directory = System.getProperty("user.dir");
    private static final String fileName = "data.ser";
    private static final String fileInterimName = "userData.txt";
    private static final String pathToPacket = directory + File.separator + "src"
            + File.separator + "main"
            + File.separator + "resources" + File.separator;

    public static HomeAppliance[] getTechnoStoreFromDatabase() throws IOException, ClassNotFoundException {

        HomeAppliance[] list;

        try (FileInputStream fi = new FileInputStream(pathToPacket + fileName);
             ObjectInputStream oi = new ObjectInputStream(fi)){

            list = (HomeAppliance[]) oi.readObject();

        }

        return list;
    }

    public static void saveTechnoStoreToDatabase(HomeAppliance[] list) throws IOException{

        try (FileOutputStream f = new FileOutputStream(pathToPacket + fileName);
             ObjectOutputStream o = new ObjectOutputStream(f)){

            o.writeObject(list);

        }

    }

    public static String saveInterimDataToDatabase(HomeAppliance[] list) throws IOException{

        try (FileWriter fileWriter = new FileWriter(pathToPacket + fileInterimName, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)){

            printWriter.println(Arrays.toString(list));

            return fileInterimName;
        }
    }
}
