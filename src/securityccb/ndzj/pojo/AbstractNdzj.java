package securityccb.ndzj.pojo;
// default package



/**
 * AbstractNdzj entity provides the base persistence definition of the Ndzj entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNdzj  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String rtitle;
     private String rfile;
     private String year;
     private String date;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractNdzj() {
    }

    
    /** full constructor */
    public AbstractNdzj(String jigouid, String rtitle, String rfile, String year, String date, String remark1, String remark2) {
        this.jigouid = jigouid;
        this.rtitle = rtitle;
        this.rfile = rfile;
        this.year = year;
        this.date = date;
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

    public String getRtitle() {
        return this.rtitle;
    }
    
    public void setRtitle(String rtitle) {
        this.rtitle = rtitle;
    }

    public String getRfile() {
        return this.rfile;
    }
    
    public void setRfile(String rfile) {
        this.rfile = rfile;
    }

    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
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