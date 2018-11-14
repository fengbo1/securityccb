package securityccb.kpxm.pojo;
// default package



/**
 * Kpxm entity. @author MyEclipse Persistence Tools
 */
public class Kpxm extends AbstractKpxm implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Kpxm() {
    }

    
    /** full constructor */
    public Kpxm(String khxm, Integer xm, Integer num, Double stdscore, String khnr, String pfbz, String pfqd, String remark, String remark1, String remark2) {
        super(khxm, xm, num, stdscore, khnr, pfbz, pfqd, remark, remark1, remark2);        
    }
   
}
