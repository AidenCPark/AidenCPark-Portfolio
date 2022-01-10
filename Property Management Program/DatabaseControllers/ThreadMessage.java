package DatabaseControllers;

import java.sql.Timestamp;

public class ThreadMessage
{
    private int id;
    private Timestamp timestamp;
    private String message;

    /**
     * Constructor
     * Constructor (USE FOR NEW THREAD MESSAGES)
     * @param id Unique ID of the Email Thread that this message belongs to
     * @param message The message of this Email Thread Piece
     */
    public ThreadMessage(int id, String message)
    {
        this.id = id;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.message = message;
    }

    /**
     * Constructor (Use for SELECT Thread Message)
     * @param id Unique ID of the Email Thread that this message belongs to
     * @param timestamp The unique timestamp of this message
     * @param message The message of this Email Thread Piece
     */
    public ThreadMessage(int id, Timestamp timestamp, String message)
    {
        this.id = id;
        this.timestamp = timestamp;
        this.message = message;
    }

    // General Getters and Setters:

    public Timestamp getTimestamp()
    {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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