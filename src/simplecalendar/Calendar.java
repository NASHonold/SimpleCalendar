/*
 @author Nash Honold
 */
package simplecalendar;

public class Calendar {
    //attributes
    private static final int MAXEVENTS = 4;
    private Event[] events = new Event[MAXEVENTS];
    private int numEvents;
    //================== Constructor ====================
    public Calendar(){
        this.events = new Event[MAXEVENTS];
        this.numEvents = 0;
        
    }
    // =================== boolean addEvent() ====================
    // If the max number of events have not been stored then this 
    // will add the event to the calendar object
    public boolean addEvent(Event e){
        for(int index = 0; index< this.events.length;index++){
            if(this.events[index] == null){
                this.events[index] = e;
                return true;
            }
        }
        return false;
    }
    //=================== int findEvent() ========================
    //will check the calendar object to see if Event obj is already stored
    // if it is this will return the index it is located at in the array
    //if it is not found will return -1
    public int findEvent(Event e){
        int eventIndex = -1;
        for(int index = 0; index < this.events.length;index++ ){
            if(this.events[index] != null){
                if(this.events[index].equals(e)){
                    eventIndex = index;
                }
            }
        }
        if (eventIndex == -1){
            return -1;
        }
        else
            return eventIndex;
    }
    //===================== boolean removeEvent() ==================
    //If the event is found stored in Calendar obj then this will remove
    // that event and return false
    public boolean removeEvent(Event e){
        int index = findEvent(e);
        if (index == -1){
            return false;
        }
        else{
            this.events[index] = null;
            this.numEvents--;
            return true;
        }
    }
    //======================= void dump() ========================
    //Will print to console all events currently stored in Calendar obj
    public void dump(){
        for (Event event : this.events) {
            if (event != null) {
                System.out.println(event.toString());
            }
        }
    }
    
}
