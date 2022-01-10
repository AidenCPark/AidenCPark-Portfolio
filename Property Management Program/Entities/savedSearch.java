
package Entities;

import java.util.ArrayList;

import DatabaseControllers.DataBaseManager;
import DatabaseControllers.SearchCriteria;

public class savedSearch{
    private int searchID = -1;
    private SearchCriteria sc;
    private ArrayList<RegisteredRenter> subscribers = new ArrayList<>();


    /**
     * Constructor (USE FOR RETRIEVING FROM DATABASE)
     * @param searchID Unique ID savedSearch
     * @param sc the searchcriteria associated with the saved search
     */
    public savedSearch(int searchID, SearchCriteria sc){
        this.searchID = searchID;
        this.sc = sc;
    }
    /**
     * Constructor (USE FOR ADDING NEW TO DB TO AUTO GEN KEY)
     * @param sc the searchcriteria associated with the saved search
     */
    public savedSearch(SearchCriteria sc){
        this.sc = sc;
    }
    /**
     * sets the member subscribers to an arraylist of all renters subscribed to this search
     */
    public void getSubscribers(){
        subscribers = DataBaseManager.getInstance().getSubscribers(searchID);
    }
    /**
     * Notifies all members of the subscribers list
     */
    public void notifyAllSubscribers(){
        for(RegisteredRenter instance: subscribers){
            instance.notify(searchID);
        }
    }

    // Setters and Getters
    public void setSearchID(int searchID){
        this.searchID = searchID;
    }

    public int getSearchID(){
        return searchID;
    }

    public void setSearchCriteria(SearchCriteria sc){
        this.sc = sc;
    }

    public SearchCriteria getSearchCriteria(){
        return sc;
    }
}
