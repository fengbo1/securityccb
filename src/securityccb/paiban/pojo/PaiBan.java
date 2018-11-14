package securityccb.paiban.pojo;
// default package

import java.util.Date;

/**
 * PaiBan entity. @author MyEclipse Persistence Tools
 */
public class PaiBan extends AbstractPaiBan implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PaiBan() {
	}

	/** full constructor */
	public PaiBan(String areaid, Date begindate, Date enddate,
			String newnumber1, String tel1, String remark1, String newnumber2,
			String tel2, String remark2, String remark, String remark3) {
		super(areaid, begindate, enddate, newnumber1, tel1, remark1,
				newnumber2, tel2, remark2, remark, remark3);
	}

}
