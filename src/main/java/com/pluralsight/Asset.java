package com.pluralsight;

public abstract class Asset {

    private String description;
    private String dateAcquired;
    private double originalCost;

    public Asset(String description, String dateAcquired, double originalCost) {

        if (description == null) throw new IllegalArgumentException("description cannot be null");
        if (dateAcquired == null) throw new IllegalArgumentException("dateAcquired cannot be null");
        if (originalCost < 0) throw new IllegalArgumentException("originalCost cannot be negative");

        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;

    }

    public String getDescription() {
        return description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public abstract double getValue();

}