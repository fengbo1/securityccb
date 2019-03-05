package securityccb.userinfo.pojo;
// default package



/**
 * AbstractFankui entity provides the base persistence definition of the Fankui entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFankui  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private String time;
     private String newnumber;
     private String jigou;
     private String title;
     private String content;
     private String fujian;


    // Constructors

    /** default constructor */
    public AbstractFankui() {
    }

    
    /** full constructor */
    public AbstractFankui(String date, String time, String newnumber, String jigou, String title, String content, String fujian) {
        this.date = date;
        this.time = time;
        this.newnumber = newnumber;
        this.jigou = jigou;
        this.title = title;
        this.content = content;
        this.fujian = fujian;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getJigou() {
        return this.jigou;
    }
    
    public void setJigou(String jigou) {
        this.jigou = jigou;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getFujian() {
        return this.fujian;
    }
    
    public void setFujian(String fujian) {
        this.fujian = fujian;
    }
   








}