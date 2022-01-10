package Entities;
import java.util.ArrayList;

import DatabaseControllers.DataBaseManager;
import DatabaseControllers.EmailThread;

public abstract class RegisteredUser
{
    protected String name;
    protected String emailAddress;
    protected String username;
    protected String password;

    public ArrayList<EmailThread> emailCache;
    
    /**
     * Returns a boolean to act as a user auethentication, asking for the user's
     * username and password. Returns true if the user's username and password matches.
     * Otherwise, the function returns false. Intended for use by a loop checking
     * a number of accounts to see if such a user exists.
     * @param username The user's username
     * @param password The user's password
     * @return Returns true if the user's username and password match this
     * Registered User. Otherwise, the function returns false.
     */
    public boolean confirmLogin(String username, String password)
    {
        if (this.username.equals(username) && this.password.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Updates the local emailCache of this user with the Email Threads that
     * have been sent or addressed to this Registered User. These Email Threads
     * are also returned by this method.
     * @return Returns an array of Email Threads from the database that match have a
     * sender or reciever matching this Registered User.
     */
    public ArrayList<EmailThread> getMyEmailThreads()
    {
        emailCache = DataBaseManager.getInstance().SelectAllUserEmailThreads(username);
        return emailCache;
    }

    // General Getters and Setters:

    public String getName()
    {
        return this.name;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getEmail(){
        return emailAddress;
    }

    public String getPassword(){
        return password;
    }
}
