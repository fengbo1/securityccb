package securityccb.ndzj.pojo;

// default package



/**
 * Ndzj entity. @author MyEclipse Persistence Tools
 */
public class Ndzj extends AbstractNdzj implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Ndzj() {
    }

    
    /** full constructor */
    public Ndzj(String jigouid, String rtitle, String rfile, String year, String date, String remark1, String remark2) {
        super(jigouid, rtitle, rfile, year, date, remark1, remark2);        
    }
   
}
