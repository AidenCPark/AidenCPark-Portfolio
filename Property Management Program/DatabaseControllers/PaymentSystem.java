package DatabaseControllers;

import Entities.Landlord;
import Entities.Property;

import java.util.Calendar;
import java.sql.Timestamp;

public class PaymentSystem
{
    private static PaymentSystem paymentSystem; // Singleton, this is the only instance

    private static double fee;
    private static double period;

    /**
     * default constructor
     */
    private PaymentSystem()
    {
        fee = DataBaseManager.getInstance().getFeeAmount();
        period = DataBaseManager.getInstance().getFeePeriod();
    }

    /**
     * getter for singleton pattern
     */
    public static PaymentSystem getPaymentSystem()
    {
        if(paymentSystem == null)
        {
            paymentSystem = new PaymentSystem();
        }
        return paymentSystem;
    }

    // Default setter
    public static void setPaymentSystem(PaymentSystem p)
    {
        PaymentSystem.paymentSystem = p;
    }

    public double getFee()
    {
        return fee;
    }

    public void setFee(double f)
    {
        fee = f;
    }

    public double getPeriod()
    {
        return period;
    }

    public void setPeriod(double p)
    {
        period = p;
    }

    /**
     * Call this function when a landlord pays a fee (takes landlord and property ID as input)
     * @param landlord The landlord making the payment
     * @param propID The ID of the property being paid for
     */
    public void landlordPaid(Landlord landlord, int propID)
    {
        if(landlord.getProperty(propID) == null) // if that property does not exist
        {
            // ---------- Error message to GUI, property not found ------------
            // Replace with appropriate error notification in GUI
            System.out.println("Error: Property not found (replace with GUI)");
        }
        else // if property exists
        {
            // update the property in the database to be "paid"
            Property temp = DataBaseManager.getInstance().SelectProperty(propID);
            temp.setFeePaid(true);
            //take the current due date and add the fee period to get the new due date
            Calendar cal = Calendar.getInstance();
            cal.setTime(DataBaseManager.getInstance().SelectProperty(propID).getFeeDue());
            cal.add(Calendar.DATE, (int)DataBaseManager.getInstance().getFeePeriod());
            Timestamp newDueDate = new Timestamp(cal.getTime().getTime());

            // update the due date in the database
            temp.setFeeDue(newDueDate);
            temp.setFee(DataBaseManager.getInstance().getFeeAmount());
            DataBaseManager.getInstance().updatePropertyFees(temp);
        }
    }

    /**
     * Used when manager requests to update property info
     * @param propID The ID of the property to edit
     * @param fee New fee for that property
     * @param period New payment period for that property
     */
    public static void managerUpdate(int propID, double fee, double p)
    {
        if(fee != -1)
        {
            Property temp = DataBaseManager.getInstance().SelectProperty(propID);
            temp.setFee(fee);
            DataBaseManager.getInstance().updatePropertyFees(temp);
        }
        if(period != -1)
        {
            period = p;
        }
    }
    /**
     * Updates the saved fee and period values in the database
     * @param fee New fee 
     * @param period New payment period
     */
    public static void updateFees(double fee, double period){
        PaymentSystem.getPaymentSystem().setFee(fee);
        PaymentSystem.getPaymentSystem().setPeriod(period);
        DataBaseManager.getInstance().updatePayment(fee, period);
    }
}
