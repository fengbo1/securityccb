package securityccb.gzjh.pojo;
// default package



/**
 * AbstractGzjh entity provides the base persistence definition of the Gzjh entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGzjh  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String ptitle;
     private String pfile;
     private String year;
     private String date;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractGzjh() {
    }

    
    /** full constructor */
    public AbstractGzjh(String jigouid, String ptitle, String pfile, String year, String date, String remark1, String remark2) {
        this.jigouid = jigouid;
        this.ptitle = ptitle;
        this.pfile = pfile;
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

    public String getPtitle() {
        return this.ptitle;
    }
    
    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPfile() {
        return this.pfile;
    }
    
    public void setPfile(String pfile) {
        this.pfile = pfile;
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