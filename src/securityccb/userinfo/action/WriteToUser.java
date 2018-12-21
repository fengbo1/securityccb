package securityccb.userinfo.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.Transaction;
import securityccb.chu.dao.ChuDAO;
import securityccb.jigou.dao.JiGouDAO;
import securityccb.userinfo.dao.UserInfoDAO;
import securityccb.userinfo.pojo.UserInfo;
import securityccb.util.UploadUtil;
import securityccb.util.Util;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;
public class WriteToUser extends ActionSupport{
private String jigouid; 
	
public String getJigouid() {
		return jigouid;
	}
public void setJigouid(String jigouid) {
		this.jigouid = jigouid;
	}

/**
	 * 把Excele表读出的数据，组装成一个List,统一导入数据库
	 * @param uploadFileFileName
	 */
public String loadRoleInfo(String uploadFileFileName,String jigouid){
	String message="success";
	UploadUtil uu = new UploadUtil();
	Util util = new Util();
	String directory = Util.basepath+"upload/upload_userinfo"; 
	//File target = new File(directory,uploadFileFileName);
	//List roleList = new ArrayList();
	Session se = HibernateSessionFactory.getSession();
	Transaction tr = se.beginTransaction();
	try{		
		String sql = "delete from userinfo where position='null' or length(position)<11";
		se.createSQLQuery(sql).executeUpdate();
		UserInfoDAO ud =new UserInfoDAO();
		JiGouDAO jgdao = new JiGouDAO();
		ChuDAO chudao = new ChuDAO();
		//FileInputStream fi = new FileInputStream(target);
		//Workbook wb = new HSSFWorkbook(fi);
		Workbook wb = uu.getWorkbook(directory+"/"+uploadFileFileName);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum()+1;
		List<UserInfoUp> alist=new ArrayList<UserInfoUp>();
		List<UserInfo> blist=new ArrayList<UserInfo>();
							
		for(int i=1;i<rowNum;i++){
			String name="";
			String newnumber="";
			String chushi="";
			String zhiwu="";			
			String password="";
            String address="";
            String tel="";
            String namesos="";
            String telsos="";
            String relation="";
            Row row = sheet.getRow(i);
			name = util.getCellValue(row.getCell(0), 0);
			chushi = util.getCellValue(row.getCell(1), 0);
			newnumber = util.getCellValue(row.getCell(2), 0);
			password = util.getCellValue(row.getCell(3), 0);
			zhiwu = util.getCellValue(row.getCell(4), 0);
			address = util.getCellValue(row.getCell(5), 0);
			tel = util.getCellValue(row.getCell(6), 0);
			namesos = util.getCellValue(row.getCell(7), 0);
			telsos = util.getCellValue(row.getCell(8), 0);
			relation = util.getCellValue(row.getCell(9), 0);
			UserInfoUp uiup=new UserInfoUp();
			if(name!=null&&name.length()>1)
			{
				uiup.setName(name);
				uiup.setChushi(chushi);
				uiup.setNewnumber(newnumber);
				uiup.setPassword(password);
				uiup.setZhiwu(zhiwu);
				uiup.setAddress(address);
				uiup.setTel(tel);
				uiup.setSosname(namesos);
				uiup.setSostel(telsos);
				uiup.setRelation(relation);
				alist.add(uiup);	
			}
		}
////////////////////////////////////////////////////////////22222222222222/////////////////////////////////////////////////////////////
		for(int i=0;i<alist.size();i++){
			int j=i+1;
			UserInfoUp uiu = alist.get(i);
			UserInfo ui=new UserInfo();
			//判断名字是否超长
			if(uiu.getName().length()>32){
				message="第"+i+"行名字超长，上传失败";
				return message;				
			}else{
				ui.setName(uiu.getName());
			}
			//判断处室是否存在,判断系统角色是否存在
			String chushiid=chudao.findChuidByJigouAndChushi(jigouid, uiu.getChushi());
			String zhiwu=Util.zhiwuTorolequanxian(uiu.getZhiwu());
			if(chushiid==null){
				message="第"+j+"行处室名称不存在，上传失败";
				return message;
			}if(zhiwu.equals("")){
				zhiwu="第"+j+"行职务不存在，上传失败";
				return message;
			}
			ui.setPosition(jigouid+chushiid+zhiwu);
			ui.setRole(zhiwu.substring(0, 1));
			ui.setQuanxian(zhiwu.substring(1, 2));			
			//判断newnumber是否合规； a的初始值是9  ；b的初始值是0
			int c=ud.checknewnumberNotInJigou(uiu.getNewnumber(),jigouid);//查看在非本机构中newnumber数量
			int b=checknewnumberbylist(alist,uiu.getNewnumber());//看看newnumber在上传中的数量
			if(b>1){
				message="上传文件中，新一代员工编号【"+uiu.getNewnumber()+"】存在重复";
				return message;
			}
			if(c>0){
				String jigouname=jgdao.findJigouNameByJigouid(ud.findJigouidByNewnumber(uiu.getNewnumber()));
				message="新一代员工编号:"+uiu.getNewnumber()+",其他机构("+jigouname+")已经使用，请联系系统管理员。";
				return message;
			}
			ui.setNewnumber(uiu.getNewnumber());
			ui.setPassword(uiu.getPassword());
			ui.setAddress(uiu.getAddress());
			ui.setTel(uiu.getTel());
			ui.setNamesos(uiu.getSosname());
			ui.setTelsos(uiu.getSostel());
			ui.setRelation(uiu.getRelation());		
			blist.add(ui);			
		}
////////////////////////////////////////////////////////////3333333333333333333333333/////////////////////////////////////////////////////////////		
	for(int k=0;k<blist.size();k++){
		UserInfo uitemp = blist.get(k);
		UserInfo uisv = ud.findAllByNewnumber(uitemp.getNewnumber());
		if(uisv==null)
		{
			uisv = new UserInfo();
		}
		uisv.setName(uitemp.getName());
		uisv.setPosition(uitemp.getPosition());
		uisv.setRole(uitemp.getRole());
		uisv.setQuanxian(uitemp.getQuanxian());
		uisv.setNewnumber(uitemp.getNewnumber());
		uisv.setPassword(uitemp.getPassword());
		uisv.setAddress(uitemp.getAddress());
		uisv.setTel(uitemp.getTel());
		uisv.setNamesos(uitemp.getNamesos());
		uisv.setTelsos(uitemp.getTelsos());
		uisv.setRelation(uitemp.getRelation());	
		ud.merge(uisv);	
	}
	}	
			catch(IOException e){
				tr.rollback();//出错回滚
			e.printStackTrace();
			}finally{
				tr.commit();
				se.flush();
				se.clear();
				se.close();
				}		
	
     return message; 
	}
public int checknewnumberbylist(List<UserInfoUp> alist,String newnumber) // 检查新一代员工编号在上传中的数量
{
	int ii=0;
	for (int kk=0;kk<alist.size();kk++){
		if(newnumber.equals(alist.get(kk).getNewnumber())){
			ii=ii+1;
		}
	}
	return ii;
}

}
