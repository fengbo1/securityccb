package securityccb.record.pojo;
// default package

import java.util.Date;


/**
 * AbstractRecord entity provides the base persistence definition of the Record entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRecord  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String jigouid;
     private String syssum;
     private String type;
     private Date date;
     private String title;
     private String content1;
     private String content2;
     private String people;
     private String remark;
     private String url1;
     private String url2;
     private String url3;
     private String url4;
     private String url5;
     private String url6;
     private String url7;
     private String url8;
     private String remark2;
     private String remark3;
     private String remark4;


    // Constructors

    /** default constructor */
    public AbstractRecord() {
    }

    
    /** full constructor */
    public AbstractRecord(String jigouid, String syssum, String type, Date date, String title, String content1, String content2, String people, String remark, String url1, String url2, String url3, String url4, String url5, String url6, String url7, String url8, String remark2, String remark3, String remark4) {
        this.jigouid = jigouid;
        this.syssum = syssum;
        this.type = type;
        this.date = date;
        this.title = title;
        this.content1 = content1;
        this.content2 = content2;
        this.people = people;
        this.remark = remark;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.url4 = url4;
        this.url5 = url5;
        this.url6 = url6;
        this.url7 = url7;
        this.url8 = url8;
        this.remark2 = remark2;
        this.remark3 = remark3;
        this.remark4 = remark4;
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

    public String getSyssum() {
        return this.syssum;
    }
    
    public void setSyssum(String syssum) {
        this.syssum = syssum;
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

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent1() {
        return this.content1;
    }
    
    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return this.content2;
    }
    
    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getPeople() {
        return this.people;
    }
    
    public void setPeople(String people) {
        this.people = people;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUrl1() {
        return this.url1;
    }
    
    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return this.url2;
    }
    
    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return this.url3;
    }
    
    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return this.url4;
    }
    
    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return this.url5;
    }
    
    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public String getUrl6() {
        return this.url6;
    }
    
    public void setUrl6(String url6) {
        this.url6 = url6;
    }

    public String getUrl7() {
        return this.url7;
    }
    
    public void setUrl7(String url7) {
        this.url7 = url7;
    }

    public String getUrl8() {
        return this.url8;
    }
    
    public void setUrl8(String url8) {
        this.url8 = url8;
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

    public String getRemark4() {
        return this.remark4;
    }
    
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
   








}