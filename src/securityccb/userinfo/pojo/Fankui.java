package securityccb.userinfo.pojo;
// default package



/**
 * Fankui entity. @author MyEclipse Persistence Tools
 */
public class Fankui extends AbstractFankui implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Fankui() {
    }

    
    /** full constructor */
    public Fankui(String date, String time, String newnumber, String jigou, String title, String content, String fujian) {
        super(date, time, newnumber, jigou, title, content, fujian);        
    }
   
}
