package securityccb.process.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import securityccb.chu.dao.ChuDAO;
import securityccb.chu.pojo.Chu;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.process.dao.ProcessDAO;
import securityccb.process.pojo.Process;
import securityccb.userinfo.action.UserInfoFind;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;

public class FindNextUnder {

	/**
	 * 根据审批表当前状态、进度、当前审批人信息查找下一个审批人
	 * 
	 * @param item
	 *            事项编号
	 * @param number
	 *            审批表标号
	 * @param thisNewnumber
	 *            当前审批人新一代工号
	 * @return
	 */
	
	
	/**
	 *  根据审批表当前状态、进度等信息查找下一个审批人
	 * 
	 * @param item
	 *            事项编号(1主中心 2 分中心)
	 * @param number
	 *            审批表标号
	 */
	public List<UserInfo> findNextUnder(String item,String pnumber)
	{
		
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		UserInfoFind uifind=new UserInfoFind();
		
		Khps kp =new Khps();
		KhpsDAO kpdao=new KhpsDAO();
		
		ProcessDAO pdao=new ProcessDAO();
		Process p = new Process();
		
		JiGouDAO jgdao=new JiGouDAO();
		JiGou jg=new JiGou();
						
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		Chu chu=new Chu();
		ChuDAO chudao=new ChuDAO();
		
		String jigouid;
		String position;
		String role;
		String newnumber;
	    String jigoutype;
	    int jindu;
	    String nextps = null;
		String temp_jg="";
	   //获取流程，item 1  表示主中心，item 2 表示分中心
		
		p=(Process)pdao.findByItem(item).get(0);
		
		List testlist=kpdao.findByPnumber(pnumber);
		newnumber=(String)ActionContext.getContext().getSession().get("newnumber");
		//找到发起人：第一次提交时
		if(testlist.isEmpty())
		{
			
			jindu=0;//初始进度为0
			ui=(UserInfo)uidao.findByNewnumber(newnumber).get(0);//发起人			
		}
		else
		{
			kp=(Khps)kpdao.findByPnumber(pnumber).get(0);
			jindu=Integer.parseInt(kp.getJindu());
			ui=(UserInfo)uidao.findByNewnumber(kp.getInitiator()).get(0);//发起人
		}
		
		
		position=ui.getPosition();
		jigouid=position.substring(0, 3);//发起人机构id
		if(jindu==p.getProcess().length())//最后一个审批人
		{
			
		}	
		else
		{
			role=p.getProcess().substring(jindu, jindu+1);//下一审批人role
			
			jigoutype=p.getApplicant().substring(jindu, jindu+1);//下一审批人中心属性B 本中心  M主中心  A总行安保部
			if(jigoutype.equalsIgnoreCase("B"))
			{
				
				chu=chudao.findZHById(position.substring(0,3));
				nextps=temp_jg+chu.getChushiid().substring(0, 3);	//本机构综合处
				nextps=position;
			}
				
			else if(jigoutype.equalsIgnoreCase("A"))
			{
				UserInfo temp=new UserInfo();
				temp=(UserInfo)uidao.findAnBaobz();
				nextps=temp.getPosition();//总行安保部
			}
				
			else if(jigoutype.equalsIgnoreCase("M" ))
			{
				List<JiGou> temp=new ArrayList();
				temp=jgdao.findByJigouid(jigouid);
				jg=temp.get(0);
				temp_jg=jg.getRemark1().substring(0,3);//主中心机构id
				chu=chudao.findZHById(temp_jg);
				nextps=temp_jg+chu.getChushiid().substring(0, 3);		
				
			}
			list=uidao.findByPostionAndRole(nextps, role);
		}
			
		return list;
	}
	
}
