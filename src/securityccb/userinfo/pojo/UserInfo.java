package securityccb.userinfo.pojo;
// default package



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
public class UserInfo extends AbstractUserInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UserInfo() {
    }

	/** minimal constructor */
    public UserInfo(String newnumber) {
        super(newnumber);        
    }
    
    /** full constructor */
    public UserInfo(String position, String name, String newnumber, String password, String role, String quanxian, String remark1, String address, String tel, String namesos, String telsos, String relation) {
        super(position, name, newnumber, password, role, quanxian, remark1, address, tel, namesos, telsos, relation);        
    }
   
}
