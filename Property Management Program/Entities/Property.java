package Entities;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import DatabaseControllers.PaymentSystem;

public class Property
{
    private int id;
    private String owner;
    private propType type;
    private int numberOfBedRooms; 
    private int numberOfBathRooms;
    private boolean furnished;
    private quadrantEnum quadrant;
    private double price;
    private propStatus status;
    private double fee;
    private Timestamp feeDue;
    private boolean feePaid;
    private Timestamp dateListed;
    private Timestamp dateRented = null;

    /**
     * Constructor to be used when querying database
     * @param id The id of this Property
     * @param owner The owner of this Property
     * @param type The type of Property this is
     * @param numberOfBedRooms The number of bed rooms this Property has
     * @param numberOfBathRooms The number of bath rooms this Property has
     * @param furnished A boolean telling whether or not this Property is furnished
     * @param quadrant The quadrant of the city this Property is located in
     * @param price The listed price of this Property
     */
    public Property(int id, String owner, String type, int numberOfBedRooms, 
                    int numberOfBathRooms, boolean furnished, String quadrant, 
                    double price, String status, double fee,  
                    Timestamp feeDue, boolean feePaid, Timestamp listDate, Timestamp rentDate)
    {
        this.id = id;
        this.owner = owner;
        this.type = propType.valueOf(type);
        this.numberOfBedRooms = numberOfBedRooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.furnished = furnished;
        this.quadrant = quadrantEnum.valueOf(quadrant);
        this.price = price;
        this.status = propStatus.valueOf(status);
        this.fee = fee; 
        this.feeDue = feeDue;
        this.feePaid = feePaid;
        this.dateListed = listDate;
        this.dateRented = rentDate;
    }
        /**
     * Constructor to be used when generating a new property
     * @param owner The owner of this Property
     * @param type The type of Property this is
     * @param numberOfBedRooms The number of bed rooms this Property has
     * @param numberOfBathRooms The number of bath rooms this Property has
     * @param furnished A boolean telling whether or not this Property is furnished
     * @param quadrant The quadrant of the city this Property is located in
     * @param price The listed price of this Property
     */
    public Property(String owner, String type, int numberOfBedRooms, 
                    int numberOfBathRooms, boolean furnished,
                    String quadrant, double price)
    {
        this.id = 0; //to replaced by mysql auto gen key
        this.owner = owner;
        this.type = propType.valueOf(type);
        this.numberOfBedRooms = numberOfBedRooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.furnished = furnished;
        this.quadrant = quadrantEnum.valueOf(quadrant);
        this.price = price;
        this.status = propStatus.active;
        this.fee = PaymentSystem.getPaymentSystem().getFee();
        Calendar cal = Calendar.getInstance();
        Date now = Calendar.getInstance().getTime();
        cal.setTime(now);
        cal.add(Calendar.DATE, (int)PaymentSystem.getPaymentSystem().getPeriod());
        Timestamp dueDate = new Timestamp(cal.getTime().getTime());

        this.feeDue = dueDate;
        this.feePaid = false;
        this.dateListed = new Timestamp(System.currentTimeMillis());
    }

    // General Getters and Setters:

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getOwner()
    {
        return this.owner;
    }

    public String getType()
    {
        return this.type.toString();
    }

    public void setType(String type)
    {
        this.type = propType.valueOf(type);
    }

    public int getNumberOfBedRooms()
    {
        return this.numberOfBedRooms;
    }

    public void setNumberOfBedRooms(int numberOfBedRooms)
    {
        this.numberOfBedRooms = numberOfBedRooms;
    }

    public int getNumberOfBathRooms()
    {
        return this.numberOfBathRooms;
    }

    public void setNumberOfBathRooms(int numberOfBathRooms)
    {
        this.numberOfBathRooms = numberOfBathRooms;
    }

    public boolean isFurnished()
    {
        return this.furnished;
    }

    public void setFurnished(boolean furnished)
    {
        this.furnished = furnished;
    }

    public String getQuadrant()
    {
        return this.quadrant.toString();
    }

    public void setQuadrant(String quadrant)
    {
        this.quadrant = quadrantEnum.valueOf(quadrant);
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setStatus(String status){
        this.status = propStatus.valueOf(status);
    }

    public String getStatus(){
        return status.toString();
    }

    public double getFee()
    {
        return this.fee;
    }

    public void setFee(double f)
    {
        this.fee = f;
    }

    public void setFeeDue(Timestamp d){
        this.feeDue = d;
    }

    public Timestamp getFeeDue(){
        return feeDue;
    }

    public void setFeePaid(boolean paid)
    {
        this.feePaid = paid;
    }

    public boolean getFeePaid()
    {
        return this.feePaid;
    }

    public boolean getPaymentStatus(){
        return feePaid;
    }

    public Timestamp getListDate(){
        return dateListed;
    }

    public void setListDate(){
        if(dateListed == null){
            dateListed = new Timestamp(System.currentTimeMillis());
        }
    }

    public Timestamp getRentDate(){
        return dateRented;
    }
}
