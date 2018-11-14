package securityccb.zhiban.action;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.zhiban.pojo.ZhiBan;
import ccb.hibernate.HibernateSessionFactory;



public class ZhiBanAreaAjax {
	private static final Log log = LogFactory.getLog(ZhiBanAreaAjax.class);

	private String areaid;
	private String newnumber;	
	private String jieguo;		

	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		
		
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String today=dateFormat.format(now);
		String jieguo1=null;

		Query query;			
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();		
		List<ZhiBan> list = null;
		
		try {
	        String sql="SELECT * from zhiban where date = "+"'"+today+"'";			
			System.out.println(sql);
			query = session.createSQLQuery(sql).addEntity(ZhiBan.class);		
			list = query.list();	
	
		if(null==list){
			jieguo1="0"; //可以进入值班页面
		}
		if(null!=list&&list.size()==2){
			jieguo1="2";  //已经有两个人在此区域值班了，不能进入值班页面
		}
		if(list.size()==1&&list.get(0).getNewnumber()==newnumber){
			jieguo1="3";  //有一个值班，而且还是本人，不能进入值班页面
		}
		if(list.size()==1&&list.get(0).getNewnumber()!=newnumber){
			jieguo1="4"; //有一个值班，不是本人，能进入值班页面
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
		
		
		jieguo=jieguo1;
		
		return "success";		

	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public void setJieguo(String jieguo) {
		this.jieguo = jieguo;
	}

	public String getJieguo() {
		return jieguo;
	}

}
