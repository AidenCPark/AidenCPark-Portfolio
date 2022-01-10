package Entities;

import java.util.ArrayList;

public class Report
{
    private int numberOfHousesListedInPeriod;
    private int numberOfHousesActive;
    private ArrayList<Property> housesRentedInPeriod;
    private int numberOfHousesRentedInPeriod;

    /**
     * Constructor
     * @param numberOfHousesListedInPeriod The number of properties currently listed
     * @param numberOfHousesActive The number of properties currently listed active
     * @param housesRentedInPeriod A list of properties currently listed rented
     */
    public Report(int numberOfHousesListedInPeriod, int numberOfHousesActive, ArrayList<Property> housesRentedInPeriod)
    {
        this.numberOfHousesListedInPeriod = numberOfHousesListedInPeriod;
        this.numberOfHousesActive = numberOfHousesActive;
        this.housesRentedInPeriod = housesRentedInPeriod;
        this.numberOfHousesRentedInPeriod = housesRentedInPeriod.size();
    }

    // General Getters and Setters:

    public int getNumberOfHousesListedInPeriod() {
        return this.numberOfHousesListedInPeriod;
    }

    public void setNumberOfHousesListedInPeriod(int numberOfHousesListedInPeriod) {
        this.numberOfHousesListedInPeriod = numberOfHousesListedInPeriod;
    }

    public int getNumberOfHousesActive() {
        return this.numberOfHousesActive;
    }

    public void setNumberOfHousesActive(int numberOfHousesActive) {
        this.numberOfHousesActive = numberOfHousesActive;
    }

    public int getNumberOfHousesRentedInPeriod() {
        return this.numberOfHousesRentedInPeriod;
    }

    public ArrayList<Property> getHousesRentedInPeriod() {
        return this.housesRentedInPeriod;
    }

    public void setHousesRentedInPeriod(ArrayList<Property> housesRentedInPeriod) {
        this.housesRentedInPeriod = housesRentedInPeriod;
        this.numberOfHousesRentedInPeriod = housesRentedInPeriod.size();
    }


}
