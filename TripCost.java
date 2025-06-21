//Kathryn Evans 
//CMSC215 Programming Project 3
//November 27, 2023
//This immutable class calculates the total trip cost. 

public final class TripCost {
    private final double distance; 
    private final double gasCost; 
    private final double gasMile; 
    private final int days; 
    private final double hotelCost; 
    private final double foodCost; 
    private final double attractions; 

    TripCost(
        double distance, 
        double gasCost, 
        double gasMile, 
        int days, 
        double hotelCost, 
        double foodCost, 
        double attractions
         ) {
        this.distance=distance; 
        this.gasCost=gasCost; 
        this.gasMile=gasMile; 
        this.days=days; 
        this.hotelCost=hotelCost; 
        this.foodCost=foodCost; 
        this.attractions=attractions; 
    }

    private double totGasCost(){
        return (distance/gasMile)*gasCost; 
        
    }

    private double totDailyCosts(){
        return days*(hotelCost+foodCost); 
    }

    public double totalTripCost(){
        return totDailyCosts()+totGasCost()+ attractions; 
    }
}
