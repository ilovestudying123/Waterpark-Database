import java.sql.Date;

public class emp_role {

    private int employee_no;
    private String title;
    private Date from_date;
    private Date to_date;

    public emp_role() {}

    public emp_role(int employee_no, String title, Date from_date, Date to_date) {
        this.employee_no = employee_no;
        this.title = title;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    // employee_no
    public int getEmployee_no() {
        return employee_no;
    }
    public void setEmployee_no(int employee_no) {
        this.employee_no = employee_no;
    }

    // title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // from_date
    public Date getFrom_date() {
        return from_date;
    }
    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    // to_date
    public Date getTo_date() {
        return to_date;
    }
    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }
}