package securityccb.file.pojo;
// default package

import java.util.Date;


/**
 * AbstractFile entity provides the base persistence definition of the File entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFile  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String type;
     private Date date;
     private Date nowdate;
     private String title;
     private String url;
     private String url1;


    // Constructors

    /** default constructor */
    public AbstractFile() {
    }

    
    /** full constructor */
    public AbstractFile(String jigouid, String type, Date date, Date nowdate, String title, String url, String url1) {
        this.jigouid = jigouid;
        this.type = type;
        this.date = date;
        this.nowdate = nowdate;
        this.title = title;
        this.url = url;
        this.url1 = url1;
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

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getNowdate() {
        return this.nowdate;
    }
    
    public void setNowdate(Date nowdate) {
        this.nowdate = nowdate;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl1() {
        return this.url1;
    }
    
    public void setUrl1(String url1) {
        this.url1 = url1;
    }
   








}