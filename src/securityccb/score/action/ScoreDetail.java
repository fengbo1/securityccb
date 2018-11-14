package securityccb.score.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.record.dao.RecordDAO;
import securityccb.record.pojo.Record;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;
import securityccb.score.pojo.ScoreBean;

import ccb.hibernate.HibernateSessionFactory;

public class ScoreDetail {

	private String pnumber;
	private String year;
	private String rater;
	private String item;
	private String jigouid;
	private int xiugaibz;
	private int chaxunbz;
	private int lasttime;
	private List<ScoreBean> listsb;
	private String itemc;
	private String remark;
	private List<Record> listr;
	private String daohang;
	private String ifberen;//1本人,0其他
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
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRater() {
		return rater;
	}
	public void setRater(String rater) {
		this.rater = rater;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public List<ScoreBean> getListsb() {
		return listsb;
	}
	public void setListsb(List<ScoreBean> listsb) {
		this.listsb = listsb;
	}
	public String getJigouid() {
		return jigouid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	
	public String getItemc() {
		return itemc;
	}
	public void setItemc(String itemc) {
		this.itemc = itemc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<Record> getListr() {
		return listr;
	}
	public void setListr(List<Record> listr) {
		this.listr = listr;
	}
	public String getDaohang() {
		return daohang;
	}
	public void setDaohang(String daohang) {
		this.daohang = daohang;
	}
	
	public String getIfberen() {
		return ifberen;
	}
	public void setIfberen(String ifberen) {
		this.ifberen = ifberen;
	}
	public String execute() throws Exception
	{
		remark = "";
		daohang = "";
		ifberen = "1";
		KpxmDAO kdao = new KpxmDAO();
		List<Score> lists = null;
		KhpsDAO khdao = new KhpsDAO();
		RecordDAO rdao = new RecordDAO();
		ScoreDAO sdao = new ScoreDAO();
		listsb = new ArrayList<ScoreBean>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			if(pnumber.equals("kong"))
			{
				lists = sdao.findAllByJgAndYearAndItem(jigouid, year, item);
				daohang = "考核管理->年度自评->项目自评";
				
			}
			else
			{
				lists = sdao.findAllByPnumberAndItem(pnumber, item);
				daohang = "考核管理->考核流转->考核项目";
				Khps k = khdao.findAllByPnumber(pnumber);
				if(k!=null)
				{
					if(!k.getInitiator().equals(rater))
					{
						ifberen = "0";
					}
				}
			}
			
			for(int i=0;i<lists.size();i++)
			{
				Score s = lists.get(i);
				ScoreBean sb = new ScoreBean();
				Kpxm kp = kdao.findByItemAndNum(s.getItem(), s.getNum());
				if(s.getRemarktemp().length()>0)
				{
					remark = s.getRemarktemp();
				}
				sb.setId(s.getId());
				sb.setIndx0(i);
				sb.setIndx(s.getIndx()-1);
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
				sb.setRowsp(1);
				if(kp.getPfqd().contains("系统"))
				{
					sb.setQudaoe(1);
				}
				else if(kp.getRemark2().contains("奖励"))
				{
					sb.setQudaoe(2);
				}
				else if(kp.getRemark2().contains("惩罚"))
				{
					sb.setQudaoe(3);
				}
				else if(kp.getRemark2().contains("一票"))
				{
					sb.setQudaoe(4);
				}
				else//自评分
				{
					sb.setQudaoe(0);
				}
				if(s.getIfabb()!=null&&(s.getIfabb()==1))
				{
					sb.setBeijing(2);
				}
				listsb.add(sb);
				itemc = kp.getRemark2();
				
				if(s.getIfxz()==0)//如果未选择，显示理由
				{
					ScoreBean sbxz = new ScoreBean();
					sbxz.setCont("不参与考核理由："+s.getXzreason());
					sbxz.setRowsp(0);
					sbxz.setIfxz(0);
					sbxz.setId(s.getId());
					sbxz.setItemc("reason");
					listsb.add(sbxz);
				}
			}
			listr = rdao.findAllByJiGouYearItem(jigouid, year, item);
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
		return "success";
	}
		
}
