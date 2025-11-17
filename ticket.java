import java.sql.Date;

public class ticket {

    private int ticket_no;
    private int customer_no;
    private String ticket_type; // ENUM stored as String
    private Date date_purchased;
    private Date date_of_use;

    public ticket() {}

    public ticket(int ticket_no, int customer_no, String ticket_type, Date date_purchased, Date date_of_use) {
        this.ticket_no = ticket_no;
        this.customer_no = customer_no;
        this.ticket_type = ticket_type;
        this.date_purchased = date_purchased;
        this.date_of_use = date_of_use;
    }

    // ticket_no
    public int getTicket_no() {
        return ticket_no;
    }
    public void setTicket_no(int ticket_no) { 
        this.ticket_no = ticket_no;
    }

    // customer_no
    public int getCustomer_no() {
        return customer_no;
    }
    public void setCustomer_no(int customer_no) {
        this.customer_no = customer_no;
    }

    // ticket_type
    public String getTicket_type() {
        return ticket_type;
    }
    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    // date_purchased
    public Date getDate_purchased() {
        return date_purchased;
    }
    public void setDate_purchased(Date date_purchased) {
        this.date_purchased = date_purchased;
    }

    // date_of_use
    public Date getDate_of_use() {
        return date_of_use;
    }
    public void setDate_of_use(Date date_of_use) {
        this.date_of_use = date_of_use;
    }
}