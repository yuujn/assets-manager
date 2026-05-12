package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    private double depreciate(double original, double rate) {
        return original * (1. - rate);
    }

    private boolean isLongerLasting() {
        String lower = makeModel.toLowerCase();
        return lower.contains("honda") || lower.contains("toyota");
    }

    @Override
    public double getValue() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - year;

        double amt;
        if (age <= 3) {
            amt = depreciate(getOriginalCost(), .03 * age);
        } else if (age <= 6) {
            amt = depreciate(getOriginalCost(), .06 * age);
        } else if (age <= 10) {
            amt = depreciate(getOriginalCost(), .08 * age);
        } else {
            amt = 1000.;
        }

        if (odometer > 100_000 && !isLongerLasting()) {
            amt *= .75;
        }

        return amt;
    }
}
