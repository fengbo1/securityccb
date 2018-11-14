package securityccb.zhiban.pojo;
// default package

import java.sql.Time;
import java.util.Date;

/**
 * ZhiBan entity. @author MyEclipse Persistence Tools
 */
public class ZhiBan extends AbstractZhiBan implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ZhiBan() {
	}

	/** full constructor */
	public ZhiBan(String newnumber, String areaid, Date date, Time time,
			String cover, String covernewnumber, String remark, String remark1,
			String zhiban) {
		super(newnumber, areaid, date, time, cover, covernewnumber, remark,
				remark1, zhiban);
	}

}
