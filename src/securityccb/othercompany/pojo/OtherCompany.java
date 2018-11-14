package securityccb.othercompany.pojo;
// default package



/**
 * OtherCompany entity. @author MyEclipse Persistence Tools
 */
public class OtherCompany extends AbstractOtherCompany implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public OtherCompany() {
    }

    
    /** full constructor */
    public OtherCompany(String jigouid, String company, String department, String job, String name, String tel, String phone, String remark, String remark1, String remark2) {
        super(jigouid, company, department, job, name, tel, phone, remark, remark1, remark2);        
    }
   
}
