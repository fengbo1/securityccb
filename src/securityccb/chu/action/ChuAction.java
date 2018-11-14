package securityccb.chu.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;

import securityccb.chu.pojo.Chu;


import ccb.hibernate.HibernateSessionFactory;

public class ChuAction {
	private static final Log log = LogFactory.getLog(ChuAction.class);
	private String jigou;
	private String jigouid;
	private List<ChuAction> mylist;
	private String position;
	private String chushiid;
	private String message;

	
	
	private String chushi;


	public void setJigou(String jigou) {
		this.jigou = jigou;
	}
	public String getJigou() {
		return jigou;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setChushi(String chushi) {
		this.chushi = chushi;
	}
	public String getChushi() {
		return chushi;
	}

	public List<ChuAction> getMylist() {
		return mylist;
	}
	public void setMylist(List<ChuAction> mylist) {
		this.mylist = mylist;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{

		List list = new ArrayList<Chu>();
		JiGouDAO jgd=new JiGouDAO();
		Query query;
		String sql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		mylist=new ArrayList<ChuAction>();	
		
		
		
		try {
		
			sql="SELECT * from chu where jigouid = "+"'"+position.substring(0, 3)+"'";	
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(Chu.class);	


			list = query.list();			
			ActionContext.getContext().getSession().put("position",position);			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		if(list != null && list.size() >= 1){
			
			for (int i=0;i<list.size();i++){

				Chu chu = (Chu) list.get(i);
				ChuAction chushi = new ChuAction();			
				
				chushi.setChushi(chu.getChushi());
				chushi.setJigou(jgd.findjigoubyjigouid(chu.getJigouid()));
				chushi.setChushiid(chu.getChushiid());
				chushi.setPosition(position);
				mylist.add(chushi);
				
			}
			
		}

		return "find_all_success";
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}


	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	public String getChushiid() {
		return chushiid;
	}
	public void setChushiid(String chushiid) {
		this.chushiid = chushiid;
	}
	
}
