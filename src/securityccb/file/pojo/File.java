package securityccb.file.pojo;
// default package

import java.util.Date;


/**
 * File entity. @author MyEclipse Persistence Tools
 */
public class File extends AbstractFile implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public File() {
    }

    
    /** full constructor */
    public File(String jigouid, String type, Date date, Date nowdate, String title, String url, String url1) {
        super(jigouid, type, date, nowdate, title, url, url1);        
    }
   
}
