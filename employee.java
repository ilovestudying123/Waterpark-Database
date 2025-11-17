import java.math.BigDecimal;

public class employee {

    private int employee_no;
    private String last_name;
    private String first_name;
    private String job_title;
    private Integer department_no;
    private Integer phone_number;
    private BigDecimal salary;
    private Integer ride_no;
    private boolean is_active;

    public employee() {}

    public employee(int employee_no, String last_name, String first_name, String job_title, Integer department_no, Integer phone_number, BigDecimal salary, Integer ride_no, boolean is_active) {
        this.employee_no = employee_no;
        this.last_name = last_name;
        this.first_name = first_name;
        this.job_title = job_title;
        this.department_no = department_no;
        this.phone_number = phone_number;
        this.salary = salary;
        this.ride_no = ride_no;
        this.is_active = is_active;
    }

    // employee_no
    public int getEmployee_no() {
        return employee_no;
    }
    public void setEmployee_no(int employee_no) {
        this.employee_no = employee_no;
    }

    // last_name
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    // first_name
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    // job_title
    public String getJob_title() {
        return job_title;
    }
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    // department_no
    public Integer getDepartment_no() {
        return department_no;
    }
    public void setDepartment_no(Integer department_no) {
        this.department_no = department_no;
    }

    // phone_number
    public Integer getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    // salary
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    // ride_no
    public Integer getRide_no() {
        return ride_no;
    }
    public void setRide_no(Integer ride_no) {
        this.ride_no = ride_no;
    }

    // active
    public boolean getIs_active() {
        return is_active;
    }
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}