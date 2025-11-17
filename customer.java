public class customer {

    private int customer_no;
    private String last_name;
    private String first_name;
    private int phone_number;
    private String email;
    private int number_of_visits;
    private boolean is_pwd;
    private Integer age;    // use wrapper to allow NULL

    public customer() {}

    public customer(int customer_no, String last_name, String first_name, int phone_number, String email, int number_of_visits, boolean is_pwd, Integer age) {
        this.customer_no = customer_no;
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone_number = phone_number;
        this.email = email;
        this.number_of_visits = number_of_visits;
        this.is_pwd = is_pwd;
        this.age = age;
    }

    // customer_no
    public int getCustomer_no() {
        return customer_no;
    }
    public void setCustomer_no(int customer_no) {
        this.customer_no = customer_no;
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

    // phone_number
    public int getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    // email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // number_of_visits
    public int getNumber_of_visits() {
        return number_of_visits;
    }
    public void setNumber_of_visits(int number_of_visits) {
        this.number_of_visits = number_of_visits;
    }

    // is_pwd
    public boolean getIs_pwd() {
        return is_pwd;
    }
    public void setIs_pwd(boolean is_pwd) {
        this.is_pwd = is_pwd;
    }

    // age
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}