package securityccb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件读写操作
 * 审批事项专用
 * @author htzx
 *
 */
public class FileReadAndWrite {

	private String input;
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String execute() throws Exception
	{
		
		//filewrite(input);
		//fileread("D:\\QJSQ");
		return "success";
	}
	public String fileread(String type)
	{
		String path = "C:\\securityccb\\paixu\\"+type;
		File f=new File(path);
		String temp = "";
		if(!f.exists()){
			System.out.println("file not exist");
			return "null";
		}else{
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
				try {
					temp = reader.readLine();
					System.out.println(temp+":"+temp.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return temp;
	}
	public String filewrite(String input,String type)
	{
		String path = "C:\\securityccb\\paixu\\"+type;
		try {
			FileWriter fileWriter;
			fileWriter = new FileWriter(path,false);
			fileWriter.write(input);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 审批事项序号自动生成
	 * @param type QJSQ/WCGG/JBSP/KQQS
	 * @return
	 */
	public String readandwrite(String type,String firstindex)
	{
		int index = 1;
		String strindex = "";
		String content = fileread(type).trim();
		if(content==null||content.equals("")||content.equals("null"))//空
		{
			index = Integer.valueOf(firstindex);
		}
		else
		{
			index = Integer.valueOf(content);
		}
		index+=1;
		strindex = String.valueOf(index);
		filewrite(strindex,type);
		return strindex;
	}
	
	
}
