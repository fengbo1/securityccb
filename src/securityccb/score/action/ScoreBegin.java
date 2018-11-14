package securityccb.score.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.config.dao.ScoreFlagDAO;
import securityccb.config.pojo.ScoreFlag;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.record.action.WriteAction;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;
import ccb.hibernate.HibernateSessionFactory;

public class ScoreBegin {
	private String year;
	private String message;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		WriteAction wa = new WriteAction();
		String result = "success";
		String sql = "";
		ScoreFlagDAO sfdao = new ScoreFlagDAO();
		List<ScoreFlag> list1;
		
		
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		
    		list1 = sfdao.findByStatus("1");
    		if(year==null)
    		{
    			message = "失败！请选择正确的年和季度！";
    		}
    		else
    		{
    			ScoreFlag sf = sfdao.findByYear(year);
    			if(sf==null)//开始新一季度打分 
    			{
    				sql = "update scoreflag set isnew=0,flag=0";//所有最新标志位置0；
    				session.createSQLQuery(sql).executeUpdate();
    				sql = "delete from score where year='"+year+"'";//所有最新标志位置0；
    				session.createSQLQuery(sql).executeUpdate();
    				//添加初始化的方法(各个机构处室化时生成)
    				//initAllRate(session,year);
    				sf = new ScoreFlag();
    				sf.setYear(year);
    				sf.setIsnew(1);
    				sf.setFlag(1);
    				sfdao.merge(sf);
    			}
    			else
    			{
    				sql = "update scoreflag set isnew=0,flag=0";//所有最新标志位置0；
    				session.createSQLQuery(sql).executeUpdate();
					sf.setFlag(1);
					sf.setIsnew(1);
					sfdao.merge(sf);
    			}
    			message = "成功！已开启"+sf.getYear()+"年打分！";
    		}
    		wa.update_syssum_score_alljigou(year,session);
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return result;
	}
	
	/**
	 * 初始化所有打分数据
	 * @param session
	 * @param year
	 * @param season
	 * @return
	 */
	public String initAllRate(Session session,String year)
	{
		ScoreDAO sdao = new ScoreDAO();
		JiGouDAO jgdao = new JiGouDAO();
		KpxmDAO kdao = new KpxmDAO();
		List<JiGou> listjg = jgdao.findAllPinfenJigou();
		List<Kpxm> listk = kdao.findAllOrder();
		for(int i=0;i<listjg.size();i++)
		{
			JiGou jg = listjg.get(i);
			for(int j=0;j<listk.size();j++)
			{
				Kpxm k = listk.get(j);
				Score score = new Score();
				score.setYear(year);
				score.setPnumber("");
				score.setJigouid(jg.getJigouid());
				score.setItem(k.getKhxm());
				score.setNum(k.getNum());
				score.setScore(0.0);
				score.setRemark("");
				score.setRemarktemp("");
				score.setSub("");
				score.setNewnumber("");
				sdao.merge(score);
			}
		}
		return "";
	}
}
