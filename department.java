public class department {

    private int department_no;
    private String department_name;
    private Integer manager_no;

    public department() {}

    public department(int department_no, String department_name, Integer manager_no) {
        this.department_no = department_no;
        this.department_name = department_name;
        this.manager_no = manager_no;
    }

    // department_no
    public int getDepartment_no() {
        return department_no;
    }
    public void setDepartment_no(int department_no) {
        this.department_no = department_no;
    }

    // departmet_name
    public String getDepartment_name() {
        return department_name;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    // manager_no
    public Integer getManager_no() {
        return manager_no;
    }
    public void setManager_no(Integer manager_no) {
        this.manager_no = manager_no;
    }
}