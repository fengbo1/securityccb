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

	/** minimal constructor */
    public JiGou(Integer id) {
        super(id);        
    }
    
    /** full constructor */
    public JiGou(Integer id, String jigou, String quanxian, String remark1, String remark2, String remark3, String remark4, String remark5) {
        super(id, jigou, quanxian, remark1, remark2, remark3, remark4, remark5);        
    }
   
}
