import java.sql.Date;

public class ride_attraction{

    private int ride_no;
    private String name;
    private String description;
    private Date date_of_inspection; 
    private int ride_capacity;
    private int height_requirement;
    private String ticket_requirement;    // ENUM('Adult', 'Child')
    private String status;                // ENUM('OPERATIONAL', 'DOWN')


    public ride_attraction(){}

    public ride_attraction(int ride_no, String name, String description, Date date_of_inspection, int ride_capacity, int height_requirement, String ticket_requirement, String status) {

        this.ride_no = ride_no;
        this.name = name;
        this.description = description;
        this.date_of_inspection = date_of_inspection;
        this.ride_capacity = ride_capacity;
        this.height_requirement = height_requirement;
        this.ticket_requirement = ticket_requirement;
        this.status = status;
    }

    // ride_no
    public int getRide_no(){
        return ride_no;
    }
    public void setRide_no(int ride_no){
        this.ride_no = ride_no;
    }

    // name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    // description
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    // date_of_inspection
    public String getDate_of_inspection(){
        return date_of_inspection;
    }
    public void setDate_of_inspection(Date date_of_inspection){
        this.date_of_inspection = date_of_inspection;
    }

    // ride_capacity
    public int getRide_capacity() {
        return ride_capacity;
    }
    public void setRide_capacity(int ride_capacity) {
        this.ride_capacity = ride_capacity;
    }

    // height_requirement
    public int getHeight_requirement() {
        return height_requirement;
    }
    public void setHeight_requirement(int height_requirement) {
        this.height_requirement = height_requirement;
    }

    // ticket_requirement
    public String getTicket_requirement() {
        return ticket_requirement;
    }
    public void setTicket_requirement(String ticket_requirement) {
        this.ticket_requirement = ticket_requirement;
    }

    // status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}