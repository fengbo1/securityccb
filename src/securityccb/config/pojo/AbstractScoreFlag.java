package securityccb.config.pojo;
// default package



/**
 * AbstractScoreFlag entity provides the base persistence definition of the ScoreFlag entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScoreFlag  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String year;
     private Integer flag;
     private Integer isnew;


    // Constructors

    /** default constructor */
    public AbstractScoreFlag() {
    }

    
    /** full constructor */
    public AbstractScoreFlag(String year, Integer flag, Integer isnew) {
        this.year = year;
        this.flag = flag;
        this.isnew = isnew;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }

    public Integer getFlag() {
        return this.flag;
    }
    
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getIsnew() {
        return this.isnew;
    }
    
    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }
   








}