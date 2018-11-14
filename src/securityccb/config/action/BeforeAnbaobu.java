package securityccb.config.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import securityccb.config.dao.ScoreFlagDAO;
import securityccb.config.pojo.ScoreFlag;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.util.DateTimeUtil;

public class BeforeAnbaobu {
	 private List<Integer> listyear;
		private String status;
		private int ifkaiqi;
	public List<Integer> getListyear() {
			return listyear;
		}
		public void setListyear(List<Integer> listyear) {
			this.listyear = listyear;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	public int getIfkaiqi() {
			return ifkaiqi;
		}
		public void setIfkaiqi(int ifkaiqi) {
			this.ifkaiqi = ifkaiqi;
		}
	public String execute() throws Exception
	{
		DateTimeUtil dtu = new DateTimeUtil();
		ScoreFlagDAO sfdao = new ScoreFlagDAO();
		listyear = dtu.getLastJYears(2);
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
		try {
			
			ScoreFlag sf = sfdao.findByIsNew(1);
			if(sf==null)
    		{
    			status = "未开启任何年度评分";
    			ifkaiqi=0;
    		}
    		else
    		{
    			ifkaiqi=1;
    			if(sf.getFlag()==0)
    			{
    				status = sf.getYear()+"年，初始化状态，请开启评分！";
    			}
    			else if(sf.getFlag()==1)
    			{
    				status = sf.getYear()+"年，评分进行中！";
    			}
    			else if(sf.getFlag()==2)
    			{
    				status = sf.getYear()+"年，评分已提交！";
    			}
    		}
		}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
}
