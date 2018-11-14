package securityccb.othercompany.pojo;
// default package



/**
 * AbstractOtherCompany entity provides the base persistence definition of the OtherCompany entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOtherCompany  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String company;
     private String department;
     private String job;
     private String name;
     private String tel;
     private String phone;
     private String remark;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractOtherCompany() {
    }

    
    /** full constructor */
    public AbstractOtherCompany(String jigouid, String company, String department, String job, String name, String tel, String phone, String remark, String remark1, String remark2) {
        this.jigouid = jigouid;
        this.company = company;
        this.department = department;
        this.job = job;
        this.name = name;
        this.tel = tel;
        this.phone = phone;
        this.remark = remark;
        this.remark1 = remark1;
        this.remark2 = remark2;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getJigouid() {
        return this.jigouid;
    }
    
    public void setJigouid(String jigouid) {
        this.jigouid = jigouid;
    }

    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
   








}