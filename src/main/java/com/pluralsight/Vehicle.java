package com.pluralsight;

public class Vehicle extends Asset {
    private static final int CURRENT_YEAR = 2026;

    private String makeModel;
    private int    year;
    private int    odometer;

    public Vehicle(String description, String dateAcquired, double originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);

        if (makeModel == null)
            throw new IllegalArgumentException("makeModel cannot be null");
        if (year > CURRENT_YEAR)
            throw new IllegalArgumentException("year cannot be in the future, got: " + year);
        if (odometer < 0)
            throw new IllegalArgumentException("odometer cannot be negative, got: " + odometer);

        this.makeModel = makeModel;
        this.year      = year;
        this.odometer  = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }
    public int getYear() {
        return year;
    }
    public int getOdometer()  {
        return odometer;
    }

    @Override
    public double getValue() {
        double value = getOriginalCost();
        int    age   = CURRENT_YEAR - year;

        if (age >= 0 && age <= 3) {
            value = value - (getOriginalCost() * 0.03 * age);
        }
        else if (age >= 4 && age <= 6) {
            value = value - (getOriginalCost() * 0.06 * age);
        }
        else if (age >= 7 && age <= 10) {
            value = value - (getOriginalCost() * 0.08 * age);
        }
        else {
            value = 1000.00;
        }

        if (odometer > 100000) {
            String upperMake = makeModel.toUpperCase();
            if (!upperMake.contains("HONDA") && !upperMake.contains("TOYOTA")) {
                value = value * 0.75;
            }
        }

        return value;
    }
}