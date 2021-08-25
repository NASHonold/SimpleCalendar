/**
 * @author Nash Honold
 */
package simplecalendar;

public class Event {
    //
    private Date date;
    private int start;
    private int end;
    private String description;
    //==================== Constructor =====================
    public Event(Date date, int start, int end, String description)
    throws IllegalArgumentException
    {
        this.date = date;
        if(start < 0 || start > 23){//checks start hour for in-range compliance
            throw new IllegalArgumentException("Start must be between 0 and 23");
        }
        if(end < 0 || end > 23){//checks end hour for in-range compliance
            throw new IllegalArgumentException("End must be between 0 and 23");
        }
        if(end < start){//checks that end proceeds start or they are equal
            throw new IllegalArgumentException("End must be the same or greater than start");
        }
        this.start = start;
        
        this.end = end;
        
        this.description = description;
        
        
    }
//====================== Getters ===========================
    public Date getDate() {
        return date;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getDescription() {
        return description;
    }
    //====================== void setDescription() =================
    // sets the description to a new string from arg
    public void setDescrption(String newDescription){
        this.description = newDescription;
    }
    //====================== String toString() ===================
    //returns a String in the format mm/dd/yyyy start--end:description
    @Override
    public String toString(){
        return this.date.toString() + " " + this.start 
                + "--" + this.end + ":" + this.description;
    }
    //======================= boolean equals() =====================
    //returns true if Event objects match
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Event)){
            return false;
        }
        if(this == obj){
            return true;
        }
        Event otherEvent = (Event)obj;
        if(
                this.date.equals(otherEvent.getDate())
                && this.start == otherEvent.getStart()
                && this.end == otherEvent.getEnd()
                && this.description.equals(otherEvent.getDescription())
                )
        {
            return true;
        }
        else
            return false;
    }
}
