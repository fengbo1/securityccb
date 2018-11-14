package securityccb.score.pojo;
// default package



/**
 * AbstractScore entity provides the base persistence definition of the Score entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScore  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String year;
     private String pnumber;
     private String sub;
     private String newnumber;
     private String jigouid;
     private String item;
     private Integer num;
     private Integer indx;
     private Double score;
     private Double scoretemp;
     private Integer ifabb;
     private Integer ifxz;
     private Double stdscore;
     private Double yuanscore;
     private String xzreason;
     private String remark;
     private String remarktemp;


    // Constructors

    /** default constructor */
    public AbstractScore() {
    }

    
    /** full constructor */
    public AbstractScore(String year, String pnumber, String sub, String newnumber, String jigouid, String item, Integer num, Integer indx, Double score, Double scoretemp, Integer ifabb, Integer ifxz, Double stdscore, Double yuanscore, String xzreason, String remark, String remarktemp) {
        this.year = year;
        this.pnumber = pnumber;
        this.sub = sub;
        this.newnumber = newnumber;
        this.jigouid = jigouid;
        this.item = item;
        this.num = num;
        this.indx = indx;
        this.score = score;
        this.scoretemp = scoretemp;
        this.ifabb = ifabb;
        this.ifxz = ifxz;
        this.stdscore = stdscore;
        this.yuanscore = yuanscore;
        this.xzreason = xzreason;
        this.remark = remark;
        this.remarktemp = remarktemp;
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

    public String getPnumber() {
        return this.pnumber;
    }
    
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getSub() {
        return this.sub;
    }
    
    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getJigouid() {
        return this.jigouid;
    }
    
    public void setJigouid(String jigouid) {
        this.jigouid = jigouid;
    }

    public String getItem() {
        return this.item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getIndx() {
        return this.indx;
    }
    
    public void setIndx(Integer indx) {
        this.indx = indx;
    }

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }

    public Double getScoretemp() {
        return this.scoretemp;
    }
    
    public void setScoretemp(Double scoretemp) {
        this.scoretemp = scoretemp;
    }

    public Integer getIfabb() {
        return this.ifabb;
    }
    
    public void setIfabb(Integer ifabb) {
        this.ifabb = ifabb;
    }

    public Integer getIfxz() {
        return this.ifxz;
    }
    
    public void setIfxz(Integer ifxz) {
        this.ifxz = ifxz;
    }

    public Double getStdscore() {
        return this.stdscore;
    }
    
    public void setStdscore(Double stdscore) {
        this.stdscore = stdscore;
    }

    public Double getYuanscore() {
        return this.yuanscore;
    }
    
    public void setYuanscore(Double yuanscore) {
        this.yuanscore = yuanscore;
    }

    public String getXzreason() {
        return this.xzreason;
    }
    
    public void setXzreason(String xzreason) {
        this.xzreason = xzreason;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarktemp() {
        return this.remarktemp;
    }
    
    public void setRemarktemp(String remarktemp) {
        this.remarktemp = remarktemp;
    }
   








}