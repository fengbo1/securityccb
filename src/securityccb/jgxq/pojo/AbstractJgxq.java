package securityccb.jgxq.pojo;
// default package



/**
 * AbstractJgxq entity provides the base persistence definition of the Jgxq entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJgxq  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String jigoudesc;
     private String recordDate;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractJgxq() {
    }

    
    /** full constructor */
    public AbstractJgxq(String jigouid, String jigoudesc, String recordDate, String remark1, String remark2) {
        this.jigouid = jigouid;
        this.jigoudesc = jigoudesc;
        this.recordDate = recordDate;
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

    public String getJigoudesc() {
        return this.jigoudesc;
    }
    
    public void setJigoudesc(String jigoudesc) {
        this.jigoudesc = jigoudesc;
    }

    public String getRecordDate() {
        return this.recordDate;
    }
    
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
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