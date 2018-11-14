package securityccb.score.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.dao.JiGouDAO;
import securityccb.jigou.pojo.JiGou;
import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.kpxm.action.KpxmAction;
import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.process.action.FindNextUnder;
import securityccb.record.pojo.Record;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;
import securityccb.score.pojo.ScoreBean;
import securityccb.scoreall.pojo.Scoreall;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.DateTimeUtil;
import ccb.hibernate.HibernateSessionFactory;

public class ScoreFind {
	private static final Log log = LogFactory.getLog(ScoreFind.class);
	private String pnumber;
	private int xiugaibz;
    private int lasttime;
    private int chaxunbz;
	private String initiator;
	private List<ScoreBean> listsb;
	private List<UserInfo> list;
	private double sumscore;
	private String jigouc;//机构中文
	private String year;
	private String thisunder;
	
	public void setChaxunbz(int chaxunbz) {
		this.chaxunbz = chaxunbz;
	}
	public int getChaxunbz() {
		return chaxunbz;
	}
	
	 public void setLasttime(int lasttime) {
			this.lasttime = lasttime;
		}
		public int getLasttime() {
			return lasttime;
		}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public int getXiugaibz() {
		return xiugaibz;
	}
	public void setXiugaibz(int xiugaibz) {
		this.xiugaibz = xiugaibz;
	}

	public List<ScoreBean> getListsb() {
		return listsb;
	}
	public void setListsb(List<ScoreBean> listsb) {
		this.listsb = listsb;
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
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public String getJigouc() {
		return jigouc;
	}
	public void setJigouc(String jigouc) {
		this.jigouc = jigouc;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getThisunder() {
		return thisunder;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		jigouc = "";
		FindNextUnder fnu=new FindNextUnder();
		KhpsDAO khdao = new KhpsDAO();
		KpxmDAO kdao = new KpxmDAO();
		ScoreDAO sdao = new ScoreDAO();
		JiGouDAO jgdao = new JiGouDAO();
        listsb = new ArrayList<ScoreBean>();
        List<Score> lists = sdao.findAllByPnumber(pnumber);	
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
			Khps kh = khdao.findAllByPnumber(pnumber);
			year=kh.getRemark3();
			List listjg = jgdao.findByJigouid(kh.getJigouid());
			if(!listjg.isEmpty())
			{
				JiGou jg = (JiGou) listjg.get(0);
				jigouc = jg.getJigou();
			}
			initiator = kh.getInitiator();
			sumscore = sdao.findSumByPnumber(pnumber,"score");
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
					xzs = s.getIfxz();;
					tempscore = s.getScore();
				}
				listsb.get(j).setBeijing(bj);
				if(s.getIfabb()!=null&&(s.getIfabb()==1))
				{
					listsb.get(j).setBeijing2(1);
				}
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
			if(lasttime==1&&chaxunbz==0)
			{
				list=fnu.findNextUnder(String.valueOf(kh.getItem()),pnumber);				
				UserInfo tempu=list.get(0);
				thisunder=tempu.getNewnumber();
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
		sdao.updateScoreToTemp(pnumber, "", "");
		return "success";
	
	}
	
	

	}
	

	