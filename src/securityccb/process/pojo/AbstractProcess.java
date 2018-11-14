package securityccb.process.pojo;
// default package



/**
 * AbstractProcess entity provides the base persistence definition of the Process entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProcess  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String item;
     private String applicant;
     private String process;
     private String remark1;


    // Constructors

    /** default constructor */
    public AbstractProcess() {
    }

    
    /** full constructor */
    public AbstractProcess(String item, String applicant, String process, String remark1) {
        this.item = item;
        this.setApplicant(applicant);
        this.process = process;
        this.remark1 = remark1;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return this.item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }

    

    public String getProcess() {
        return this.process;
    }
    
    public void setProcess(String process) {
        this.process = process;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }


	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}


	public String getApplicant() {
		return applicant;
	}
   








}