package securityccb.khps.pojo;

// default package



/**
 * Khps entity. @author MyEclipse Persistence Tools
 */
public class Khps extends AbstractKhps implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Khps() {
    }

    
    /** full constructor */
    public Khps(String jigouid, String pnumber, Integer item, String date, String jindu, String status, String preunder, String thisunder, String initiator, String name, String remark1, String remark2, String remark3, Double score) {
        super(jigouid, pnumber, item, date, jindu, status, preunder, thisunder, initiator, name, remark1, remark2, remark3, score);        
    }
   
}
