package DatabaseControllers;

import java.util.ArrayList;

public class EmailThread
{
    private int id;
    private String sender;
    private String reciever;

    /**
     * Constructor (USE FOR NEW EMIAIL THREADS)
     * @param id Unique ID of the Email Thread
     * @param sender Email Thread Sender
     * @param reciever Email Thread Recipient
     */
    public EmailThread(String sender, String reciever)
    {
        this.sender = sender;
        this.reciever = reciever;
    }

    /**
     * Constructor (Use for SELECT Email Thread)
     * @param id Unique ID of the Email Thread
     * @param sender Email Thread Sender
     * @param reciever Email Thread Recipient
     */
    public EmailThread(int id, String sender, String reciever)
    {
        this.id = id;
        this.sender = sender;
        this.reciever = reciever;
    }

    /**
     * Getter to return messages in associated with the Email Thread by its ID
     * @return Returns an array of the Thread Messages that make up the Email Thread.
     * These are chosen from the Database table using the Email Thread ID
     */
    public ArrayList<ThreadMessage> getThreadMessages()
    {
        return DataBaseManager.getInstance().SelectAllEmailThreadMessages(id);
    }

    /**
     * Adds a new String message to the Email Thread by creating a new Thread Message object
     * with a matching ID. The message is given a time stamp with time associated with when
     * this method is called. This Thread Message object is added to a table in the database.
     * @param message The message of the Email Thread Piece
     */
    public void addMessageToEmailThread(String message)
    {
        ThreadMessage threadMessage = new ThreadMessage(id, message);
        DataBaseManager.getInstance().addMessageToEmailThread(threadMessage);
    }

    // General Getters and Setters:

    public String getSender()
    {
        return this.sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getReciever()
    {
        return this.reciever;
    }

    public void setReciever(String reciever)
    {
        this.reciever = reciever;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}