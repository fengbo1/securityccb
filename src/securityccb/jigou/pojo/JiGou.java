package securityccb.jigou.pojo;
// default package



/**
 * JiGou entity. @author MyEclipse Persistence Tools
 */
public class JiGou extends AbstractJiGou implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public JiGou() {
    }

    
    /** full constructor */
    public JiGou(String jigou, String jigouid, String quanxian, String remark1, String remark2, String remark3, String remark4, String remark5) {
        super(jigou, jigouid, quanxian, remark1, remark2, remark3, remark4, remark5);        
    }
   
}
