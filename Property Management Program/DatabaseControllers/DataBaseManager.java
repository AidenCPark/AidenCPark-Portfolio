package DatabaseControllers;

import java.util.*;

import Entities.*;
import java.sql.*;
import java.sql.Timestamp;

public class DataBaseManager
{
    private static DataBaseManager instance;

    /**
     * Handles singleton pattern
     */
    public static DataBaseManager getInstance()
    {
        if (instance == null)
        {
            instance = new DataBaseManager();
        }
        return instance;
    }

    public DataBaseManager(){}
    
    /**
     * returns a Connection object to the database
     * @return Connnection Object
     */
    public Connection getConnection(){
        try{
            Connection dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/propertymanagement", "User", "ensf480");
            return dbConnect;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Used to search the database for properties matching user provided conditions.
     * @param sc Search criteria, contains conditions to find matching properties for.
     * @return ArrayList of properties that match the search criteria.
     */
    public ArrayList<Property> PropertySearch(SearchCriteria sc){
        Connection dbConnect = getConnection();
        ArrayList<Property> matches = new ArrayList<Property>();
        if(dbConnect == null){return matches;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery(sc.getQuery());
            while(results.next()){
                matches.add(new Property(results.getInt("id"),results.getString("propOwner"),results.getString("propType"),
                                results.getInt("numberOfBedrooms"),results.getInt("numberOfBathrooms"),results.getBoolean("furnished"),
                                results.getString("quadrant"),results.getDouble("price"), results.getString("propStatus"),results.getDouble("fee"),
                                results.getTimestamp("feeDue"),results.getBoolean("feePaid"),results.getTimestamp("listDate"),
                                results.getTimestamp("rentDate")));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return matches;
    }

    /**
     * Used to search the database for properties owned by specified user
     * @param username landlord username
     * @return ArrayList of properties that match the username
     */
    public ArrayList<Property> LandlordProperties(String username){
        Connection dbConnect = getConnection();
        ArrayList<Property> matches = new ArrayList<Property>();
        if(dbConnect == null){return matches;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM property WHERE propOwner = '" + username + "'");
            while(results.next()){
                matches.add(new Property(results.getInt("id"),results.getString("propOwner"),results.getString("propType"),
                                results.getInt("numberOfBedrooms"),results.getInt("numberOfBathrooms"),results.getBoolean("furnished"),
                                results.getString("quadrant"),results.getDouble("price"), results.getString("propStatus"),results.getDouble("fee"),
                                results.getTimestamp("feeDue"),results.getBoolean("feePaid"),results.getTimestamp("listDate"),
                                results.getTimestamp("rentDate")));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return matches;
    }

    

    /**
     * Provides an array of all the properties listed active within the in all time.
     * @return Returns an array of all the database properties listed active.
     */
    public ArrayList<Property> GetActiveProperties()
    {
        Connection dbConnect = getConnection();
        ArrayList<Property> matches = new ArrayList<Property>();
        if(dbConnect == null){return matches;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM property WHERE propStatus = 'active'");
            while(results.next()){
                matches.add(new Property(results.getInt("id"),results.getString("propOwner"),results.getString("propType"),
                                results.getInt("numberOfBedrooms"),results.getInt("numberOfBathrooms"),results.getBoolean("furnished"),
                                results.getString("quadrant"),results.getDouble("price"), results.getString("propStatus"),results.getDouble("fee"),
                                results.getTimestamp("feeDue"),results.getBoolean("feePaid"),results.getTimestamp("listDate"),
                                results.getTimestamp("rentDate")));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return matches;
    }

    /**
     * Provides an array of all the properties listed within the specified period.
     * @param startDate The inclusive start timestamp of the period
     * @param endDate The inclusive end timestamp of the period
     * @return Returns an array of all the database properties that match
     * within the specified period.
     */
    public ArrayList<Property> GetListedPropertiesWithinPeriod(Timestamp startDate, Timestamp endDate)
    {
        Connection dbConnect = getConnection();
        ArrayList<Property> matches = new ArrayList<Property>();
        if(dbConnect == null){return matches;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM property WHERE listDate BETWEEN '" + startDate + "' AND '" + endDate + "'");
            while(results.next()){
                matches.add(new Property(results.getInt("id"),results.getString("propOwner"),results.getString("propType"),
                                results.getInt("numberOfBedrooms"),results.getInt("numberOfBathrooms"),results.getBoolean("furnished"),
                                results.getString("quadrant"),results.getDouble("price"), results.getString("propStatus"),results.getDouble("fee"),
                                results.getTimestamp("feeDue"),results.getBoolean("feePaid"),results.getTimestamp("listDate"),
                                results.getTimestamp("rentDate")));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return matches;
    }

    /**
     * Provides an array of all the properties listed as rented within the specified period.
     * @param startDate The inclusive start timestamp of the period
     * @param endDate The inclusive end timestamp of the period
     * @return Returns an array of all the database properties that match
     * rented within the specified period.
     */
    public ArrayList<Property> GetRentedPropertiesWithinPeriod(Timestamp startDate, Timestamp endDate)
    {
        Connection dbConnect = getConnection();
        ArrayList<Property> matches = new ArrayList<Property>();
        if(dbConnect == null){return matches;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM property WHERE propStatus = 'rented' AND rentDate BETWEEN '" + startDate + "' AND '" + endDate + "'");
            while(results.next()){
                matches.add(new Property(results.getInt("id"),results.getString("propOwner"),results.getString("propType"),
                                results.getInt("numberOfBedrooms"),results.getInt("numberOfBathrooms"),results.getBoolean("furnished"),
                                results.getString("quadrant"),results.getDouble("price"), results.getString("propStatus"),results.getDouble("fee"),
                                results.getTimestamp("feeDue"),results.getBoolean("feePaid"),results.getTimestamp("listDate"),
                                results.getTimestamp("rentDate")));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return matches;
    }

    /**
     * Provides an array of all the emails stored with a sender or reciever
     * matching the username provided.
     * @param username The username of the user who can view the emails
     * @return Returns an array of all the database emails that match
     * the username input.
     */
    public ArrayList<EmailThread> SelectAllUserEmailThreads(String username){
        Connection dbConnect = getConnection();
        ArrayList<EmailThread> messages = new ArrayList<EmailThread>();
        if(dbConnect == null){return messages;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM emailthreads WHERE renter_un = '" + username + "'");
            while(results.next()){
                messages.add(new EmailThread(results.getInt("thread_id"), results.getString("landlord_un"),results.getString("renter_un")));
            }

            results = myStmt.executeQuery("WHERE landlord_un = '" + username + "'");
            while(results.next()){
                messages.add(new EmailThread(results.getInt("thread_id"), results.getString("landlord_un"),results.getString("renter_un")));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return messages;
    }

    /**
     * Provides the Email Thread that has a matching Email Thread ID to
     * that which is provided.
     * @param threadID The ID of the Email Thread
     * @return Returns the Email thread of matching Email Thread ID
     */
    public EmailThread SelectEmailThread(String threadID){
        Connection dbConnect = getConnection();
        EmailThread selection = null;
        if(dbConnect == null){return selection;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM emailthreads WHERE thread_id = '" + threadID + "'");
            if(results.next()){
                selection = new EmailThread(results.getInt("thread_id"),results.getString("renter_un"),results.getString("landlord_un"));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return selection;
    }

    /**
     * Provides an array of all the emails messages stored
     * under the Email Thread of the provided Email Thread ID.
     * @param emailThreadID The Email Thread ID of the Email Thread that the
     * messages belong to.
     * @return Returns an array of all the database email message that match
     * the username Email Thread ID input.
     */
    public ArrayList<ThreadMessage> SelectAllEmailThreadMessages(int emailThreadID){
        Connection dbConnect = getConnection();
        ArrayList<ThreadMessage> messages = new ArrayList<ThreadMessage>();
        if(dbConnect == null){return messages;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM threadmessages WHERE thread_id = '" + emailThreadID + "'");
            while(results.next()){
                messages.add(new ThreadMessage(results.getInt("thread_id"), results.getTimestamp("time"),results.getString("Message")));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return messages;
    }

    /**
     * Grabs a specific property from the database matching the provided ID.
     * @param id Property ID.
     * @return The property being selected.
     */
    public Property SelectProperty(int id){
        Connection dbConnect = getConnection();
        Property selection = null;
        if(dbConnect == null){return selection;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM property WHERE id = '" + id + "'");
            if(results.next()){
                selection = new Property(results.getInt("id"),results.getString("propOwner"),results.getString("propType"),
                                results.getInt("numberOfBedrooms"),results.getInt("numberOfBathrooms"),results.getBoolean("furnished"),
                                results.getString("quadrant"),results.getDouble("price"), results.getString("propStatus"),results.getDouble("fee"),
                                results.getTimestamp("feeDue"),results.getBoolean("feePaid"),results.getTimestamp("listDate"),
                                results.getTimestamp("rentDate"));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return selection;
    }

    /**
     * Grabs a specific landlord from the database matching the provided username.
     * @param username The landlord's unique username.
     * @return The landlord being selected.
     */
    public Landlord SelectLandlord(String username){
        Connection dbConnect = getConnection();
        Landlord selection = null;
        if(dbConnect == null){return selection;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM registeredusers WHERE username = '" + username + "' AND usertype = 'LANDLORD'");
            if(results.next()){
                selection = new Landlord(results.getString("name"),results.getString("email"),results.getString("password"),
                                results.getString("username"));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return selection;
    }

    /**
     * Grabs a specific manager from the database matching the provided username.
     * @param username The manager's unique username.
     * @return The manager being selected.
     */
    public Manager SelectManager(String username){
        Connection dbConnect = getConnection();
        Manager selection = null;
        if(dbConnect == null){return selection;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM registeredusers WHERE username = '" + username + "' AND usertype = 'MANAGER'");
            if(results.next()){
                selection = new Manager(results.getString("name"),results.getString("email"),results.getString("password"),
                                results.getString("username"));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return selection;
    }

    /**
     * Grabs a specific renter from the database matching the provided username.
     * @param username The renter's unique username.
     * @return The renter being selected.
     */
    public RegisteredRenter SelectRenter(String username){
        Connection dbConnect = getConnection();
        RegisteredRenter selection = null;
        if(dbConnect == null){return selection;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM registeredusers WHERE username = '" + username + "' AND usertype = 'RENTER'");
            if(results.next()){
                selection = new RegisteredRenter(results.getString("name"),results.getString("email"),results.getString("password"),
                                results.getString("username"));
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return selection;
    }

    /**
     * Grabs the type of a user from the database matching the provided username.
     * @param username The user's unique username.
     * @return The type of the user being selected.
     */
    public String SelectType(String username){
        Connection dbConnect = getConnection();
        String selection = null;
        if(dbConnect == null){return selection;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT usertype FROM registeredusers WHERE username = '" + username + "'");
            if(results.next()){
                selection = results.getString("usertype");
            }
            results.close();
            myStmt.close();
            dbConnect.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return selection;
    }

    /**
     * Adds the provided property to the database.
     * @param p Property to be added.
     */
    public int addProperty(Property p){
        int propID = -1;
        Connection dbConnect = getConnection();
        if(dbConnect == null){return propID;}
        try{
            String query = "INSERT INTO property (propOwner, propType, numberOfBedrooms, numberOfBathrooms, furnished, quadrant, price, propStatus, feeDue, feePaid, listDate, rentDate, fee) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            myStmt.setString(1, p.getOwner());
            myStmt.setString(2, p.getType());
            myStmt.setInt(3, p.getNumberOfBedRooms());
            myStmt.setInt(4, p.getNumberOfBathRooms());
            myStmt.setBoolean(5, p.isFurnished());
            myStmt.setString(6,p.getQuadrant());
            myStmt.setDouble(7, p.getPrice());
            myStmt.setString(8, p.getStatus());
            myStmt.setDate(9, new java.sql.Date(p.getFeeDue().getTime()));
            myStmt.setBoolean(10, p.getPaymentStatus());
            myStmt.setDate(11, new java.sql.Date(p.getListDate().getTime()));
            if(p.getRentDate() == null){myStmt.setDate(12, null);}
            else{myStmt.setDate(12, new java.sql.Date(p.getRentDate().getTime()));}
            myStmt.setDouble(13, p.getFee());
            myStmt.executeUpdate();
            ResultSet results = myStmt.getGeneratedKeys();
            results.next();
            propID = results.getInt(1);

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return propID;
    }

    /**
     * Adds the provided renter to the database.
     * @param r The renter to be added.
     */
    public void addRenter(RegisteredRenter r){
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "INSERT INTO registeredusers (name, email, password, username, usertype) VALUES (?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, r.getName());
            myStmt.setString(2, r.getEmail());
            myStmt.setString(3, r.getPassword());
            myStmt.setString(4, r.getUsername());
            myStmt.setString(5, "RENTER");
            myStmt.executeUpdate();
            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Adds the provided landlord to the database.
     * @param l Landlord to be added.
     */
    public void addLandlord(Landlord l){
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "INSERT INTO registeredusers (name, email, password, username, usertype) VALUES (?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, l.getName());
            myStmt.setString(2, l.getEmail());
            myStmt.setString(3, l.getPassword());
            myStmt.setString(4, l.getUsername());
            myStmt.setString(5, "LANDLORD");
            myStmt.executeUpdate();
            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Adds the provided manager to the database.
     * @param m Manager to be added.
     */
    public void addManager(Manager m){
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "INSERT INTO registeredusers (name, email, password, username, usertype) VALUES (?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, m.getName());
            myStmt.setString(2, m.getEmail());
            myStmt.setString(3, m.getPassword());
            myStmt.setString(4, m.getUsername());
            myStmt.setString(5, "MANAGER");
            myStmt.executeUpdate();

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Adds a new Email Thread to the database.
     * @param emailThread The Email Thread object to use to add to the database.
     * @return Returns the automatically generated email thread ID value.
     */
    public int addEmailThread(EmailThread emailThread){
        int ID = -1;
        Connection dbConnect = getConnection();
        if(dbConnect == null){return -1;}
        try{
            String query = "INSERT INTO emailthreads (renter_un, landlord_un) VALUES (?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            myStmt.setString(1, emailThread.getSender());
            myStmt.setString(2, emailThread.getReciever());
            myStmt.executeUpdate();
            ResultSet results = myStmt.getGeneratedKeys();
            results.next();
            ID = results.getInt(1);

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return ID;
    }

    /**
     * Adds a new Email Thread Message to the database.
     * @param threadMessage The Email Thread Message object to use to add to the database.
     */
    public void addMessageToEmailThread(ThreadMessage threadMessage){
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "INSERT INTO threadmessages (thread_id, time, Message) VALUES (?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, threadMessage.getId());
            myStmt.setTimestamp(2, threadMessage.getTimestamp());
            myStmt.setString(3, threadMessage.getMessage());
            myStmt.executeUpdate();

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * checks if a property matches any savedsearches and returns those that do
     * @param p Property to check for.
     * @return List of IDs corresponding to each property in the saved search.
     */
    public ArrayList<savedSearch> checkSavedSearch(Property p){
        Connection dbConnect = getConnection();
        ArrayList<savedSearch> searches = new ArrayList<>();
        if(dbConnect == null){return searches;}
        try{
            StringBuilder query = new StringBuilder("SELECT * FROM savedsearches WHERE ");
            if(p.getType() == null){query.append("(propType IS NULL");}
            else{query.append("(propType IS NULL OR propType = '" + p.getType().toString()+"')");}
            query.append("AND (numberOfBedrooms IS NULL OR numberOfBedrooms <= " + p.getNumberOfBedRooms()+")");
            query.append("AND (numberOfBathrooms IS NULL OR numberOfBathrooms <= " + p.getNumberOfBathRooms()+")");
            query.append("AND (furnished IS NULL OR furnished = " + p.isFurnished()+")");
            if(p.getQuadrant() == null){query.append("(quadrant IS NULL");}
            else{query.append("AND (quadrant is NULL or quadrant = '" + p.getQuadrant().toString() + "')");}
            query.append("AND (maxPrice is NULL or maxPrice >= " + p.getPrice() + ")");

            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery(query.toString());

            //This can be altered to return more if desired
            while(results.next()){
                propType type = null;
                if(results.getString(2) != null){type = propType.valueOf(results.getString(2));}
                quadrantEnum quadrant = null;
                if(results.getString(6) != null){quadrant = quadrantEnum.valueOf(results.getString(6));}
                searches.add(new savedSearch(results.getInt(1), new SearchCriteria(type,results.getInt(3),results.getInt(4),null,quadrant,null)));
            }

            myStmt.close();
            results.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return searches;
    }

    /**
     * returns all users subscribed to this 
     * @param searchID saved search iD
     * @return List of IDs corresponding to each property in the saved search.
     */
    public ArrayList<RegisteredRenter> getSubscribers(int searchID){
        Connection dbConnect = getConnection();
        ArrayList<RegisteredRenter> subscribers = new ArrayList<>();
        if(dbConnect == null){return subscribers;}
        try{
            StringBuilder query = new StringBuilder("SELECT * FROM registeredusers WHERE usertype = 'RENTER' AND username IN (SELECT username from subscriptions WHERE searchID = " + searchID + ")");
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery(query.toString());

            //This can be altered to return more if desired
            while(results.next()){
                subscribers.add(new RegisteredRenter(results.getString("name"),results.getString("email"),results.getString("password"),results.getString("username")));
            }
            myStmt.close();
            results.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return subscribers;
    }

    /**
     * verifies a usersname and email don't exist in the database
     * @param username username
     * @param email email
     */
    public boolean registerVerify(String username, String email){
        Connection dbConnect = getConnection();
        boolean unique = true;
        if(dbConnect == null){return false;};
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM registeredusers WHERE username = '"+ username + "' OR email = '" + email + "'");

            //This can be altered to return more if desired
            while(results.next()){
                unique = false;
            }
            myStmt.close();
            results.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return unique;
    }
    /**
     * verifies a users credentials exist in the DB
     * @param username username
     * @param password password
     */
    public boolean login(String username, String password){
        Connection dbConnect = getConnection();
            boolean success = false;
            if(dbConnect == null){return false;};
            try{
                Statement myStmt = dbConnect.createStatement();
                ResultSet results = myStmt.executeQuery("SELECT * FROM registeredusers WHERE username = '"+ username + "' AND password = '" + password + "'");

                //This can be altered to return more if desired
                while(results.next()){
                    success = true;
                }
                myStmt.close();
                results.close();
                dbConnect.close();

            } catch(SQLException e){
                e.printStackTrace();
            }
            return success;
    }
    /**
     * stores a search in teh database for users to subscribe to
     * @param sc search criteria of the search
     */
    public int addSavedSearch(SearchCriteria sc){
        Connection dbConnect = getConnection();
        int ID = -1;
        if(dbConnect == null){return ID;}
        try{
            String query = "SELECT * FROM savedsearches WHERE propType = ? AND numberOfBedrooms = ? AND numberOfBathrooms = ? AND quadrant = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            if(sc.getType() == null){myStmt.setString(1, null);}
            else{myStmt.setString(1, sc.getType().toString());}
            myStmt.setInt(2, sc.getMinBedrooms());
            myStmt.setInt(3, sc.getMinBathrooms());
            if(sc.getQuadrant() == null){myStmt.setString(4,null);}
            else{myStmt.setString(4,sc.getQuadrant().toString());}
            ResultSet results = myStmt.executeQuery();
            if(results.next()){
                ID = results.getInt("searchId");
            }
            else{
                query = "INSERT INTO savedsearches (propType, numberOfBedrooms, numberOfBathrooms, furnished, quadrant, maxPrice) VALUES (?,?,?,null,?,null)";
                myStmt = dbConnect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                if(sc.getType() == null){myStmt.setString(1, null);}
                else{myStmt.setString(1, sc.getType().toString());}
                myStmt.setInt(2, sc.getMinBedrooms());
                myStmt.setInt(3, sc.getMinBathrooms());
                if(sc.getQuadrant() == null){myStmt.setString(4,null);}
                else{myStmt.setString(4,sc.getQuadrant().toString());}
                myStmt.executeUpdate();
                results = myStmt.getGeneratedKeys();
                results.next();
                ID = results.getInt(1);
            }
            results.close();
            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return ID;
    }
    /**
     * subscribes a specified user to a specified searchID
     * @param username user to subscribe
     * @param searchID subsciption to add
     */
    public void subscribe(int searchID, String username){
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "INSERT INTO subscriptions (searchID, username) VALUES (?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, searchID);
            myStmt.setString(2, username);
            myStmt.executeUpdate();

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * unsubscribes a specified user from a specified searchID
     * @param username user to unsubscribe
     * @param searchID subsciption to remove
     */
    public void unsubscribe(int searchID, String username){
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "DELETE FROM subscriptions WHERE searchID = " + searchID + " AND username = '" + username + "'";
            Statement myStmt = dbConnect.createStatement();
            myStmt.executeUpdate(query);

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * Retreives all subscriptions for a specified user
     * @param username user to retrieve subscriptions for
     */
    public ArrayList<savedSearch> getAllUsersSubscriptions(String username){
        ArrayList<savedSearch> subscriptions  = new ArrayList<>();
        Connection dbConnect = getConnection();
        if(dbConnect == null){return subscriptions;}
        try{
            String query = "SELECT * FROM savedsearches WHERE searchID IN (SELECT searchID FROM subscriptions WHERE username = '" + username + "')";
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery(query);
            while(results.next()){
                propType type = null;
                if(results.getString(2) != null){type = propType.valueOf(results.getString(2));}
                quadrantEnum quadrant = null;
                if(results.getString(6) != null){quadrant = quadrantEnum.valueOf(results.getString(6));}
                subscriptions.add(new savedSearch(results.getInt(1), new SearchCriteria(type,results.getInt(3),results.getInt(4),null,quadrant,null)));
            }

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return subscriptions;
    }

    /**
     * Updates the provided property fees with new fee info.
     * @param p Property to be updated.
     */
    public void updatePropertyFees(Property p)
    {
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "UPDATE property SET fee = ?, feeDue = ?, feePaid = ? WHERE id = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setDouble(1, p.getFee());
            myStmt.setTimestamp(2, p.getFeeDue());
            myStmt.setBoolean(3, p.getFeePaid());
            myStmt.setInt(4, p.getId());
            myStmt.executeUpdate();

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * gets the saved fee for property listings
     * @return returns fee amount stored in db
     */
    public double getFeeAmount(){
        Connection dbConnect = getConnection();
        double fee = -1;
        if(dbConnect == null){return fee;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("Select `value` FROM payment WHERE parameter = 'fee'");
            results.next();
            fee = results.getDouble(1);

            results.close();
            myStmt.close();
            dbConnect.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return fee;
    }
    /**
     * gets the saved fee period for property listings
     * @return returns fee period stored in db
     */
    public double getFeePeriod(){
        Connection dbConnect = getConnection();
        double period = -1;
        if(dbConnect == null){return period;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("Select `value` FROM payment WHERE parameter = 'period'");
            results.next();
            period = results.getDouble(1);

            results.close();
            myStmt.close();
            dbConnect.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return period;
    }
    /**
     * Updates the saved information the listing fee and period
     * @param fee new fee amount to be saved
     * @param period new fee period to be saved
     */
    public void updatePayment(double fee, double period){
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            Statement myStmt = dbConnect.createStatement();
            myStmt.executeUpdate("UPDATE payment SET value = " + fee + " WHERE parameter = 'fee'");
            myStmt.executeUpdate("UPDATE payment SET value = " + period + " WHERE parameter = 'period'");

            myStmt.close();
            dbConnect.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }
    
    /**
     * Updates the provided property with new price info.
     * @param propertyID ID of the Property to be updated.
     * @param newPrice New price for the Property
     */
    public void updatePropertyPrice(int propertyID, double newPrice)
    {
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            String query = "UPDATE property SET price = ? WHERE id = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            myStmt.setDouble(1, newPrice);
            myStmt.setInt(2, propertyID);
            myStmt.executeUpdate();

            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Updates the provided property with new rental status.
     * @param propertyID ID of the Property to be updated.
     * @param newPropStatus New rental status.
     */
    public void updatePropertyStatus(int propertyID, propStatus newPropStatus)
    {
        Connection dbConnect = getConnection();
        if(dbConnect == null){return;}
        try{
            PreparedStatement myStmt;
            if(newPropStatus.toString().equals("rented")){
                String query = "UPDATE property SET propStatus = ?, rentDate = ? WHERE id = ?";
                myStmt = dbConnect.prepareStatement(query);
                myStmt.setString(1, newPropStatus.toString());
                myStmt.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
                myStmt.setInt(3, propertyID);
            }
            else{
                String query = "UPDATE property SET propStatus = ? WHERE id = ?";
                myStmt = dbConnect.prepareStatement(query);
                myStmt.setString(1, newPropStatus.toString());
                myStmt.setInt(2, propertyID);
            }
            myStmt.executeUpdate();
            myStmt.close();
            myStmt.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * gets fee associated with a property
     * @param propertyID ID of the Property to be updated.
     */
    public double getPropFee(int propertyID)
    {
        double fee = -1;
        Connection dbConnect = getConnection();
        if(dbConnect == null){return fee;}
        try{
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT fee FROM property WHERE id = " + propertyID);
            results.next();
            fee = results.getDouble(1);
            myStmt.close();
            results.close();
            dbConnect.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return fee;
    }
}



