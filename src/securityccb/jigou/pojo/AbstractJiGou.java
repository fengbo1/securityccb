package securityccb.jigou.pojo;
// default package



/**
 * AbstractJiGou entity provides the base persistence definition of the JiGou entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJiGou  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigou;
     private String jigouid;
     private String quanxian;
     private String remark1;
     private String remark2;
     private String remark3;
     private String remark4;
     private String remark5;


    // Constructors

    /** default constructor */
    public AbstractJiGou() {
    }

    
    /** full constructor */
    public AbstractJiGou(String jigou, String jigouid, String quanxian, String remark1, String remark2, String remark3, String remark4, String remark5) {
        this.jigou = jigou;
        this.jigouid = jigouid;
        this.quanxian = quanxian;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.remark4 = remark4;
        this.remark5 = remark5;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getJigou() {
        return this.jigou;
    }
    
    public void setJigou(String jigou) {
        this.jigou = jigou;
    }

    public String getJigouid() {
        return this.jigouid;
    }
    
    public void setJigouid(String jigouid) {
        this.jigouid = jigouid;
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

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return this.remark3;
    }
    
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return this.remark4;
    }
    
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return this.remark5;
    }
    
    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }
   








}