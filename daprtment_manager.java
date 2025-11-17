import java.sql.Date;

public class daprtment_manager {

    private int department_no;
    private int employee_no;
    private Date from_date;
    private Date to_date;

    public daprtment_manager() {}

    public daprtment_manager(int department_no, int employee_no, Date from_date, Date to_date) {
        this.department_no = department_no;
        this.employee_no = employee_no;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    // department_no
    public int getDepartment_no() {
        return department_no;
    }
    public void setDepartment_no(int department_no) {
        this.department_no = department_no;
    }

    // employee_no
    public int getEmployee_no() {
        return employee_no;
    }
    public void setEmployee_no(int employee_no) {
        this.employee_no = employee_no;
    }

    // from_date
    public Date getFrom_date() {
        return from_date;
    }
    public void setFrom_date(jDate from_date) {
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