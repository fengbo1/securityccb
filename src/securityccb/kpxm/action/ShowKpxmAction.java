package securityccb.kpxm.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import securityccb.kpxm.dao.KpxmDAO;
import securityccb.kpxm.pojo.Kpxm;
import securityccb.score.dao.ScoreDAO;
import securityccb.score.pojo.Score;
import securityccb.score.pojo.ScoreBean;

public class ShowKpxmAction {

	private List<ScoreBean> listsb;

	public List<ScoreBean> getListsb() {
		return listsb;
	}

	public void setListsb(List<ScoreBean> listsb) {
		this.listsb = listsb;
	}
	public String execute() throws Exception
	{
		KpxmDAO kdao = new KpxmDAO();
		listsb = new ArrayList<ScoreBean>();
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
		return "success";
	}
}
