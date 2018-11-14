package securityccb.jgxq.action;


import java.util.List;

import securityccb.gzjh.dao.GzjhDAO;
import securityccb.gzjh.pojo.Gzjh;
import securityccb.jgxq.dao.JgxqDAO;
import securityccb.jgxq.pojo.Jgxq;
import securityccb.ndzj.dao.NdzjDAO;
import securityccb.ndzj.pojo.Ndzj;
import securityccb.operate.pojo.Operate;
import securityccb.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import ccb.hibernate.HibernateSessionFactory;
//当前待评审事项
public class ShowJgxq {

	 private Jgxq jgxq;
	 private String type;
	 private List<Ndzj> zjlist;	
	 private List<Gzjh> jhlist;	
	 private String jigouid;
	
	 public void setJgxq(Jgxq jgxq) {
			this.jgxq = jgxq;
		}


		public Jgxq getJgxq() {
			return jgxq;
		}


		public void setZjlist(List<Ndzj> zjlist) {
			this.zjlist = zjlist;
		}


		public List<Ndzj> getZjlist() {
			return zjlist;
		}


		public void setJhlist(List<Gzjh> jhlist) {
			this.jhlist = jhlist;
		}


		public List<Gzjh> getJhlist() {
			return jhlist;
		}
		public void setJigouid(String jigouid) {
			this.jigouid = jigouid;
		}


		public String getJigouid() {
			return jigouid;
		}
		
	public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


	//查询机构详情
	public String execute() throws Exception
	{
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    JgxqDAO xqdao=new JgxqDAO();
	    NdzjDAO zjdao=new NdzjDAO();
	    GzjhDAO jhdao=new GzjhDAO();
	    
	    if(!zjdao.findByJigouid(jigouid).isEmpty())
	    	zjlist=((List<Ndzj>)zjdao.findByJigouid(jigouid));
	    if(!xqdao.findByJigouid(jigouid).isEmpty())
	       jgxq=((Jgxq)xqdao.findByJigouid(jigouid).get(0));
	    if(!jhdao.findByJigouid(jigouid).isEmpty())
	       jhlist=((List<Gzjh>)jhdao.findByJigouid(jigouid));
	    
 	    trans.commit(); 
		session.flush();
		session.clear();
		session.close();
		
		if(type.equals("xiugai"))
		{
			return "success";
		}
		else
		{
			return "chaxun";
		}
		
	}

}
