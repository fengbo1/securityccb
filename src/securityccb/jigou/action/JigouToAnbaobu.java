package securityccb.jigou.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class JigouToAnbaobu {

	private String jigouid;
	private String position;
	private List jigoulist;

	public String getJigouid() {
		return jigouid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	public void setJigoulist(List jigoulist) {
		this.jigoulist = jigoulist;
	}
	public List getJigoulist() {
		return jigoulist;
	}
	public String execute() throws Exception
	{
		
			  position = "00"+position.substring(3, 9);	
			
			  ActionContext.getContext().getSession().put("position",position);
			
              ActionContext.getContext().getSession().put("islogin",1);
			  JigouAction ja=new JigouAction();
			  
			  jigoulist=ja.findalljigou();
			  
			  
			
			  return "success";
			
		
	}
}
