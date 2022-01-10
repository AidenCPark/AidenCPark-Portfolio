package Entities;

import java.sql.Timestamp;
import java.util.ArrayList;

import DatabaseControllers.DataBaseManager;
import DatabaseControllers.PaymentSystem;

public class Manager extends RegisteredUser
{    
    /**
     * Constructor
     * @param name The name of this LandLord
     * @param emailAddress The email address of this LandLord
     * @param password The password of this LandLord
     * @param username The username of this LandLord
     */
    public Manager(String name, String emailAddress, String password, String username)
    {
        this.name = name;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    /**
     * Creates a new Report to display on for the Manager given a period 
     * @param startDate The start of Period
     * @param endDate The end of the Period
     * @return Returns the newly created report requested with the period
     */
    public Report createReport(Timestamp startDate, Timestamp endDate)
    {
        int numberOfHousesListedInPeriod = DataBaseManager.getInstance().GetListedPropertiesWithinPeriod(startDate, endDate).size();
        int numberOfHousesActive = DataBaseManager.getInstance().GetActiveProperties().size();
        ArrayList<Property> housesRentedInPeriod = DataBaseManager.getInstance().GetRentedPropertiesWithinPeriod(startDate, endDate);
        Report report = new Report(numberOfHousesListedInPeriod, numberOfHousesActive, housesRentedInPeriod);
        return report;
    }

    // Getters and Setters for manager functions:

    public void setFeeAmount(int propertyID, double fee)
    {
        PaymentSystem.managerUpdate(propertyID, fee, -1);
    }

    public void setFeePeriod(int propertyID, double days)
    {
        PaymentSystem.managerUpdate(propertyID, -1, days);
    }
}

