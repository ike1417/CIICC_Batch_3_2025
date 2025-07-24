package Chapter1;
public class Tasksheet_1_2_2 { 

    public static void main(String[] args) {
      
        DateTask date1 = new DateTask(1, 1, 1978);        
        DateTask date2 = new DateTask(9, 21, 1984);
        System.out.println("Date 1: " + date1.toString());
        System.out.println("Date 2: " + date2.toString());
        
        System.out.println("\nDisplaying leap years from 1980 to 2023:");
        DateTask.leapYears(); 
    }
}

class DateTask { 
    
    byte day;
    byte month;
    short year;
        public DateTask() {
        
        this(1, 1, 1);     }
    
    public DateTask(int m, int d, int y) {
        setDate(m, d, y);
    }
    
    @Override 
    public String toString() {
        return month + "/" + day + "/" + year; 
    }
    public void setDate(int m, int d, int y) {
        if (valid(d, m, y)) { 
            day = (byte) d;
            year = (short) y;
            month = (byte) m;
        } else {            
            day = (byte) 0;
            year = (short) 0;
            month = (byte) 0;
            System.err.println("Invalid date provided to setDate: " + m + "/" + d + "/" + y + ". Date set to 0/0/0.");
        }
    }
    public static void leapYears() {
        for (int i = 1980; i <= 2023; i = i + 4) {
            if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
                System.out.println("The year " + i + " is a leap year");
            }
        }
    }
       public int getDay() {
        return day; 
    }
        public void setDay(int day) {
       
        if (valid(day, this.month, this.year)) {
            this.day = (byte) day;
        } else {
            this.day = (byte) 0; 
            System.err.println("Invalid day " + day + " for " + this.month + "/" + this.year + ". Day set to 0.");
        }
    }

       public int getMonth() {
        return month; 
    }
   
    public void setMonth(int month) {
        
        if (valid(this.day, month, this.year)) {
            this.month = (byte) month;
        } else {
            this.month = (byte) 0; 
            System.err.println("Invalid month " + month + " for " + this.day + "/" + this.year + ". Month set to 0.");
        }
    }
   
    public int getYear() {
        return year; 
    }
   
    public void setYear(int year) {
     
        if (valid(this.day, this.month, year)) {
            this.year = (short) year;
        } else {
            this.year = (short) 0;    System.err.println("Invalid year " + year + " for " + this.month + "/" + this.day + ". Year set to 0.");
        }
    }
    
    private boolean valid(int day, int month, int year) {
        if (day < 1 || month < 1 || month > 12 || year < 1) {
            System.err.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year + " (Basic range check failed)");
            return false;
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
    
        if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            daysInMonth[2] = 29; 
        }

        if (day > daysInMonth[month]) {
            System.err.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year + " (Day exceeds month's limit)");
            return false;
        }
        return true; 
    }
}
