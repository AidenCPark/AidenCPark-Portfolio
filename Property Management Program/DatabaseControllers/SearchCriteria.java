package DatabaseControllers;

import Entities.propType;
import Entities.quadrantEnum;

public class SearchCriteria
{

    private propType type = null;
    private Integer minBedrooms = null;
    private Integer minBathrooms = null;
    private Boolean furnished = null;
    private quadrantEnum quadrant= null;
    private Double maxPrice = null;

    /**
     * @param type Type of property.
     * @param bedrooms Number of bedrooms.
     * @param bathrooms Number of bathrooms.
     * @param furnished Boolean, indicates whether the property is furnished or not.
     * @param quadrant City quadrant (NW, NE, SW, SE).
     * @param price Maximum price in dollars.
     */
    public SearchCriteria(propType type, Integer bedrooms, Integer bathrooms, Boolean furnished, quadrantEnum quadrant, Double price){
        this.type = type;
        this.minBedrooms = bedrooms;
        this.minBathrooms = bathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.maxPrice = price;
    }

    /** Default Constructor */
    public SearchCriteria()
    {}

    /** //generates a string to be used for a query
     * @return Returns the query containing search conditions.
     */
    public String getQuery(){
        StringBuilder query = new StringBuilder();
        boolean andFlag = false;
        query.append("SELECT * FROM Property");
        if(type != null){
            query.append("WHERE propType = '" + type + "'");
            andFlag = true;
        }
        if(minBedrooms != null){
            if(andFlag){
                query.append(" AND ");
            }
            query.append("WHERE numberOfBedrooms >= " + minBedrooms.toString());
            andFlag = true;
        }
        if(minBathrooms != null){
            if(andFlag){
                query.append(" AND ");
            }
            query.append("WHERE numberOfBathrooms >= " + minBathrooms.toString());
            andFlag = true;
        }
        if(furnished != null){
            if(andFlag){
                query.append(" AND ");
            }
            query.append("WHERE furnished is " + furnished.toString());
            andFlag = true;
        }
        if(quadrant != null){
            if(andFlag){
                query.append(" AND ");
            }
            query.append("WHERE quadrant = '" + quadrant + "'");
            andFlag = true;
        }
        if(maxPrice != null){
            if(andFlag){
                query.append(" AND ");
            }
            query.append("WHERE price <= " + maxPrice.toString());
        }
        return query.toString();
    }

    // --------- Getters/Setters ----------

    public propType getType() {
        return this.type;
    }

    public void setType(propType type) {
        this.type = type;
    }

    public Integer getMinBedrooms() {
        return this.minBedrooms;
    }

    public void setMinBedrooms(Integer minBedrooms) {
        this.minBedrooms = minBedrooms;
    }

    public Integer getMinBathrooms() {
        return this.minBathrooms;
    }

    public void setMinBathrooms(Integer minBathrooms) {
        this.minBathrooms = minBathrooms;
    }

    public Boolean isFurnished() {
        return this.furnished;
    }

    public void setFurnished(Boolean furnished) {
        this.furnished = furnished;
    }

    public quadrantEnum getQuadrant() {
        return this.quadrant;
    }

    public void setQuadrant(quadrantEnum quadrant) {
        this.quadrant = quadrant;
    }

    public Double getMaxPrice() {
        return this.maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
        propType.valueOf("apartment");
    }

}