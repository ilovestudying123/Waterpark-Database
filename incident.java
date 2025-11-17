import java.sql.Date;

public class incident {

    private int incident_no;
    private Date date_of_incident; // NO TIME YET
    private String incident_desc;
    private String injuries_desc;
    private boolean reimbursement_status;
    private Integer employee_no;
    private int ride_no;

    public incident() {}

    public incident(int incident_no, Date date_of_incident, String incident_desc, String injuries_desc, boolean reimbursement_status, Integer employee_no, int ride_no) {
        this.date_of_incident = date_of_incident;
        this.incident_desc = incident_desc;
        this.injuries_desc = incident_desc;
        this.reimbursement_status = reimbursement_status;
        this.employee_no = employee_no;
        this.ride_no = ride_no;
    }

    // incident_no
    public int getIncident_no(){ 
        return incident_no; 
    }
    public void setIncident_no(int incident_no){
        this.incident_no = incident_no;
    }

    // date_of_incident
    public Date getDate_of_incident(){ 
        return date_of_incident;
    }
    public void setDate_of_incident(Date date_of_incident) {
        this.date_of_incident = date_of_incident;
    }

    // incident_desc
    public String getIncident_desc() {
        return incident_desc;
    }
    public void setIncident_desc(String incident_desc) {
        this.incident_desc = incident_desc;
    }

    // injuries_desc
    public String getInjuries_desc() {
        return injuries_desc;
    }
    public void setInjuries_desc(String injuries_desc) {
        this.injuries_desc = injuries_desc;
    }

    // reimbursement_status
    public boolean isReimbursement_status() {
        return reimbursement_status;
    }
    public void setReimbursement_status(boolean reimbursement_status) {
        this.reimbursement_status = reimbursement_status;
    }

    // employee_no
    public Integer getEmployee_no() {
        return employee_no;
    }
    public void setEmployee_no(Integer employee_no) { 
        this.employee_no = employee_no;
    }

    // ride_no
    public int getRide_no() {
        return ride_no;
    }
    public void setRide_no(int ride_no) {
        this.ride_no = ride_no;
    }
}