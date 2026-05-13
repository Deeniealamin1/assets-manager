package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<Asset>();

        assets.add(new House(
                "My house",
                "2015-06-15",
                320000.00,
                "742 Evergreen Terrace, Springfield, IL",
                2,
                2100,
                9500
        ));

        assets.add(new House(
                "My vacation home",
                "2019-08-01",
                185000.00,
                "88 Lakeside Drive, Lake Geneva, WI",
                3,
                1400,
                14000
        ));

        assets.add(new Vehicle(
                "My daily driver",
                "2021-03-10",
                28500.00,
                "Honda Civic",
                2021,
                47000
        ));

        assets.add(new Vehicle(
                "Tom's truck",
                "2017-11-22",
                42000.00,
                "Ford F-150",
                2017,
                118000
        ));

        assets.add(new Vehicle(
                "My weekend car",
                "2023-07-04",
                55000.00,
                "Toyota Supra",
                2023,
                12000
        ));

        System.out.println("============================================================");
        System.out.println("                    ASSET PORTFOLIO                         ");
        System.out.println("============================================================");

        for (Asset currAsset : assets) {
            System.out.println();
            System.out.println("Description  : " + currAsset.getDescription());
            System.out.println("Date Acquired: " + currAsset.getDateAcquired());
            System.out.println("Original Cost: $" + currAsset.getOriginalCost());
            System.out.println("Current Value: $" + currAsset.getValue());

            if (currAsset instanceof House) {
                House house = (House) currAsset;
                System.out.println("Address      : " + house.getAddress());
                System.out.println("Condition    : " + house.getCondition() + "/4");
            } else if (currAsset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) currAsset;
                System.out.println("Vehicle      : " + vehicle.getYear() + " " + vehicle.getMakeModel());
                System.out.println("Odometer     : " + vehicle.getOdometer() + " miles");
            }

            double diff = currAsset.getValue() - currAsset.getOriginalCost();
            System.out.println("Gain / Loss  : $" + diff);
            System.out.println("------------------------------------------------------------");
        }

        System.out.println("============================================================");
    }
}