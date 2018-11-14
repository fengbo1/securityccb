package securityccb.jigou.action;

import java.util.List;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;

import com.opensymphony.xwork2.ActionContext;

public class AnbaobuToJigou {

	private String jigouid;
	private String position;
	private String jigouc;

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
	public String getJigouc() {
		return jigouc;
	}
	public void setJigouc(String jigouc) {
		this.jigouc = jigouc;
	}
	public String execute() throws Exception
	{
		JiGouDAO jgdao = new JiGouDAO();
		if(jigouid.equals("000"))
		{
			return "benji";
		}
		else
		{
			   position = jigouid+position.substring(3, 11);	
			
			  ActionContext.getContext().getSession().put("position",position);			
			  List list = jgdao.findByJigouid(jigouid);
			  if(!list.isEmpty())
			  {
				  JiGou jg = (JiGou) list.get(0);
				  jigouc = jg.getJigou();
			  }
			
			
			return "success";
		}	
		
	}
}
