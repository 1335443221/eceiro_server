package com.timber.eceiro.common.utils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 
/**
 * 
 * 导出XLS文件
 *
 */
public class GradesXLS {
 
	private String path;
 
	public GradesXLS() {
		super();
	}
	
	//构造函数获取保存excel路径
	public GradesXLS(String path) {
		super();
		this.path = path;
	}
	
	public Boolean CreateExcel(List<Object[]> dataList, String[] column, String clientName, HttpServletResponse response) throws Exception {
		//创建一个工作簿
		HSSFWorkbook workBook = new HSSFWorkbook();
		//创建一个工作表，名为：第一页
		HSSFSheet sheet = workBook.createSheet(clientName);
		//设置单元格的宽度（0：表示第一行的第一个单元格，1：第一行的第二个单元格）
		sheet.setColumnWidth((short) 0, 3500);
		sheet.setColumnWidth((short) 1, 5000);
		sheet.setColumnWidth((short) 2, 5000);
		//创建一个单元格，从0开始
		HSSFRow row = sheet.createRow((short) 0);
		//构造一个数组设置第一行之后的单元格
		HSSFCell[] cell = new HSSFCell[column.length];
		for (int i = 0; i < column.length; i++) {
			cell[i] = row.createCell(i);
			cell[i].setCellValue(column[i]);
		}
		
		//获得从数据库中查询出来的数据
		if (dataList != null && dataList.size() > 0) {
			//循环list中的数据
			for (int i = 0; i < dataList.size(); i++) {
				Object[] objs = dataList.get(i);
				HSSFRow dataRow = sheet.createRow(i + 1);
				HSSFCell data[] = new HSSFCell[column.length];
				for (int j = 0; j < column.length; j++) {
					data[j] = dataRow.createCell(j);
					String info = String.valueOf(objs[j]);
					System.out.println("GradesXLS:" + info);
					data[j].setCellValue((info == null) ? "" : info);
				}
			 }
			
			try {
//				String fileName = clientName + "-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
				//设置日期格式
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// new Date()为获取当前系统时间，也可使用当前时间戳
				String date = df.format(new Date());
				String fileName = clientName + "-" + date + ".xls";//文件名，客户端名+日期+文件后缀名
				response.setContentType("application/vnd.ms-excel");//设置内容格式
				response.setCharacterEncoding("utf-8");//设置编码格式
				response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("gbk"), "iso8859-1"));
				//用IO流来写进去
				OutputStream os = response.getOutputStream();
				workBook.write(os);
				os.flush();
				return true;
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		} 
		return false;
	}
	
}
