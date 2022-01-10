package Entities;

import DatabaseControllers.DataBaseManager;
import DatabaseControllers.PaymentSystem;

public class Landlord extends RegisteredUser
{
    /**
     * Constructor
     * @param name The name of this LandLord
     * @param emailAddress The email address of this LandLord
     * @param password The password of this LandLord
     * @param username The username of this LandLord
     */
    public Landlord (String name, String emailAddress, String password, String username)
    {
        this.name = name;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    /**
     * Registers a new property with this Landlord as its owner. This new property
     * is then stored in a table in the database.
     * @param newProperty The new property being registered
     */
    public void registerProperty(Property newProperty)
    {
        newProperty.setOwner(this.username);
        DataBaseManager.getInstance().addProperty(newProperty);
    }

    /**
     * Getter to return the unique property that this Landlord owns that
     * also matches the input property ID. 
     * @param propertyID The ID of the property that is to be returned
     * @return Returns the property owned by this Landlord that matches
     * input property ID.
     */
    public Property getProperty(int propertyID)
    {
        for (Property property : DataBaseManager.getInstance().LandlordProperties(username))
        {
            if (property.getId() == propertyID)
            {
                return property;
            }
        }

        return null;
    }

    /**
     * Changes the listed price for the property owned by this landlord that
     * has the input propertyID.
     * @param propertyID The ID of the property that is being changed
     * @param price The price that will become the new listed property price
     */
    public void changePropertyPrice(int propertyID, double newPrice)
    {
        if (DataBaseManager.getInstance().SelectProperty(propertyID).getOwner().equals(username))
        {
            DataBaseManager.getInstance().updatePropertyPrice(propertyID, newPrice);
        }
    }

    /**
     * Changes the listed price for the property owned by this landlord that
     * has the input propertyID.
     * @param propertyID The ID of the property that is being changed
     * @param price The price that will become the new listed property price
     */
    public void changePropertyStatus(int propertyID, propStatus newPropStatus)
    {
        if (DataBaseManager.getInstance().SelectProperty(propertyID).getOwner().equals(username))
        {
            DataBaseManager.getInstance().updatePropertyStatus(propertyID, newPropStatus);
        }
    }

    /**
     * Creates a string with all property fees
     * @return A single string that displays the IDs and corresponding fees for every property owned by this landlord.
     */
    public String showFees()
    {
        StringBuilder output = new StringBuilder();
        for (Property property : DataBaseManager.getInstance().LandlordProperties(username)) {

            output.append(property.getId()).append(": ");

            // If property fee has not been paid, show the fee amount, otherwise just display "PAID"
            if(!property.getFeePaid())
            {
                output.append(property.getFee()).append("\n");
            }
            else
            {
                output.append("PAID\n");
            }
        }
        return output.toString();
    }

    /**
     * Allows a landlord to make a fee payment for a property.
     * @param propertyID The ID of the property to pay the fee on.
     */
    public void makePayment(int propertyID)
    {
        PaymentSystem.getPaymentSystem().landlordPaid(this, propertyID);
    }

}