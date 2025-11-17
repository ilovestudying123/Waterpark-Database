public class locker {

    private int locker_no;
    private boolean availability_status;
    private String size;    // ENUM('S', 'M', 'L')
    private Integer ticket_no;

    public locker() {}

    public locker(int locker_no, boolean availability_status, String size, Integer ticket_no) {
        this.locker_no = locker_no;
        this.availability_status = availability_status;
        this.size = size;
        this.ticket_no = ticket_no;
    }

    // locket_no
    public int getLocker_no() {
        return locker_no;
    }
    public void setLocker_no(int locker_no) {
        this.locker_no = locker_no;
    }

    // availability_status
    public boolean getAvailability_status() {
        return availability_status;
    }
    public void setAvailability_status(boolean availability_status) {
        this.availability_status = availability_status;
    }

    // size
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    // ticket_no
    public Integer getTicket_no() {
        return ticket_no;
    }
    public void setTicket_no(Integer ticket_no) {
        this.ticket_no = ticket_no;
    }
}