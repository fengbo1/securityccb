package securityccb.score.action;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
import securityccb.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class SubItemScore {

	private String year;
	private String item;
	private String pnumber;
	private String newnumber;
	private String jigouid;
	private int xiugaibz;
	private int chaxunbz;
	private int lasttime;
	private List<ScoreBean> listsb;
	private List<UserInfo> list;
	private double[] scores;
	private int[] scoreids;
	private double sumscore;
	private String para;
	private String remark;
	private String jigouc;
	private String thisunder;
	
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getThisunder() {
		return thisunder;
	}
	public void setXiugaibz(int xiugaibz) {
		this.xiugaibz = xiugaibz;
	}
	public int getXiugaibz() {
		return xiugaibz;
	}
	
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
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
	public double[] getScores() {
		return scores;
	}
	public void setScores(double[] scores) {
		this.scores = scores;
	}
	public int[] getScoreids() {
		return scoreids;
	}
	public void setScoreids(int[] scoreids) {
		this.scoreids = scoreids;
	}
	
	public double getSumscore() {
		return sumscore;
	}
	public void setSumscore(double sumscore) {
		this.sumscore = sumscore;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getJigouc() {
		return jigouc;
	}
	public void setJigouc(String jigouc) {
		this.jigouc = jigouc;
	}
	public String execute() throws Exception
	{
		int flag = 0;
		KhpsDAO khdao = new KhpsDAO();
		List<Score> lists = null;
		JiGouDAO jgdao = new JiGouDAO();
		FindNextUnder fnu=new FindNextUnder();
		KpxmDAO kdao = new KpxmDAO();
		ScoreDAO sdao = new ScoreDAO();
		Score sypfj = null;
		String abbchange = "";
		int benrenflag = 0;
		 listsb = new ArrayList<ScoreBean>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			Khps kh = khdao.findAllByPnumber(pnumber);
			if(!pnumber.equals("kong"))
			{
				sypfj = (Score) sdao.findAllByPnumberAndItem(pnumber, "ypfj").get(0);
				List listjg = jgdao.findByJigouid(kh.getJigouid());
				JiGou jg = (JiGou) listjg.get(0);
				jigouc = jg.getJigou();
				
				if(kh.getInitiator().equals(newnumber))
				{
					benrenflag = 1;
				}
				else
				{
					benrenflag = 0;
				}
			}
			else
			{
				benrenflag = 1;//本人操作
				sypfj = (Score) sdao.findAllByJgidAndYearAndItem(jigouid,year, "ypfj").get(0);
				List listjg = jgdao.findByJigouid(jigouid);
				JiGou jg = (JiGou) listjg.get(0);
				jigouc = jg.getJigou();
			}
			
			if(para.equals("ypfj"))
			{
				sypfj.setScoretemp(1.0);
				sypfj.setRemarktemp(remark);
			}
			else if(para.equals("qxypfj"))
			{
				sypfj.setScoretemp(0.0);
				sypfj.setRemarktemp(remark);
			}
			else
			{
				for(int i=0;i<scores.length;i++)
				{
					Score sp = sdao.findAllById(scoreids[i]);
					if(sp!=null)
					{
						if(sp.getItem().equals("cfkf"))
						{
							sp.setScoretemp(scores[i]*(-1));
						}
						else
						{
							sp.setScoretemp(scores[i]);
						}
						abbchange+=sp.getItem();
						abbchange+="、";
						sp.setRemarktemp(remark);
						sdao.merge(sp);
					}
				}
			}
			
			if(pnumber.equals("kong"))
			{
				lists = sdao.findAllByJgAndYear(jigouid, year);	
				list=fnu.findNextUnder("2","");	
				String sql = "update score set score=scoretemp where year='"+year+"' and jigouid='"+jigouid+"'";
				session.createSQLQuery(sql).executeUpdate();
				sumscore = sdao.findSumByYearAndJigou(jigouid, year,"scoretemp");
			}
			else
			{
				lists = sdao.findAllByPnumber(pnumber);	
				list=fnu.findNextUnder(String.valueOf(kh.getItem()),pnumber);	
				sumscore = sdao.findSumByPnumber(pnumber,"scoretemp");
			}
			
			int m=0;//发现新item时的i位置
			int n=1;//相同item的个数
			int bj=0;//表格背景
			int xuhao=0;//大项序号
			int xzs=0;//选了多少个
			int j=0;//实际真实的序号
			double tempscore = 0.0;
			String temp="";//temp item内容
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
				sb.setScore(s.getScoretemp());
				sb.setStdscore(s.getStdscore());
				sb.setIfxz(s.getIfxz());
				sb.setIfpinfen(1);
				sb.setXzreason(s.getXzreason());
				if(s.getScoretemp()==1&&s.getItem().equals("ypfj"))
				{
					flag=1;
				}
			
				sb.setRowsp(1);
				listsb.add(sb);
				
				if(temp.equals(sb.getItem()))//如果当前item与上一个相同
				{
					n+=1;
					xzs+=s.getIfxz();
					listsb.get(j).setRowsp(0);
					listsb.get(j).setScore(0);
					tempscore+=s.getScoretemp();
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
					tempscore = s.getScoretemp();
				}
				listsb.get(j).setBeijing(bj);
				if(s.getIfabb()!=null&&(s.getIfabb()==1))
				{
					listsb.get(j).setBeijing2(1);
				}
				if(benrenflag==0&&((s.getScoretemp()-s.getScore())>0.0001))
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

				
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		if(pnumber.equals("kong"))
		{
			return "success";
		}
		else
		{
			return "viewscore";
		}
		
	}
	
	
}
