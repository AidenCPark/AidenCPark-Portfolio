package Entities;

import DatabaseControllers.DataBaseManager;
import DatabaseControllers.EmailThread;
import DatabaseControllers.SearchCriteria;
import DatabaseControllers.ThreadMessage;

public class RegisteredRenter extends RegisteredUser // implements Observer
{
    // private ArrayList<SavedSearch> subscriptions;

    /**
     * Constructor
     * @param name The name of this LandLord
     * @param emailAddress The email address of this LandLord
     * @param password The password of this LandLord
     * @param username The username of this LandLord
     */
    public RegisteredRenter(String name, String emailAddress, String password, String username)
    {
        this.name = name;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    /**
     * Sends a message from the subscription service to the renter that a new property matching a specified search was posted
     */
    public void notify(int searchID){
        EmailThread newPosting = new EmailThread(this.username, "Subscription Service");
        int ID = DataBaseManager.getInstance().addEmailThread(newPosting);
        DataBaseManager.getInstance().addMessageToEmailThread(new ThreadMessage(ID, "A new property has been posted matching your search - Search Number:" + searchID));
    }

    /**
     * Subscribe user to a search based on passed search criteria
     * @param sc search criteria to subscribe to
     */
    public void subscribeToSearch(SearchCriteria sc){
        int ID = DataBaseManager.getInstance().addSavedSearch(sc);
        DataBaseManager.getInstance().subscribe(ID, username);
    }
    /**
     * Unsubscribe user from specified search
     * @param searchID search to unsubscribe from
     */
    public void unsubscribeFromSearch(int searchID){
        DataBaseManager.getInstance().unsubscribe(searchID, username);
    }
}
