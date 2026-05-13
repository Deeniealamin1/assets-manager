package com.pluralsight;

public class House extends Asset {
    private String address;
    private int    condition;
    private int    squareFoot;
    private int    lotSize;

    public House(String description, String dateAcquired, double originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);

        if (address == null)
            throw new IllegalArgumentException("address cannot be null");
        if (condition < 1 || condition > 4)
            throw new IllegalArgumentException("condition must be 1-4, got: " + condition);
        if (squareFoot < 0)
            throw new IllegalArgumentException("squareFoot cannot be negative, got: " + squareFoot);
        if (lotSize < 0)
            throw new IllegalArgumentException("lotSize cannot be negative, got: " + lotSize);

        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress(){
        return address;
    }
    public int getCondition()  {
        return condition;
    }
    public int getSquareFoot() {
        return squareFoot;
    }
    public int getLotSize()    {
        return lotSize;
    }

    @Override
    public double getValue() {
        double pricePerSquareFoot;

        switch (condition) {
            case 1:  pricePerSquareFoot = 180.00; break;
            case 2:  pricePerSquareFoot = 130.00; break;
            case 3:  pricePerSquareFoot =  90.00; break;
            case 4:  pricePerSquareFoot =  80.00; break;
            default: pricePerSquareFoot =   0.00;
        }

        return (pricePerSquareFoot * squareFoot) + (0.25 * lotSize);
    }
}