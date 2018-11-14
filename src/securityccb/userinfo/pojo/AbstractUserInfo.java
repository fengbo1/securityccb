package securityccb.userinfo.pojo;
// default package



/**
 * AbstractUserInfo entity provides the base persistence definition of the UserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String position;
     private String name;
     private String newnumber;
     private String password;
     private String role;
     private String quanxian;
     private String remark1;
     private String address;
     private String tel;
     private String namesos;
     private String telsos;
     private String relation;


    // Constructors

    /** default constructor */
    public AbstractUserInfo() {
    }

	/** minimal constructor */
    public AbstractUserInfo(String newnumber) {
        this.newnumber = newnumber;
    }
    
    /** full constructor */
    public AbstractUserInfo(String position, String name, String newnumber, String password, String role, String quanxian, String remark1, String address, String tel, String namesos, String telsos, String relation) {
        this.position = position;
        this.name = name;
        this.newnumber = newnumber;
        this.password = password;
        this.role = role;
        this.quanxian = quanxian;
        this.remark1 = remark1;
        this.address = address;
        this.tel = tel;
        this.namesos = namesos;
        this.telsos = telsos;
        this.relation = relation;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public String getQuanxian() {
        return this.quanxian;
    }
    
    public void setQuanxian(String quanxian) {
        this.quanxian = quanxian;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNamesos() {
        return this.namesos;
    }
    
    public void setNamesos(String namesos) {
        this.namesos = namesos;
    }

    public String getTelsos() {
        return this.telsos;
    }
    
    public void setTelsos(String telsos) {
        this.telsos = telsos;
    }

    public String getRelation() {
        return this.relation;
    }
    
    public void setRelation(String relation) {
        this.relation = relation;
    }
   








}