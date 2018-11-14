package securityccb.plan.pojo;
// default package

import java.util.Date;


/**
 * AbstractPlan entity provides the base persistence definition of the Plan entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPlan  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String year;
     private String week;
     private String month;
     private String content;
     private String result;
     private String people;
     private Date plandate;
     private Date overdate;
     private String remark;
     private String remark1;
     private String remark2;
     private String remark3;


    // Constructors

    /** default constructor */
    public AbstractPlan() {
    }

    
    /** full constructor */
    public AbstractPlan(String jigouid, String year, String week, String month, String content, String result, String people, Date plandate, Date overdate, String remark, String remark1, String remark2, String remark3) {
        this.jigouid = jigouid;
        this.year = year;
        this.week = week;
        this.month = month;
        this.content = content;
        this.result = result;
        this.people = people;
        this.plandate = plandate;
        this.overdate = overdate;
        this.remark = remark;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
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

    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }

    public String getWeek() {
        return this.week;
    }
    
    public void setWeek(String week) {
        this.week = week;
    }

    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return this.result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }

    public String getPeople() {
        return this.people;
    }
    
    public void setPeople(String people) {
        this.people = people;
    }

    public Date getPlandate() {
        return this.plandate;
    }
    
    public void setPlandate(Date plandate) {
        this.plandate = plandate;
    }

    public Date getOverdate() {
        return this.overdate;
    }
    
    public void setOverdate(Date overdate) {
        this.overdate = overdate;
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

    public String getRemark3() {
        return this.remark3;
    }
    
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
   








}