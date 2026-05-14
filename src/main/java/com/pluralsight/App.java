package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(new House(
                "John's Summer House",
                "April 27th, 2022",
                500_000.,
                "42 Universe Way",
                1,
                1000,
                10000
        ));
        assets.add(new House(
                "John's Regular House",
                "April 27th, 2042",
                1_000_000.,
                "43 Universe Way",
                1,
                10000,
                50000
        ));
        assets.add(new Vehicle(
                "John's Definitely Real Car",
                "April 27th, 2015",
                50_000.,
                "Toyota Avalon",
                2014,
                10000
        ));
        assets.add(new Vehicle(
                "John's Definitely Real Second Car",
                "April 27th, 2016",
                60_000.,
                "Hyundai Elantra",
                2016,
                10000
        ));
        assets.add(new Cash(
                "Money under my mattress",
                "April 20th, 2020",
                4000.
        ));

        boolean isFirst = true;
        for (Asset asset : assets) {
            if (!isFirst) {
                System.out.println("---------------------------");
            }
            isFirst = false;
            System.out.printf("Description:      %s%n", asset.getDescription());
            System.out.printf("Acquisition Date: %s%n", asset.getDateAcquired());
            System.out.printf("Original Cost:    $%.2f%n", asset.getOriginalCost());
            System.out.printf("Value:            $%.2f%n", asset.getValue());
            if (asset instanceof House house) {
                System.out.printf("Address:          %s%n", house.getAddress());
            } else if (asset instanceof Vehicle vehicle) {
                System.out.printf("Year:             %d%n", vehicle.getYear());
                System.out.printf("Make & Model:     %s%n", vehicle.getMakeModel());
            }
        }
    }
}
