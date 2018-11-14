package securityccb.score.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.config.dao.ScoreFlagDAO;
import securityccb.config.pojo.ScoreFlag;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.operate.dao.OperateDAO;
import securityccb.operate.pojo.Operate;
import securityccb.score.dao.ScoreDAO;
import securityccb.userinfo.action.UserInfoFind;
import securityccb.util.KhpsUtil;
import ccb.hibernate.HibernateSessionFactory;

public class ScoreAction {
	private static final Log log = LogFactory.getLog(ScoreAction.class);
	private	String	pnumber;
	private	String	sub;
	private String year;
	private	String	newnumber;
	private	String	date;
	private	String	time;
	private	String	jigouid;
	private String  ifcanpingfen;
	private	String thisunder;
    
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getThisunder() {
		return thisunder;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIfcanpingfen() {
		return ifcanpingfen;
	}
	public void setIfcanpingfen(String ifcanpingfen) {
		this.ifcanpingfen = ifcanpingfen;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		KhpsDAO kd=new KhpsDAO();
		Khps k=null;
		OperateDAO opdao=new OperateDAO();
		ScoreDAO sdao = new ScoreDAO();
		 UserInfoFind uif=new UserInfoFind();
		 JiGouDAO jgdao = new JiGouDAO();
         int sub= Integer.parseInt(jgdao.findSubByJigou(jigouid));  //从jigou表中查到主分中心标识位
	     String sql = "";
         String jindu="1";
	     String status="0"; // 0自评提交，1流转中，2已退回待处理，3已撤销，4已完成
	     String initiator=newnumber;
	     String name=uif.findnamebynewnumber(newnumber);
	     Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			if(!ifcanpingfen.equals("tui"))
			{
				sql = "delete from khps where remark3='"+year+"' and jigouid='"+jigouid+"'";
				session.createSQLQuery(sql).executeUpdate();
			}
			sql = "update score set score=scoretemp,remark=remarktemp where year='"+year+"' and jigouid='"+jigouid+"'";
			session.createSQLQuery(sql).executeUpdate();
		Date now = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYYMMdd");
		SimpleDateFormat bartTimeFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat bartTimeFormats = new SimpleDateFormat("HHmmssms");
		double sumscore = sdao.findSumByYearAndJigou(jigouid, year,"score");
		String times=bartTimeFormats.format(now).substring(0, 8);
		date = bartDateFormat.format(now);
		time = bartTimeFormat.format(now);

		if(ifcanpingfen.equals("tui"))
		{
			k=kd.findAllByPnumber(pnumber);	
		}
		else
		{
			pnumber=date+times+jigouid;
			k=new Khps();	
			k.setDate(date);
			k.setInitiator(initiator);
			k.setItem(sub);
			k.setJigouid(jigouid);
			k.setName(name);
			k.setPnumber(pnumber);
			k.setRemark3(year);
		}
		k.setStatus(status);
		k.setJindu(jindu);
		k.setScore(KhpsUtil.DoubleTo1(sumscore));
		k.setThisunder(thisunder);	
		//记录操作日志
		Operate op=new Operate();
		op.setJigouid(jigouid);
		op.setOdate(date);
		op.setOtime(time);
		op.setPnumber(pnumber);
		op.setViewername(name);
		op.setViewernum(newnumber);
		op.setScore(KhpsUtil.DoubleTo1(sumscore));
		op.setViewoption(0);//提交
		
		sql = "update score set pnumber='"+pnumber+"' where year='"+year+"' and jigouid='"+jigouid+"'";
		session.createSQLQuery(sql).executeUpdate();
			kd.merge(k);
			opdao.merge(op);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}	
		
		
		return "success";
	}
}

	