package securityccb.record.action;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.record.dao.RecordDAO;
import securityccb.record.pojo.Record;
import securityccb.score.pojo.Score;

import ccb.hibernate.HibernateSessionFactory;

public class DelRecordUrl {

	private String idd;
	private String url;
	
	public String getIdd() {
		return idd;
	}
	public void setIdd(String idd) {
		this.idd = idd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String execute() throws Exception
	{
		String result = "success";
		String sql = "";
		RecordDAO rdao = new RecordDAO();
		WriteAction wa = new WriteAction();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		Record r = rdao.findAllById(idd);
    		if(url.equals("record"))
    		{
    			SimpleDateFormat yearformat = new SimpleDateFormat("YYYY");
    	        String year=yearformat.format(r.getDate());
    			sql = "delete from record where id="+idd;
    			session.createSQLQuery(sql).executeUpdate();
    			List <Score> slist=wa.syssum(r.getJigouid(),year,session); //获取系统自动统计项目分数，写入数据库
        		for (int i=0;i<slist.size();i++){
        			wa.update_syssum_score(slist.get(i).getJigouid(),slist.get(i).getItem(),slist.get(i).getNum(),slist.get(i).getYear(),slist.get(i).getScore(),session);
        		}
    		}
    		else
    		{
    			sql = "update record set "+url+"='--' where id="+idd;
    			session.createSQLQuery(sql).executeUpdate();
    		}
    		
    		
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
}
