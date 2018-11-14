package securityccb.operate.pojo;
// default package



/**
 * AbstractOperate entity provides the base persistence definition of the Operate entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOperate  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String pnumber;
     private String otime;
     private String odate;
     private String viewernum;
     private String viewername;
     private Integer viewoption;
     private String remark1;
     private String remark2;
     private String remark3;
     private Double score;


    // Constructors

    /** default constructor */
    public AbstractOperate() {
    }

    
    /** full constructor */
    public AbstractOperate(String jigouid, String pnumber, String otime, String odate, String viewernum, String viewername, Integer viewoption, String remark1, String remark2, String remark3, Double score) {
        this.jigouid = jigouid;
        this.pnumber = pnumber;
        this.otime = otime;
        this.odate = odate;
        this.viewernum = viewernum;
        this.viewername = viewername;
        this.viewoption = viewoption;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.score = score;
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

    public String getPnumber() {
        return this.pnumber;
    }
    
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getOtime() {
        return this.otime;
    }
    
    public void setOtime(String otime) {
        this.otime = otime;
    }

    public String getOdate() {
        return this.odate;
    }
    
    public void setOdate(String odate) {
        this.odate = odate;
    }

    public String getViewernum() {
        return this.viewernum;
    }
    
    public void setViewernum(String viewernum) {
        this.viewernum = viewernum;
    }

    public String getViewername() {
        return this.viewername;
    }
    
    public void setViewername(String viewername) {
        this.viewername = viewername;
    }

    public Integer getViewoption() {
        return this.viewoption;
    }
    
    public void setViewoption(Integer viewoption) {
        this.viewoption = viewoption;
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

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }
   








}