package securityccb.record.pojo;
// default package


import java.util.Date;


/**
 * Record entity. @author MyEclipse Persistence Tools
 */
public class Record extends AbstractRecord implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Record() {
    }

    
    /** full constructor */
    public Record(String jigouid, String syssum, String type, Date date, String title, String content1, String content2, String people, String remark, String url1, String url2, String url3, String url4, String url5, String url6, String url7, String url8, String remark2, String remark3, String remark4) {
        super(jigouid, syssum, type, date, title, content1, content2, people, remark, url1, url2, url3, url4, url5, url6, url7, url8, remark2, remark3, remark4);        
    }
   
}
