public class customer_incident{

    private int incident_no;
    private int customer_no;

    public customer_incident() {}

    public customer_incident(int incident_no, int customer_no) {
        this.incident_no = incident_no;
        this.customer_no = customer_no;
    }

    // incident_no
    public int getIncident_no() {
        return incident_no;
    }
    public void setIncident_no(int incident_no) {
        this.incident_no = incident_no;
    }

    // customer_no
    public int getCustomer_no() {
        return customer_no;
    }
    public void setCustomer_no(int customer_no) {
        this.customer_no = customer_no;
    }
}