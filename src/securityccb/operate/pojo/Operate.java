package securityccb.operate.pojo;
// default package



/**
 * Operate entity. @author MyEclipse Persistence Tools
 */
public class Operate extends AbstractOperate implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Operate() {
    }

    
    /** full constructor */
    public Operate(String jigouid, String pnumber, String otime, String odate, String viewernum, String viewername, Integer viewoption, String remark1, String remark2, String remark3, Double score) {
        super(jigouid, pnumber, otime, odate, viewernum, viewername, viewoption, remark1, remark2, remark3, score);        
    }
   
}
