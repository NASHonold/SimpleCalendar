/**
 * @author Nash Honold
 */
package simplecalendar;

public class Date implements Comparable<Date>{
    //attributes
    private int year;
    private int month;
    private int day;
    //======================= Constructor ===========================
    public Date(int year, int month, int day)throws IllegalArgumentException
    {
        if (year < 2021 || year > 2080){
            throw new IllegalArgumentException(
                            "Year must be between 2021 and 2080");
        }
        this.year = year;
        if (month<1 || month>12){
            throw new IllegalArgumentException(
                            "Month must be between 1 and 12");
        }
        this.month = month;
        
        if (day < 1 || day > 31 ){
            throw new IllegalArgumentException(
                            "Day must be between 1 and 31");
        }
        this.day = day;
    }
//========================== Getters ============================
    
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    
    //==================== String toString() ====================
    //returns a string obj int the format mm/dd/yyyy
    @Override
    public String toString(){
        return this.month + "/" +this.day + "/" + this.year;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Date)){
            return false;
        }
        if(this == obj){
            return true;
        }
        Date otherDate = (Date) obj;
        if(
                this.day == otherDate.getDay() && 
                this.month == otherDate.getMonth() && 
                this.year == otherDate.getYear()){
            return true;
        }
        else{
            return false;
        }
        
    }
    //===================== int compareTo() =======================
    //compares Date obj to another and returns 1 if this object is 
    //further in the future, 0 if the dates are the same, or -1 if
    // the other Date obj is further in the future. 
    @Override
    public int compareTo(Date otherDate){
        
        int yearDiff = this.year - otherDate.year;
        int monthDiff = this.month - otherDate.month;
        int dayDiff = this.day - otherDate.day;
        
        if(yearDiff > 0)//first check year
            return 1;
        else if(yearDiff < 0){
            return -1;
        }
        else if(monthDiff > 0){//2nd check month
            return 1;
        }
        else if(monthDiff < 0){
            return -1;
        }
        else if(dayDiff > 0){//finally check day
            return 1;
        }
        else if(dayDiff < 0){
            return -1;
        }
        else{
            return 0;
        }
    }
}
