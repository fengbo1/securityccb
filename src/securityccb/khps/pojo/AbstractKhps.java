package securityccb.khps.pojo;
// default package



/**
 * AbstractKhps entity provides the base persistence definition of the Khps entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKhps  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String pnumber;
     private Integer item;
     private String date;
     private String jindu;
     private String status;
     private String preunder;
     private String thisunder;
     private String initiator;
     private String name;
     private String remark1;
     private String remark2;
     private String remark3;
     private Double score;


    // Constructors

    /** default constructor */
    public AbstractKhps() {
    }

    
    /** full constructor */
    public AbstractKhps(String jigouid, String pnumber, Integer item, String date, String jindu, String status, String preunder, String thisunder, String initiator, String name, String remark1, String remark2, String remark3, Double score) {
        this.jigouid = jigouid;
        this.pnumber = pnumber;
        this.item = item;
        this.date = date;
        this.jindu = jindu;
        this.status = status;
        this.preunder = preunder;
        this.thisunder = thisunder;
        this.initiator = initiator;
        this.name = name;
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

    public Integer getItem() {
        return this.item;
    }
    
    public void setItem(Integer item) {
        this.item = item;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getJindu() {
        return this.jindu;
    }
    
    public void setJindu(String jindu) {
        this.jindu = jindu;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public String getPreunder() {
        return this.preunder;
    }
    
    public void setPreunder(String preunder) {
        this.preunder = preunder;
    }

    public String getThisunder() {
        return this.thisunder;
    }
    
    public void setThisunder(String thisunder) {
        this.thisunder = thisunder;
    }

    public String getInitiator() {
        return this.initiator;
    }
    
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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