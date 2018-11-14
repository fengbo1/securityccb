package securityccb.chu.pojo;
// default package



/**
 * AbstractChu entity provides the base persistence definition of the Chu entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractChu  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String chushi;
     private String chushiid;


    // Constructors

    /** default constructor */
    public AbstractChu() {
    }

    
    /** full constructor */
    public AbstractChu(String jigouid, String chushi, String chushiid) {
        this.jigouid = jigouid;
        this.chushi = chushi;
        this.chushiid = chushiid;
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

    public String getChushi() {
        return this.chushi;
    }
    
    public void setChushi(String chushi) {
        this.chushi = chushi;
    }

    public String getChushiid() {
        return this.chushiid;
    }
    
    public void setChushiid(String chushiid) {
        this.chushiid = chushiid;
    }
   








}