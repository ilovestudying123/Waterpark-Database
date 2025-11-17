import java.math.BigDecimal;
import java.sql.Date;

public class ride_attraction{

    private Date date_of_inspection;
    private int ride_no;
    private BigDecimal ph_level;        // DECIMAL
    private BigDecimal chlorine_level;  // DECIMAL
    private int violation_count;
    private String violation_desc;

    public ride_attraction(){}

    public ride_attraction(Date date_of_inspection, int ride_no, BigDeical ph_level, BigDecimal chlorine_level, int violation_count, String violation_desc){
        this.date_of_inspection = date_of_inspection;
        this.ride_no = ride_no;
        this.ph_level = ph_level;
        this. chlorine_level =  chlorine_level;
        this.violation_count = violation_count;
        this.violation_desc = violation_desc;
    }

    // date_of_inspection
    public Date getDate_of_inspection(){
        reutrn date_of_inspection;
    }
    public void setDate_of_inspection(Date date_of_inspection){
        this.date_of_inspection = date_of_inspection;
    }

    // ride_no
    public int getRide_no(){
        return ride_no;
    }
    public void setRide_no(int ride_no){
        this.ride_no = ride_no;
    }

    // ph_level
    public BigDecimal getPh_level(){
        return ph_level;
    }
    public void setPh_level(BigDecimal ph_level){
        this.ph_level = ph_level;
    }

    // chlorine_level
    public BigDecimal getChlorine_level(){
        return chlorine_level;
    }
    public void setChlorine_level(BigDecimal chlorine_level){
        this.chlorine_level = chlorine_level;
    }

    // voilation_count
    public int getViolation_count(){
        reutrn violation_count;
    }
    public void setViolation_count(int violation_count){
        this.violation_count = violation_count;
    }

    // violation_desc
    public int getViolation_desc(){
        return violation_desc;
    }
    public void setViolation_desc(int violation_desc){
        this.violation_desc = violation_desc;
    }
}
