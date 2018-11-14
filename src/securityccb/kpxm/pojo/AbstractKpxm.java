package securityccb.kpxm.pojo;
// default package



/**
 * AbstractKpxm entity provides the base persistence definition of the Kpxm entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKpxm  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String khxm;
     private Integer xm;
     private Integer num;
     private Double stdscore;
     private String khnr;
     private String pfbz;
     private String pfqd;
     private String remark;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractKpxm() {
    }

    
    /** full constructor */
    public AbstractKpxm(String khxm, Integer xm, Integer num, Double stdscore, String khnr, String pfbz, String pfqd, String remark, String remark1, String remark2) {
        this.khxm = khxm;
        this.xm = xm;
        this.num = num;
        this.stdscore = stdscore;
        this.khnr = khnr;
        this.pfbz = pfbz;
        this.pfqd = pfqd;
        this.remark = remark;
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

    public String getKhxm() {
        return this.khxm;
    }
    
    public void setKhxm(String khxm) {
        this.khxm = khxm;
    }

    public Integer getXm() {
        return this.xm;
    }
    
    public void setXm(Integer xm) {
        this.xm = xm;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getStdscore() {
        return this.stdscore;
    }
    
    public void setStdscore(Double stdscore) {
        this.stdscore = stdscore;
    }

    public String getKhnr() {
        return this.khnr;
    }
    
    public void setKhnr(String khnr) {
        this.khnr = khnr;
    }

    public String getPfbz() {
        return this.pfbz;
    }
    
    public void setPfbz(String pfbz) {
        this.pfbz = pfbz;
    }

    public String getPfqd() {
        return this.pfqd;
    }
    
    public void setPfqd(String pfqd) {
        this.pfqd = pfqd;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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