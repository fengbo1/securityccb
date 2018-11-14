package securityccb.plan.pojo;
// default package

import java.util.Date;


/**
 * Plan entity. @author MyEclipse Persistence Tools
 */
public class Plan extends AbstractPlan implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Plan() {
    }

    
    /** full constructor */
    public Plan(String jigouid, String year, String week, String month, String content, String result, String people, Date plandate, Date overdate, String remark, String remark1, String remark2, String remark3) {
        super(jigouid, year, week, month, content, result, people, plandate, overdate, remark, remark1, remark2, remark3);        
    }
   
}
