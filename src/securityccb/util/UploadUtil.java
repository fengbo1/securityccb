package securityccb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

/**
 * 2003和2007通用方法
 * @author htzx
 *
 */
public class UploadUtil {

	private static final String EXTENSION_XLS = ".xls";
	private static final String EXTENSION_XLSX = ".xlsx";
	
	
	/**
     * 文件检查
     * @param filePath
     * @throws FileNotFoundException
     * @throws FileFormatException
     */
	public void preReadCheck(String filePath) throws FileNotFoundException, FileFormatException {
        // 常规检查
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("传入的文件不存在：" + filePath);
        }

        if (!(filePath.endsWith(EXTENSION_XLS) || filePath.endsWith(EXTENSION_XLSX))) {
            throw new FileFormatException("传入的文件不是excel");
        }
    }
	 /***
     * <pre>
     * 取得Workbook对象(xls和xlsx对象不同,不过都是Workbook的实现类)
     *   xls:HSSFWorkbook
     *   xlsx：XSSFWorkbook
     * @param filePath
     * @return
     * @throws IOException
     * </pre>
     */
    public Workbook getWorkbook(String filePath) throws IOException {
    	preReadCheck(filePath);
        Workbook workbook = null;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith(EXTENSION_XLS)) {
            workbook = new HSSFWorkbook(is);
        } else if (filePath.endsWith(EXTENSION_XLSX)) {
            workbook = new XSSFWorkbook(is);
        }
        return workbook;
    }
    /**
     * 取单元格的值
     * @param cell 单元格对象
     * @param treatAsStr 0:数字，字符；1：日期；2时间
     * @return
     */
    public String getCellValue(Cell cell, int type) {
        if (cell == null) {
            return "";
        }

        if (type==0) {
            // 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”
            // 加上下面这句，临时把它当做文本来读取
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        else if(type==1)
        {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
        }
        else if(type==2)
        {
        	String temp = "";
        	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        	temp = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
        	if(temp.startsWith("12"))
        	{
        		return "00"+temp.substring(2,8);
        	}
        	else
        	{
        		return temp;
        	}
        }
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
        	
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }
}
