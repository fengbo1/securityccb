package securityccb.jigou.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.jigou.pojo.JiGouBean;
import ccb.hibernate.HibernateSessionFactory;

public class JigouList {

	private List<JiGouBean> list;
	public List<JiGouBean> getList() {
		return list;
	}
	public void setList(List<JiGouBean> list) {
		this.list = list;
	}
	public String execute() throws Exception 
    {
		Query query ;
		JiGouDAO jgdao = new JiGouDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		list = new ArrayList<JiGouBean>();
		try {
	        String sql="from JiGou where jigouid!='000'";			
			query  = session.createQuery(sql);		
			List<JiGou> jigoulist = query.list();		
			for(int i=0;i<jigoulist.size();i++)
			{
				JiGou jg = jigoulist.get(i);
				JiGouBean jgb = new JiGouBean();
				jgb.setId(jg.getId());
				jgb.setJigou(jg.getJigou());
				jgb.setJigouid(jg.getJigouid());
				String sj = jgdao.findJigouNameByJigouid(jg.getRemark1());
				jgb.setShangji(sj);
				String xj = "";
				if(jg.getRemark2()!=null)
				{
					String[] xjs = jg.getRemark2().split(".");
					for(int j=0;j<xjs.length;j++)
					{
						String tp = xjs[j];
						xj+=jgdao.findJigouNameByJigouid(tp);
						xj+="、";
					}
					if(xj.length()>0)
					{
						xj = xj.substring(0, xj.lastIndexOf("、"));
					}
					jgb.setXiaji(xj);
				}
				list.add(jgb);
			}
			
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
