package securityccb.userinfo.action;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private int id;
	private String position;
	private String name;
	private String newnumber;
	private String password;
	private String role;
	private String quanxian;
	private String remark1;
	private Session h_session;
    private Transaction trans;
    private String hql;
    private Query query;
    
   
    
    private int errNum = 0;
    private int restNum;
    Timestamp d = new Timestamp(System.currentTimeMillis());
    public void setPosition(String position) {
		this.position = position;
	}


	public String getPosition() {
		return position;
	}
	
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Session getSession() {
		return h_session;
	}


	public void setSession(Session h_session) {
		this.h_session = h_session;
	}


	public Transaction getTrans() {
		return trans;
	}


	public void setTrans(Transaction trans) {
		this.trans = trans;
	}


	public String getHql() {
		return hql;
	}


	public void setHql(String hql) {
		this.hql = hql;
	}


	public Query getQuery() {
		return query;
	}


	public void setQuery(Query query) {
		this.query = query;
	}
     public void setServletResponse(HttpServletResponse response)
       {
       }

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}


	public String getRemark1() {
		return remark1;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}


	public String getQuanxian() {
		return quanxian;
	}
	


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		
		
	/*固定写法*/
		  h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		  System.out.println("newnumber:"+newnumber);
 		  System.out.println("password:"+password);
 		 
		  try {
			  
			  hql="select user from UserInfo as user where user.newnumber=:no";
			  query=h_session.createQuery(hql);
			  query.setString("no",newnumber);//设置查询参数
			//  query.setString("p",password);//设置查询参数

			  List l=query.list();
			 
			  if((l==null)||(l.size()<=0))
			  {
				  this.addFieldError("用户","用户不存在!");
				  return "false";
			  }
			  else 
			  {   
				  UserInfo u=(UserInfo)(l.get(0));
				  id=u.getId();
				  position=u.getPosition();
				  role=u.getRole();
				  name=u.getName();
				  password = this.getPassword();
				 System.out.print("DBpwd:"+u.getPassword());
				
				  if(!password.equals(u.getPassword()))
				  {
										  
					  this.addFieldError("用户","密码有误");
					  	 return "false";					
				  }
				  System.out.println("time1"+d);				
				  ActionContext.getContext().getSession().put("position",u.getPosition());			
				  ActionContext.getContext().getSession().put("remark1",u.getRemark1());
				  ActionContext.getContext().getSession().put("id",id);
				  ActionContext.getContext().getSession().put("role",role);		
				  ActionContext.getContext().getSession().put("islogin", "1");	  	
				  ActionContext.getContext().getSession().put("name", u.getName());	
				  ActionContext.getContext().getSession().put("newnumber", newnumber);	
				  ActionContext.getContext().getSession().put("quanxian", u.getQuanxian());	
				  ActionContext.getContext().getSession().put("password", u.getPassword());	
				  ActionContext.getContext().getSession().put("jigouid", u.getPosition().substring(0, 3));
				 if (position.substring(0, 3).equals("000"))
				 {
					 return "anbaobu";
				 				
				 }
			  }
			  
			  
			  
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
 				trans.commit();
				h_session.flush();
				h_session.clear();
				h_session.close();				
		}
		return "success";
		 
		
	}


	
}
