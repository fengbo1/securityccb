package securityccb.score.pojo;
// default package



/**
 * Score entity. @author MyEclipse Persistence Tools
 */
public class Score extends AbstractScore implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Score() {
    }

    
    /** full constructor */
    public Score(String year, String pnumber, String sub, String newnumber, String jigouid, String item, Integer num, Integer indx, Double score, Double scoretemp, Integer ifabb, Integer ifxz, Double stdscore, Double yuanscore, String xzreason, String remark, String remarktemp) {
        super(year, pnumber, sub, newnumber, jigouid, item, num, indx, score, scoretemp, ifabb, ifxz, stdscore, yuanscore, xzreason, remark, remarktemp);        
    }
   
}
