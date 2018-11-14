 package securityccb.khps.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import securityccb.khps.dao.KhpsDAO;
import securityccb.khps.pojo.Khps;
import securityccb.khps.pojo.KhpsBean;

import securityccb.util.DateTimeUtil;
import securityccb.util.ExportExcel;
import securityccb.util.KhpsUtil;
import securityccb.util.Util;

import ccb.hibernate.HibernateSessionFactory;

public class ExportKhps {

	private String Path;
	private String year;

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getYear() {
		return year;
	}
	public String execute() throws Exception{
		String filePath = "";
		String thisunder ="";
		DateTimeUtil dtu = new DateTimeUtil();
		KhpsDAO khdao = new KhpsDAO();
		Khps kh = new Khps();
		KhpsUtil khu=new KhpsUtil();
		List<Khps> list;
		List<KhpsBean> khblist = new ArrayList<KhpsBean>();
		ExportExcel<KhpsBean> ex = new ExportExcel<KhpsBean>();
		String[] headers = {"序号","直属机构名称","年度考核得分"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from Khps where status='4' ";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			
			Khps kp = list.get(i);
			KhpsBean khb = new KhpsBean();
			khb.setXuhao(i+1);
			khb.setJigouname(khu.JigouidToName(kp.getJigouid()));
			khb.setScore(kp.getScore());
			thisunder=khu.IdtoName(kp.getPreunder());
			khblist.add(khb);
		}
		//导出
		 try {
			 	
			       
			    filePath=Util.downloadpath+"khps.xls";
				Path = "khps.xls";
				OutputStream out = new FileOutputStream(filePath);
				// 声明一个工作薄
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        // 生成一个表格
		        HSSFSheet sheet = workbook.createSheet("总行直属机构考核评审表");
		        sheet.setColumnWidth(0,3000);
		        sheet.setColumnWidth(1,15000);
		        sheet.setColumnWidth(2,6000);
		        // 生成一个样式
		        HSSFCellStyle styletitle = workbook.createCellStyle();//标题样式
		        
		        HSSFCellStyle styleremark_left = workbook.createCellStyle();//注释样式
		        HSSFCellStyle styleremark_right = workbook.createCellStyle();//注释样式
		        //设置标题样式
		        styletitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        styletitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        // 生成一个字体
		        HSSFFont fonttitle = workbook.createFont();
		        fonttitle.setFontHeightInPoints((short) 20);
		        fonttitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        // 把字体应用到当前的样式
		        styletitle.setFont(fonttitle);
		        // 设置表头
		        HSSFCellStyle stylehead = workbook.createCellStyle();//表头样式
		        stylehead.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		        stylehead.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		        stylehead.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		        stylehead.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		        stylehead.setBorderRight(HSSFCellStyle.BORDER_THIN);
		        stylehead.setBorderTop(HSSFCellStyle.BORDER_THIN);
		        stylehead.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        stylehead.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        stylehead.setWrapText(true);
		        // 生成一个字体
		        HSSFFont fonthead = workbook.createFont();
		        //fonthead.setColor(HSSFColor.VIOLET.index);
		        fonthead.setFontHeightInPoints((short)11);
		        fonthead.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        // 把字体应用到当前的样式
		        stylehead.setFont(fonthead);
		        // 设置注释
		        styleremark_left.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		        styleremark_left.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        styleremark_right.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		        styleremark_right.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        // 生成一个字体
		        HSSFFont fontremark = workbook.createFont();
		        fontremark.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		        fontremark.setFontHeightInPoints((short)12);
		        // 把字体应用到当前的样式
		        styleremark_left.setFont(fontremark);
		        styleremark_right.setFont(fontremark);
		        // 生成并设置另一个样式
		        HSSFCellStyle stylecontent = workbook.createCellStyle();
		        stylecontent.setFillForegroundColor(HSSFColor.WHITE.index);
		        stylecontent.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		        stylecontent.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setBorderRight(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setBorderTop(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        stylecontent.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        stylecontent.setWrapText(true);
		        //stylecontent.setLocked(true);
		        // 生成另一个字体
		        HSSFFont fontcontent = workbook.createFont();
		        fontcontent.setFontHeightInPoints((short)14);
		        fontcontent.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		        // 把字体应用到当前的样式
		        stylecontent.setFont(fontcontent);

		        // 生成并设置另一个样式，带深色底纹的背景 
		        HSSFCellStyle stylecontent2 = workbook.createCellStyle();
		        stylecontent2.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		        stylecontent2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		        stylecontent2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        stylecontent2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        stylecontent2.setWrapText(true);
		        // 把字体应用到当前的样式
		        stylecontent2.setFont(fontcontent);
		        // 声明一个画图的顶级管理器
		        //HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		        // 定义注释的大小和位置,详见文档
		        //HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,0, 0, 0, (short) 4, 2, (short) 6, 5));
		        // 设置注释内容
		        //comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		        //comment.setAuthor("leno");

		        //第一行title
		        HSSFRow row = sheet.createRow(0);
		        HSSFCell celltitle = row.createCell(0);
		        //sheet.addMergedRegion(new Region(0,(short)0,0,(short)17));//合并单元格 
		        celltitle.setCellStyle(styletitle);
		        celltitle.setCellValue(new HSSFRichTextString("中国建设银行直属机构"));
		      //第二行title
		        HSSFRow row1 = sheet.createRow(1);
		        HSSFCell celltitle1 = row1.createCell(0);
		        //sheet.addMergedRegion(new Region(0,(short)0,0,(short)17));//合并单元格 
		        celltitle1.setCellStyle(styletitle);
		        celltitle1.setCellValue(new HSSFRichTextString(year+"年度安全管理考核结果"));
		        //第二行填写处室
//		        row = sheet.createRow(1);
//		        HSSFCell cellremark = row.createCell(0);
//		        cellremark.setCellStyle(styleremark);
//		        
		        // 产生表格标题行
		        row = sheet.createRow(3);
		        for (short i = 0; i < headers.length; i++) {
		           
		           // HSSFCell cell = row.createCell((short) (celln + 1));   
					HSSFCell cell = row.createCell(i);
		            cell.setCellStyle(stylehead);
		            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
		            cell.setCellValue(text);
		        }
		      
				 int size = khblist.size();
				 String khr="";
			        for(int i=0;i<size;i++)
			        {
			        	KhpsBean kmb = khblist.get(i);
			        	row = sheet.createRow(i+4);
			        	Field[] fields = kmb.getClass().getDeclaredFields();
			        	int k=fields.length;
			        	for(int j=0;j<k;j++)
			        	{
			        		HSSFCell cell = row.createCell(j);
			        		
			        		Field field = fields[j];
			        		String fieldName = field.getName();
			        		String getMethodName = "get"
		                        + fieldName.substring(0, 1).toUpperCase()
		                        + fieldName.substring(1);
			        		try {
			        			Class tCls = kmb.getClass();
			        			Method getMethod = tCls.getMethod(getMethodName,
			                            new Class[] {});
			        			String value = getMethod.invoke(kmb,new Object[]{}).toString();
			        			System.out.println(value);
			        			cell.setCellStyle(stylecontent);
			        			
			        			if(value.equals("0")||value.equals("0.0"))
			        			{
			        				value = "-";
			        			}
			        			cell.setCellValue(value);
			        			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			        		}catch (SecurityException e) {
				                    // TODO Auto-generated catch block
				                	 System.out.println("first i="+i);
				                    e.printStackTrace();
				                   
				                }finally {
                // 清理资源
            }}}
			        row = sheet.createRow(size+5);
			        HSSFCell cellremarkend1 = row.createCell(1);
			        cellremarkend1.setCellStyle(styleremark_left);
			        cellremarkend1.setCellValue("审批人："+thisunder);
			        HSSFCell cellremarkend2 = row.createCell(2);
			        cellremarkend2.setCellStyle(styleremark_right);
			        cellremarkend2.setCellValue(dtu.getDate());
			        //两两合并单元格
//			        for(int i=0;i<(size/2);i++)
//			        {
//			        	sheet.addMergedRegion(new Region(i*2+3,(short)0,i*2+4,(short)0));
//			        	sheet.addMergedRegion(new Region(i*2+3,(short)1,i*2+4,(short)1));
//			        	sheet.addMergedRegion(new Region(i*2+3,(short)23,i*2+4,(short)23));
//			        }
			        sheet.addMergedRegion(new Region((short)0,(short)0,(short)0,(short)2));
			        sheet.addMergedRegion(new Region((short)1,(short)0,(short)1,(short)2));
			        try {
			            workbook.write(out);
			        } catch (IOException e) {
			        	System.out.println("100 i=");
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
					
					out.close();
					System.out.println("excel导出成功！");
				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			return "success";
		}
	}