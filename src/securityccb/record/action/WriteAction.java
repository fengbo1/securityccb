package securityccb.record.action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.jigou.pojo.JiGou;
import securityccb.record.dao.RecordDAO;
import securityccb.record.pojo.Record;
import securityccb.score.pojo.Score;
import securityccb.upfile.Upfile;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.DateTimeUtil;
import securityccb.util.PinyinTool;
import securityccb.util.Util;
import securityccb.util.PinyinTool.Type;
import ccb.hibernate.HibernateSessionFactory;

public class WriteAction {
//	private static final Log log = LogFactory.getLog(WriteAction.class);
	private Date date;
	private String checkboxs;
	private String content1;
	private String people;
	private String remark;
	private String zzld;
	private String gljg;
	private String zrls;
	private String gzzd;
	private String yhpc;
	private String yjya;
	private String barygl;
	private String jfgl;
	private String xfgl;
	private String jtaq;
	private String aqbm;
	private String aqjy;
	private String xxbs;
	private String wwgl;
	private String zdtfsj;
	private String jljf;
	private String position;

	private File file1; //上传的文件
	private File file2; //上传的文件
	private File file3; //上传的文件
	private File file4; //上传的文件
	private File file5; //上传的文件
	private File file6; //上传的文件
	private File file7; //上传的文件
	private File file8; //上传的文件
	private String file1FileName;
	private String file2FileName;
	private String file3FileName;
	private String file4FileName;
	private String file5FileName;
	private String file6FileName;
	private String file7FileName;
	private String file8FileName;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	
	public String getCheckboxs() {
		return checkboxs;
	}
	public void setCheckboxs(String checkboxs) {
		this.checkboxs = checkboxs;
	}
	public String getZzld() {
		return zzld;
	}
	public void setZzld(String zzld) {
		this.zzld = zzld;
	}
	public String getGljg() {
		return gljg;
	}
	public void setGljg(String gljg) {
		this.gljg = gljg;
	}
	public String getZrls() {
		return zrls;
	}
	public void setZrls(String zrls) {
		this.zrls = zrls;
	}
	public String getGzzd() {
		return gzzd;
	}
	public void setGzzd(String gzzd) {
		this.gzzd = gzzd;
	}
	public String getYhpc() {
		return yhpc;
	}
	public void setYhpc(String yhpc) {
		this.yhpc = yhpc;
	}
	public String getYjya() {
		return yjya;
	}
	public void setYjya(String yjya) {
		this.yjya = yjya;
	}
	public String getBarygl() {
		return barygl;
	}
	public void setBarygl(String barygl) {
		this.barygl = barygl;
	}
	public String getJfgl() {
		return jfgl;
	}
	public void setJfgl(String jfgl) {
		this.jfgl = jfgl;
	}
	public String getXfgl() {
		return xfgl;
	}
	public void setXfgl(String xfgl) {
		this.xfgl = xfgl;
	}
	public String getJtaq() {
		return jtaq;
	}
	public void setJtaq(String jtaq) {
		this.jtaq = jtaq;
	}
	public String getAqbm() {
		return aqbm;
	}
	public void setAqbm(String aqbm) {
		this.aqbm = aqbm;
	}
	public String getAqjy() {
		return aqjy;
	}
	public void setAqjy(String aqjy) {
		this.aqjy = aqjy;
	}
	public String getXxbs() {
		return xxbs;
	}
	public void setXxbs(String xxbs) {
		this.xxbs = xxbs;
	}
	public String getWwgl() {
		return wwgl;
	}
	public void setWwgl(String wwgl) {
		this.wwgl = wwgl;
	}
	public String getZdtfsj() {
		return zdtfsj;
	}
	public void setZdtfsj(String zdtfsj) {
		this.zdtfsj = zdtfsj;
	}
	public String getJljf() {
		return jljf;
	}
	public void setJljf(String jljf) {
		this.jljf = jljf;
	}
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public File getFile2() {
		return file2;
	}
	public void setFile2(File file2) {
		this.file2 = file2;
	}
	public File getFile3() {
		return file3;
	}
	public void setFile3(File file3) {
		this.file3 = file3;
	}
	public String getFile1FileName() {
		return file1FileName;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public String getFile2FileName() {
		return file2FileName;
	}
	public void setFile2FileName(String file2FileName) {
		this.file2FileName = file2FileName;
	}
	public String getFile3FileName() {
		return file3FileName;
	}
	public void setFile3FileName(String file3FileName) {
		this.file3FileName = file3FileName;
	}
	public File getFile4() {
		return file4;
	}
	public void setFile4(File file4) {
		this.file4 = file4;
	}
	public File getFile5() {
		return file5;
	}
	public void setFile5(File file5) {
		this.file5 = file5;
	}
	public File getFile6() {
		return file6;
	}
	public void setFile6(File file6) {
		this.file6 = file6;
	}
	public File getFile7() {
		return file7;
	}
	public void setFile7(File file7) {
		this.file7 = file7;
	}
	public File getFile8() {
		return file8;
	}
	public void setFile8(File file8) {
		this.file8 = file8;
	}
	public String getFile4FileName() {
		return file4FileName;
	}
	public void setFile4FileName(String file4FileName) {
		this.file4FileName = file4FileName;
	}
	public String getFile5FileName() {
		return file5FileName;
	}
	public void setFile5FileName(String file5FileName) {
		this.file5FileName = file5FileName;
	}
	public String getFile6FileName() {
		return file6FileName;
	}
	public void setFile6FileName(String file6FileName) {
		this.file6FileName = file6FileName;
	}
	public String getFile7FileName() {
		return file7FileName;
	}
	public void setFile7FileName(String file7FileName) {
		this.file7FileName = file7FileName;
	}
	public String getFile8FileName() {
		return file8FileName;
	}
	public void setFile8FileName(String file8FileName) {
		this.file8FileName = file8FileName;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		PinyinTool pt = new PinyinTool();
		List <Score>slist;
		SimpleDateFormat yearformat = new SimpleDateFormat("YYYY");
        String year=yearformat.format(date);
	
		String jigouid=position.substring(0, 3);
		
		if (file1 != null) {
			//	file1FileName = pt.toPinYin(file1FileName,"",Type.FIRSTUPPER);
			file1FileName = jigouid+file1FileName;
		       File savefile = new File(new File(Util.recordpath), file1FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file1, savefile);
		     }
		else
		{
			file1FileName = "--";
		}
		if (file2 != null) {
			//	file2FileName = pt.toPinYin(file2FileName,"",Type.FIRSTUPPER);
			file2FileName = jigouid+file2FileName;
		       File savefile = new File(new File(Util.recordpath), file2FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file2, savefile);
		     }
		else
		{
			file2FileName = "--";
		}
		if (file3 != null) {
		//	file3FileName = pt.toPinYin(file3FileName,"",Type.FIRSTUPPER);
			file3FileName = jigouid+file3FileName;
		       File savefile = new File(new File(Util.recordpath), file3FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file3, savefile);
		     }
		else
		{
			file3FileName = "--";
		}
		if (file4 != null) {
		//	file4FileName = pt.toPinYin(file4FileName,"",Type.FIRSTUPPER);
			file4FileName = jigouid+file4FileName;
		       File savefile = new File(new File(Util.recordpath), file4FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file4, savefile);
		     }
		else
		{
			file4FileName = "--";
		}
		if (file5 != null) {
		//	file5FileName = pt.toPinYin(file5FileName,"",Type.FIRSTUPPER);
			file5FileName = jigouid+file5FileName;
		       File savefile = new File(new File(Util.recordpath), file5FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file5, savefile);
		     }
		else
		{
			file5FileName = "--";
		}
		if (file6 != null) {
		//	file6FileName = pt.toPinYin(file6FileName,"",Type.FIRSTUPPER);
			file6FileName = jigouid+file6FileName;
		       File savefile = new File(new File(Util.recordpath), file6FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file6, savefile);
		     }
		else
		{
			file6FileName = "--";
		}
		if (file7 != null) {
		//	file7FileName = pt.toPinYin(file7FileName,"",Type.FIRSTUPPER);
			file7FileName = jigouid+file7FileName;
		       File savefile = new File(new File(Util.recordpath), file7FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file7, savefile);
		     }
		else
		{
			file7FileName = "--";
		}
		if (file8 != null) {
		//	file8FileName = pt.toPinYin(file8FileName,"",Type.FIRSTUPPER);
			file8FileName = jigouid+file8FileName;
		       File savefile = new File(new File(Util.recordpath), file8FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file8, savefile);
		     }
		else
		{
			file8FileName = "--";
		}
		
		
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		if(checkboxs.charAt(0)=='1')
    		{
    			String t = "0";
    			if(zzld!=null&&zzld.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"zzld",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(1)=='1')
    		{
    			String t = "0";
    			if(gljg!=null&&gljg.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"gljg",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(2)=='1')
    		{
    			String t = "0";
    			if(zrls!=null&&zrls.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"zrls",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(3)=='1')
    		{
    			String t = "0";
    			if(gzzd!=null&&gzzd.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"gzzd",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(4)=='1')
    		{
    			String t = "0";
    			if(yhpc!=null&&yhpc.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"yhpc",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(5)=='1')
    		{
    			String t = "0";
    			if(yjya!=null&&yjya.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"yjya",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(6)=='1')
    		{
    			String t = "0";
    			if(barygl!=null&&barygl.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"barygl",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(7)=='1')
    		{
    			String t = "0";
    			if(jfgl!=null&&jfgl.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"jfgl",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(8)=='1')
    		{
    			String t = "0";
    			if(xfgl!=null&&xfgl.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"xfgl",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(9)=='1')
    		{
    			String t = "0";
    			if(jtaq!=null&&jtaq.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"jtaq",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(10)=='1')
    		{
    			String t = "0";
    			if(aqbm!=null&&aqbm.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"aqbm",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(11)=='1')
    		{
    			String t = "0";
    			if(aqjy!=null&&aqjy.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"aqjy",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(12)=='1')
    		{
    			String t = "0";
    			if(xxbs!=null&&xxbs.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"xxbs",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(13)=='1')
    		{
    			String t = "0";
    			if(wwgl!=null&&wwgl.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"wwgl",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(14)=='1')
    		{
    			String t = "0";
    			if(zdtfsj!=null&&zdtfsj.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"zdtfsj",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		if(checkboxs.charAt(15)=='1')
    		{
    			String t = "0";
    			if(jljf!=null&&jljf.equals("yes"))
    			{
    				t = "1";
    			}
    			writetorecord(jigouid,t,"jljf",date,remark,content1,people,file1FileName,file2FileName,file3FileName,file4FileName,file5FileName,file6FileName,file7FileName,file8FileName,session);
    		}
    		slist=syssum(jigouid,year,session); //获取系统自动统计项目分数，写入数据库
    		for (int i=0;i<slist.size();i++){
    			update_syssum_score(slist.get(i).getJigouid(),slist.get(i).getItem(),slist.get(i).getNum(),slist.get(i).getYear(),slist.get(i).getScore(),session);
    		}
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
	public void writetorecord(String jigouid,String syssum,String type,Date date,String remark,String content1,String people,String url1,String url2,String url3,String url4,String url5,String url6,String url7,String url8,Session session) 
	{
		DateTimeUtil dtu = new DateTimeUtil();
		 Record re=new Record();
		 re.setContent1(content1);
		 re.setDate(date);
		 re.setJigouid(jigouid);
		 re.setPeople(people);
		 re.setSyssum(syssum);
		 re.setRemark(remark);
		 re.setType(type);
		 re.setUrl1(url1);
		 re.setUrl2(url2);
		 re.setUrl3(url3);
		 re.setUrl4(url4);
		 re.setUrl5(url5);
		 re.setUrl6(url6);
		 re.setUrl7(url7);
		 re.setUrl8(url8);
		 re.setRemark2(dtu.getStringDate());
	     RecordDAO red=new RecordDAO();		
		 red.save(re);
	}
	public List<Score> syssum(String jigouid,String year,Session session) 
	{    
		 String [] arry={"gljg","yhpc","yjya","barygl","jfgl","xfgl","aqbm","aqjy"};
		 List<Score> slist=new ArrayList<Score>();
		 
		 
		 int gljg=findsyssum(jigouid,"gljg",year,session);
		 int yhpc=findsyssum(jigouid,"yhpc",year,session);
		 int yjya=findsyssum(jigouid,"yjya",year,session);
		 int barygl=findsyssum(jigouid,"barygl",year,session);
         int jfgl=findsyssum(jigouid,"jfgl",year,session);
         int xfgl=findsyssum(jigouid,"xfgl",year,session);
         int aqbm=findsyssum(jigouid,"aqbm",year,session);
         int aqjy=findsyssum(jigouid,"aqjy",year,session); 


		 if (gljg>=2){
			 Score sc=new Score();
			 sc.setItem("gljg");
			 sc.setNum(3);
			 sc.setScore(2.0);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
			 			 
		 }if(gljg<2){
			 Score sc=new Score();
			 sc.setItem("gljg");
			 sc.setNum(3);
			 sc.setScore(((double)gljg*1));
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(yhpc>=12){
			 Score sc=new Score();
			 sc.setItem("yhpc");
			 sc.setNum(1);
			 sc.setScore(4.0);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(yhpc<12){
			 Score sc=new Score();
			 sc.setItem("yhpc");
			 sc.setNum(1);
			 sc.setScore(((double)yhpc)/3);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(yjya>=2){
			 Score sc=new Score();
			 sc.setItem("yjya");
			 sc.setNum(2);
			 sc.setScore(3.0);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(yjya<2){
			 Score sc=new Score();
			 sc.setItem("yjya");
			 sc.setNum(2);
			 sc.setScore(((double)yjya)*1.5);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(barygl>=2){
			 Score sc=new Score();
			 sc.setItem("barygl");
			 sc.setNum(3);
			 sc.setScore(2.0);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(barygl<2){
			 Score sc=new Score();
			 sc.setItem("barygl");
			 sc.setNum(3);
			 sc.setScore((double)barygl*1);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(jfgl>=2){
			 Score sc=new Score();
			 sc.setItem("jfgl");
			 sc.setNum(3);
			 sc.setScore(2.0);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(jfgl<2){
			 Score sc=new Score();
			 sc.setItem("jfgl");
			 sc.setNum(3);
			 sc.setScore((double)jfgl*1);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(xfgl>=2){
			 Score sc=new Score();
			 sc.setItem("xfgl");
			 sc.setNum(3);
			 sc.setScore(2.0);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(xfgl<2){
			 Score sc=new Score();
			 sc.setItem("xfgl");
			 sc.setNum(3);
			 sc.setScore((double)xfgl*1);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(aqbm>=3){
			 Score sc=new Score();
			 sc.setItem("aqbm");
			 sc.setNum(1);
			 sc.setScore(3.0);
			 sc.setJigouid(jigouid);
			 sc.setYear(year);
			 slist.add(sc);
		 }if(aqbm<3){
			 Score sc=new Score();
			 sc.setItem("aqbm");
			 sc.setNum(1);
			 sc.setScore((double)aqbm*1);
			 sc.setYear(year);
			 sc.setJigouid(jigouid);
			 slist.add(sc);
		 }if(aqjy>=2){
			 Score sc=new Score();
			 sc.setItem("aqjy");
			 sc.setNum(1);
			 sc.setScore(2.0);
			 sc.setYear(year);
			 sc.setJigouid(jigouid);
			 slist.add(sc);
		 }if(aqjy<2){
			 Score sc=new Score();
			 sc.setItem("aqjy");
			 sc.setNum(1);
			 sc.setScore((double)aqjy*1);
			 sc.setYear(year);
			 sc.setJigouid(jigouid);
			 slist.add(sc);
		 }
		
		 
		return slist;			
	
	}
	public int findsyssum(String jigouid,String type,String year,Session session) //查找自动得分类型数量
	{
		Query query;
		List mylist = null;
			String sql="select * from record where jigouid='"+jigouid+"' and mid(date,1,4)='"+year+"' and syssum='1' and type='"+type+"'";	
			System.out.println(sql);		
			query  = session.createSQLQuery(sql).addEntity(Record.class);		
			mylist=query.list();	
		return mylist.size();			
	
	}
	public void update_syssum_score(String jigouid,String item,int num,String year,Double score,Session session) 
	{
		Query query;
		List mylist = null;
			String sql="update score set score= CAST("+score+"*sub AS DECIMAL(18,1)) where jigouid='"+jigouid+"' and item='"+item+"' and num='"+num+"' and year='"+year+"'";	
			System.out.println(sql);		
			query  = session.createSQLQuery(sql).addEntity(Record.class);		
			query.executeUpdate();	
	}
	public void update_syssum_score1(String jigouid,String item,int num,String year,Double score,Session session) 
	{
		Query query;
		List mylist = null;
			String sql="update score set score= '"+score+"' where jigouid='"+jigouid+"' and item='"+item+"' and num='"+num+"' and year='"+year+"'";	
			System.out.println(sql);		
			query  = session.createSQLQuery(sql).addEntity(Record.class);		
			query.executeUpdate();	
	}
	public void update_syssum_score_alljigou(String year,Session session) 
	{
		Query query;
		List <JiGou>jigoulist ;
			String sql="select * from jigou ";	
			System.out.println(sql);		
			query  = session.createSQLQuery(sql).addEntity(JiGou.class);		
			jigoulist=query.list();
			
			for (int k=0;k<jigoulist.size();k++){				
			
				String jigouid=jigoulist.get(k).getJigouid();
			
				List <Score> slist=syssum(jigouid,year,session); //获取系统自动统计项目分数，写入数据库
			
				for (int i=0;i<slist.size();i++){
				
					update_syssum_score1(slist.get(i).getJigouid(),slist.get(i).getItem(),slist.get(i).getNum(),slist.get(i).getYear(),slist.get(i).getScore(),session);
			
				}		     
			}
	}
	
	

	}
	

	