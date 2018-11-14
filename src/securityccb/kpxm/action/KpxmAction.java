package securityccb.kpxm.action;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import securityccb.area.pojo.Area;
import securityccb.chu.action.ChuAction;
import securityccb.chu.pojo.Chu;
import securityccb.config.dao.ScoreFlagDAO;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.process.action.FindNextUnder;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;
import securityccb.score.pojo.ScoreBean;
import securityccb.userinfo.action.UserInfoFind;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.DateTimeUtil;


import ccb.hibernate.HibernateSessionFactory;

public class KpxmAction {
	private static final Log log = LogFactory.getLog(KpxmAction.class);
	private List<ScoreBean> listsb;
	private String newnumber;
	private String jigouid;	
	private String position;	
	private String year;
	private List<UserInfo> list;
	private double sumscore;
	private String ifcanpingfen;
	private String jigouc;//机构中文
	private String pnumber;
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public List<ScoreBean> getListsb() {
		return listsb;
	}
	public void setListsb(List<ScoreBean> listsb) {
		this.listsb = listsb;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public double getSumscore() {
		return sumscore;
	}
	public void setSumscore(double sumscore) {
		this.sumscore = sumscore;
	}
	public String getIfcanpingfen() {
		return ifcanpingfen;
	}
	public void setIfcanpingfen(String ifcanpingfen) {
		this.ifcanpingfen = ifcanpingfen;
	}
	public String getJigouc() {
		return jigouc;
	}
	public void setJigouc(String jigouc) {
		this.jigouc = jigouc;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		sumscore = 0.0;
		JiGouDAO jgdao = new JiGouDAO();
		KhpsDAO kpdao = new KhpsDAO();
		FindNextUnder fnu=new FindNextUnder();
		ScoreFlagDAO sfdao = new ScoreFlagDAO();
		KpxmDAO kdao = new KpxmDAO();
		ScoreDAO sdao = new ScoreDAO();
		year=sfdao.findByIsNew(1).getYear();
		String zhufenzx = "2";
        jigouid=position.substring(0,3);//查询一下考评项目及下一级审批人返回到页面
        listsb = new ArrayList<ScoreBean>();
        List<Score> lists = sdao.findAllByJgAndYear(jigouid, year);	
		if(lists.isEmpty())//还未chushihu评分
		{
			int m=0;//发现新item时的i位置
			int n=1;//相同item的个数
			int bj=0;//表格背景
			int xuhao=0;//大项序号
			double tempscore = 0.0;
			String temp="";//temp item内容
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();
			try {
				List<Kpxm> listk = kdao.findAllOrder();
				for(int i=0;i<listk.size();i++)
				{
					Kpxm kp = listk.get(i);
					ScoreBean sb = new ScoreBean();
					sb.setItemc(kp.getRemark2());
					sb.setItem(kp.getKhxm());
					sb.setCont(kp.getKhnr());
					sb.setStd(kp.getPfbz());
					sb.setRmk(kp.getRemark());
					sb.setQudao(kp.getPfqd());
					sb.setStdscore(kp.getStdscore());
					sb.setRowsp(1);
					if(kp.getPfqd().contains("系统"))
					{
						sb.setQudaoe(1);
					}
					else
					{
						sb.setQudaoe(2);
					}
					listsb.add(sb);
					if(temp.equals(sb.getItem()))//如果当前item与上一个相同
					{
						n+=1;
						listsb.get(i).setRowsp(0);
					}
					else//如果不同
					{
						listsb.get(m).setRowsp(n);
						if(bj==1)
						{
							bj=0;
						}
						else
						{
							bj=1;
						}
						xuhao+=1;
						m=i;
						n=1;
					}
					listsb.get(i).setBeijing(bj);
					listsb.get(i).setXuhao(xuhao);
					temp = kp.getKhxm();
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
			return "chushihua";
		}
		else//如果已经进行了本机构初始化评分
		{
			int m=0;//发现新item时的i位置
			int n=1;//相同item的个数
			int bj=0;//表格背景
			int xuhao=0;//大项序号
			int xzs=0;//选了多少个
			int j=0;//实际真实的序号
			double tempscore = 0.0;
			String temp="";//temp item内容
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();
			try {
				JiGou jg;
				List listjg = jgdao.findByJigouid(jigouid);
				if(!listjg.isEmpty())
				{
					jg = (JiGou) listjg.get(0);
					jigouc = jg.getJigou();
					zhufenzx = jg.getQuanxian();
				}
				sumscore = sdao.findSumByYearAndJigou(jigouid, year,"score");
				for(int i=0;i<lists.size();i++)
				{
					Score s = lists.get(i);
					
					ScoreBean sb = new ScoreBean();
					Kpxm kp = kdao.findByItemAndNum(s.getItem(), s.getNum());
					sb.setId(s.getId());
					sb.setIndx(i);
					sb.setItemc(kp.getRemark2());
					sb.setItem(s.getItem());
					sb.setCont(kp.getKhnr());
					sb.setStd(kp.getPfbz());
					sb.setRmk(kp.getRemark());
					sb.setQudao(kp.getPfqd());
					sb.setScore(s.getScore());
					sb.setStdscore(s.getStdscore());
					sb.setIfxz(s.getIfxz());
					sb.setIfpinfen(1);
					sb.setXzreason(s.getXzreason());
					sb.setRowsp(1);
					if(kp.getPfqd().contains("系统"))
					{
						sb.setQudaoe(1);
					}
					else
					{
						sb.setQudaoe(2);
					}
					listsb.add(sb);
					if(temp.equals(sb.getItem()))//如果当前item与上一个相同
					{
						n+=1;
						xzs+=s.getIfxz();
						listsb.get(j).setRowsp(0);
						listsb.get(j).setScore(0);
						tempscore+=s.getScore();
					}
					else//如果不同
					{
						
						listsb.get(m).setIfpinfen(xzs);
						listsb.get(m).setRowsp(n);
						listsb.get(m).setScore(tempscore);
						if(bj==1)
						{
							bj=0;
						}
						else
						{
							bj=1;
						}
						xuhao+=1;
						
						m=j;
						n=1;
						xzs = s.getIfxz();
						tempscore = s.getScore();
					}
					listsb.get(j).setBeijing(bj);
					listsb.get(j).setXuhao(xuhao);
					temp = s.getItem();
					
					if(s.getIfxz()==0)//如果未选择，显示理由
					{
						ScoreBean sbxz = new ScoreBean();
						sbxz.setCont("不参与考核理由："+s.getXzreason());
						sbxz.setRowsp(0);
						sbxz.setIfxz(0);
						sbxz.setId(s.getId());
						sbxz.setItemc("reason");
						listsb.add(sbxz);
						n+=1;
						j+=1;
					}
					j+=1;
				}
				list=fnu.findNextUnder(zhufenzx,"");				
				
				Khps kp = kpdao.findByJgidAndYear(jigouid, year);
				if(kp==null)
				{
					ifcanpingfen="yes";
					pnumber = "wu";
				}
				else
				{
					pnumber = kp.getPnumber();
					if(kp.getStatus().equals("2"))
					{
						ifcanpingfen="tui";
					}
					else
					{
						ifcanpingfen="no";
					}
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
			sdao.updateScoreToTemp("kong", year, jigouid);
			return "success";
		}
		
	}
	
	
		public List<Kpxm> findkpxm() //通过机构ID查询所辖处室id
	    {
			Query query ;			
			Session session = HibernateSessionFactory.getSession();
			Transaction trans = session.beginTransaction();		
			List<Kpxm> kpxmlist = null;
			try {

		        String sql="SELECT * from kpxm";			
				System.out.println(sql);
				query  = session.createSQLQuery(sql).addEntity(Kpxm.class);		
				kpxmlist = query.list();						
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				trans.commit();
				session.flush();
				session.clear();
				session.close();
			}
				
		return kpxmlist;
		
	}

	
	
}
