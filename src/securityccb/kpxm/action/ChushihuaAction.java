package securityccb.kpxm.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.config.dao.ScoreFlagDAO;
import securityccb.config.pojo.ScoreFlag;
import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.record.action.WriteAction;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;

import ccb.hibernate.HibernateSessionFactory;

public class ChushihuaAction {

	private String jigouid;
	private String[] reason;
	private String rd1;
	private String rd2;
	private String rd3;
	private String rd4;
	private String rd5;
	private String rd6;
	private String rd7;
	private String rd8;
	private String rd9;
	private String rd10;
	private String rd11;
	private String rd12;
	private String rd13;
	private String rd14;
	private String rd15;
	private String rd16;
	private String rd17;
	private String rd18;
	private String rd19;
	private String rd20;
	private String rd21;
	private String rd22;
	private String rd23;
	private String rd24;
	private String rd25;
	private String rd26;
	private String rd27;
	private String rd28;
	private String rd29;
	private String rd30;
	private String rd31;
	private String rd32;
	private String rd33;
	private String rd34;
	private String rd35;
	public String getJigouid() {
		return jigouid;
	}
	public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}
	public String[] getReason() {
		return reason;
	}
	public void setReason(String[] reason) {
		this.reason = reason;
	}
	public String getRd1() {
		return rd1;
	}
	public void setRd1(String rd1) {
		this.rd1 = rd1;
	}
	public String getRd2() {
		return rd2;
	}
	public void setRd2(String rd2) {
		this.rd2 = rd2;
	}
	public String getRd3() {
		return rd3;
	}
	public void setRd3(String rd3) {
		this.rd3 = rd3;
	}
	public String getRd4() {
		return rd4;
	}
	public void setRd4(String rd4) {
		this.rd4 = rd4;
	}
	public String getRd5() {
		return rd5;
	}
	public void setRd5(String rd5) {
		this.rd5 = rd5;
	}
	public String getRd6() {
		return rd6;
	}
	public void setRd6(String rd6) {
		this.rd6 = rd6;
	}
	public String getRd7() {
		return rd7;
	}
	public void setRd7(String rd7) {
		this.rd7 = rd7;
	}
	public String getRd8() {
		return rd8;
	}
	public void setRd8(String rd8) {
		this.rd8 = rd8;
	}
	public String getRd9() {
		return rd9;
	}
	public void setRd9(String rd9) {
		this.rd9 = rd9;
	}
	public String getRd10() {
		return rd10;
	}
	public void setRd10(String rd10) {
		this.rd10 = rd10;
	}
	public String getRd11() {
		return rd11;
	}
	public void setRd11(String rd11) {
		this.rd11 = rd11;
	}
	public String getRd12() {
		return rd12;
	}
	public void setRd12(String rd12) {
		this.rd12 = rd12;
	}
	public String getRd13() {
		return rd13;
	}
	public void setRd13(String rd13) {
		this.rd13 = rd13;
	}
	public String getRd14() {
		return rd14;
	}
	public void setRd14(String rd14) {
		this.rd14 = rd14;
	}
	public String getRd15() {
		return rd15;
	}
	public void setRd15(String rd15) {
		this.rd15 = rd15;
	}
	public String getRd16() {
		return rd16;
	}
	public void setRd16(String rd16) {
		this.rd16 = rd16;
	}
	public String getRd17() {
		return rd17;
	}
	public void setRd17(String rd17) {
		this.rd17 = rd17;
	}
	public String getRd18() {
		return rd18;
	}
	public void setRd18(String rd18) {
		this.rd18 = rd18;
	}
	public String getRd19() {
		return rd19;
	}
	public void setRd19(String rd19) {
		this.rd19 = rd19;
	}
	public String getRd20() {
		return rd20;
	}
	public void setRd20(String rd20) {
		this.rd20 = rd20;
	}
	public String getRd21() {
		return rd21;
	}
	public void setRd21(String rd21) {
		this.rd21 = rd21;
	}
	public String getRd22() {
		return rd22;
	}
	public void setRd22(String rd22) {
		this.rd22 = rd22;
	}
	public String getRd23() {
		return rd23;
	}
	public void setRd23(String rd23) {
		this.rd23 = rd23;
	}
	public String getRd24() {
		return rd24;
	}
	public void setRd24(String rd24) {
		this.rd24 = rd24;
	}
	public String getRd25() {
		return rd25;
	}
	public void setRd25(String rd25) {
		this.rd25 = rd25;
	}
	public String getRd26() {
		return rd26;
	}
	public void setRd26(String rd26) {
		this.rd26 = rd26;
	}
	public String getRd27() {
		return rd27;
	}
	public void setRd27(String rd27) {
		this.rd27 = rd27;
	}
	public String getRd28() {
		return rd28;
	}
	public void setRd28(String rd28) {
		this.rd28 = rd28;
	}
	public String getRd29() {
		return rd29;
	}
	public void setRd29(String rd29) {
		this.rd29 = rd29;
	}
	public String getRd30() {
		return rd30;
	}
	public void setRd30(String rd30) {
		this.rd30 = rd30;
	}
	public String getRd31() {
		return rd31;
	}
	public void setRd31(String rd31) {
		this.rd31 = rd31;
	}
	public String getRd32() {
		return rd32;
	}
	public void setRd32(String rd32) {
		this.rd32 = rd32;
	}
	public String getRd33() {
		return rd33;
	}
	public void setRd33(String rd33) {
		this.rd33 = rd33;
	}
	public String getRd34() {
		return rd34;
	}
	public void setRd34(String rd34) {
		this.rd34 = rd34;
	}
	public String getRd35() {
		return rd35;
	}
	public void setRd35(String rd35) {
		this.rd35 = rd35;
	}
	public String execute() throws Exception
	{
		String sql = "";
		double sum_xz_score = 0.0;//总分
		String indx = "";//选择yes的序号
		double sum_all = 0.0;//
		int j = 0;
		int h = 0;
		KpxmDAO kdao = new KpxmDAO();
		ScoreDAO sdao = new ScoreDAO();
		WriteAction wa = new WriteAction();
		ScoreFlagDAO sfdao = new ScoreFlagDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			String choose = rd1+rd2+rd3+rd4+rd5+rd6+rd7+rd8+rd9+rd10
			+rd11+rd12+rd13+rd14+rd15+rd16+rd17+rd18+rd19+rd20+rd21
			+rd22+rd23+rd24+rd25+rd26+rd27+rd28+rd29+rd30+rd31+rd32+rd33+rd34+rd35;
			List<Kpxm> listk = kdao.findAllOrder();
			ScoreFlag sf = sfdao.findByIsNew(1);
			if(sf!=null)
			{
				sql = "delete from score where year='"+sf.getYear()+"' and jigouid='"+jigouid+"'";
				session.createSQLQuery(sql).executeUpdate();
				for(int i=0;i<listk.size();i++)
		    	{
		    		Kpxm k = listk.get(i);
		    		Score score = new Score();
		    		score.setYear(sf.getYear());
		    		score.setPnumber("");
		    		score.setJigouid(jigouid);
		    		score.setItem(k.getKhxm());
		    		score.setNum(k.getNum());
		    		score.setIndx(i+1);
		    		score.setScore(0.0);
		    		score.setRemark("");
		    		score.setRemarktemp("");
		    		score.setIfabb(0);
		    		score.setSub("");
		    		score.setNewnumber("");
		    		score.setIfxz(1);
		    		score.setYuanscore(k.getStdscore());
		    		score.setStdscore(k.getStdscore());
		    		score.setXzreason("");
		    		
		    		if(i<choose.length())//选择项
		    		{
		    			if(choose.charAt(i)=='y')//选中
			    		{
			    			score.setIfxz(1);
			    			sum_xz_score+=k.getStdscore();
			    			h=i+1;
			    			indx+=h;
			    			indx+=",";
			    		}
			    		else//未选中
			    		{
			    			score.setIfxz(0);
			    			score.setXzreason(reason[j]);
			    			score.setStdscore(0.0);
			    			j++;
			    		}
		    			sum_all+=k.getStdscore();
		    		}
		    		sdao.merge(score);
		    	}
				if(indx.length()>0)
				{
					indx = indx.substring(0, indx.length()-1);
				}//
				sql = "update score set sub=CAST("+sum_all+"/"+sum_xz_score+" AS DECIMAL(18,4)) where jigouid='"+jigouid+"' and year='"+sf.getYear()+"'";
				session.createSQLQuery(sql).executeUpdate();
				wa.update_syssum_score_alljigou(sf.getYear(),session);
				sql = "update score set stdscore=CAST(stdscore*"+sum_all+"/"+sum_xz_score+" AS DECIMAL(18,1)),score=CAST(score*"+sum_all+"/"+sum_xz_score+" AS DECIMAL(18,1))" +
						" where year='"+sf.getYear()+"' and jigouid='"+jigouid+"' and item not in('jljf','ndaqgz','cfkf','ypfj')";
				session.createSQLQuery(sql).executeUpdate();
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
		return "success";
	}
}
