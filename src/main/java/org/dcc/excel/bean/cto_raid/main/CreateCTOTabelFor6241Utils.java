package org.dcc.excel.bean.cto_raid.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dcc.excel.bean.cto_raid.OneLine;
import org.dcc.excel.bean.cto_raid.OneLineCondition;
import org.dcc.excel.bean.cto_raid.OneLineDeriveTarget;
import org.dcc.excel.service.SimpleException;

import com.sun.deploy.uitoolkit.impl.fx.Utils;

/**
 * 2003 HSSFWorkbook HSSFSheet HSSFRow HSSFCell
 * 
 * 2010 XSSFWorkbook XSSFSheet XSSFRow XSSFCell
 * 
 * @author fangh1
 *
 * 
 *         从excel读取数据/往excel中写入 excel有表头，表头每列的内容对应实体类的属性
 * 
 * 
 */
public class CreateCTOTabelFor6241Utils {

	public void writeExcel(String path, String filename, String fileType, List<OneLine> resultLines) throws IOException {
		// 65列
		String title[] = { "STOR_ADAPTER", "STOR_ADAPTER Quantity", "STOR_ADAPTER", "STOR_ADAPTER Quantity", "STOR_ADAPTER", "STOR_ADAPTER Quantity",
		        "STOR_ADAPTER_UPGRADE", "STOR_ADAPTER_UPGRADE Quantity", "STOR_ADAPTER_UPGRADE", "STOR_ADAPTER_UPGRADE Quantity",
		        "STOR_ADAPTER_UPGRADE", "STOR_ADAPTER_UPGRADE Quantity", "STOR_ADAPTER_UPGRADE", "STOR_ADAPTER_UPGRADE Quantity", "STOR_ADAPTER2",
		        "STOR_ADAPTER2 Quantity", "STOR_ADAPTER2", "STOR_ADAPTER2 Quantity", "STOR_ADAPTER2", "STOR_ADAPTER2 Quantity",
		        "STOR_ADAPTER2_UPGRADE", "STOR_ADAPTER2_UPGRADE Quantity", "STOR_ADAPTER2_UPGRADE", "STOR_ADAPTER2_UPGRADE Quantity",
		        "STOR_ADAPTER2_UPGRADE", "STOR_ADAPTER2_UPGRADE Quantity", "STOR_ADAPTER2_UPGRADE", "STOR_ADAPTER2_UPGRADE Quantity",
		        "STOR_ADAPTER3", "STOR_ADAPTER3 Quantity", "STOR_ADAPTER3", "STOR_ADAPTER3 Quantity", "STOR_ADAPTER3", "STOR_ADAPTER3 Quantity",
		        "STOR_ADAPTER3_UPGRADE", "STOR_ADAPTER3_UPGRADE Quantity", "STOR_ADAPTER3_UPGRADE", "STOR_ADAPTER3_UPGRADE Quantity",
		        "STOR_ADAPTER3_UPGRADE", "STOR_ADAPTER3_UPGRADE Quantity", "STOR_ADAPTER3_UPGRADE", "STOR_ADAPTER3_UPGRADE Quantity",
		        "STOR_ADAPTER4", "STOR_ADAPTER4 Quantity", "STOR_ADAPTER4", "STOR_ADAPTER4 Quantity", "STOR_ADAPTER4", "STOR_ADAPTER4 Quantity",
		        "STOR_ADAPTER4_UPGRADE", "STOR_ADAPTER4_UPGRADE Quantity", "STOR_ADAPTER4_UPGRADE", "STOR_ADAPTER4_UPGRADE Quantity",
		        "STOR_ADAPTER4_UPGRADE", "STOR_ADAPTER4_UPGRADE Quantity", "STOR_ADAPTER4_UPGRADE", "STOR_ADAPTER4_UPGRADE Quantity", "CTO",
		        "RAIDCARD_TWIN", "RAIDCARD_TWIN Quantity", "RAIDCARD_UP_TWIN", "RAIDCARD_UP_TWIN Quantity", "CTRL_ID", "CTRL_ID Quantity",
		        "CONFIG_ID", "CONFIG_ID Quantity" };
		// createExcel("E:/被保险人员清单(新增).xlsx","sheet1",fileType,title);

		doWriter(path, filename, fileType, resultLines, title);
	}

	@SuppressWarnings("resource")
	public static void doWriter(String path, String fileName, String fileType, List<OneLine> list, String titleRow[]) throws IOException {
		Workbook workbook = null;
		String excelPath = path + File.separator + fileName + "." + fileType;
		File file = new File(excelPath);
		Sheet sheet = null;
		// 创建工作文档对象
		if (!file.exists()) {// 不存在
			if (fileType.equals("xls")) {
				workbook = new HSSFWorkbook();

			} else if (fileType.equals("xlsx")) {

				workbook = new XSSFWorkbook();
			} else {
				throw new SimpleException("文件格式不正确");
			}
			// 创建sheet对象
			sheet = (Sheet) workbook.createSheet("6241");
			OutputStream outputStream = new FileOutputStream(excelPath);
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();

		} else {// 存在
			if (fileType.equals("xls")) {
				workbook = new HSSFWorkbook();

			} else if (fileType.equals("xlsx")) {
				workbook = new XSSFWorkbook();

			} else {
				throw new SimpleException("文件格式不正确");
			}
		}
		// 创建sheet对象
		if (sheet == null) {
			sheet = (Sheet) workbook.createSheet("6241-1");
		}

		// 添加表头
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		row.setHeight((short) 540);
		cell.setCellValue("生成Raid 所有排列组合,并根据所选设置derive part"); // 创建第一行

		CellStyle style = workbook.createCellStyle(); // 样式对象
		// 设置单元格的背景颜色为淡蓝色
		style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);

		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(CellStyle.ALIGN_CENTER);// 水平
		style.setWrapText(true);// 指定当单元格内容显示不下时自动换行

		cell.setCellStyle(style); // 样式，居中

		Font font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 180);
		style.setFont(font);
		// 单元格合并
		// 四个参数分别是：起始行，起始列，结束行，结束列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
		sheet.autoSizeColumn(5200);

		row = sheet.createRow(1); // 创建第二行
		for (int i = 0; i < titleRow.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(titleRow[i]);
			cell.setCellStyle(style); // 样式，居中
			sheet.setColumnWidth(i, 20 * 65);
		}
		row.setHeight((short) 540);

		// 循环写入行数据
		 for (int i = 0; i < list.size(); i++) {
//		for (int i = 0; i < 10; i++) {
			row = (Row) sheet.createRow(i + 2);
			row.setHeight((short) 300);
			// 1.全0
			for (int j = 0; j < 65; j++) {
				row.createCell(j).setCellValue("0");
			}
			// 2.adapter default
			// 3.upgrade default
			// int[] order = { 0, 14, 28, 42 };
			String[] selectable = { "A3YZ", "A3YY", "AS95", "A3Z0", "A3Z1", "A3Z2", "A3Z3" };
			int cont = 0;
			for (int slot = 0; slot < 4; slot++) {
				for (String item : selectable) {
					row.createCell(cont * 2).setCellValue(item);
					cont++;
				}
			}



			/*
			 * // Start Work:
			 */
			OneLine oneline = list.get(i);
			OneLineCondition condition = oneline.getCondition();
			// 1.adapter
			for (int slot = 0; slot < condition.getLineAdapters().size(); slot++) {
				Iterator<Cell> iter = row.cellIterator();
				String adapterfc = condition.getLineAdapters().get(slot).getFc();
				int flag = 0;
				while (iter.hasNext()) {
					if (adapterfc.equals(iter.next().getStringCellValue())) {
						flag += 1;
					}
					if (flag == slot + 1) {
						iter.next().setCellValue("1");
						break;
					}
				}
			}
			// 2.upgrade
			for (int slot = 0; slot < 4; slot++) {
				if (condition.getUpgrades()[slot] == null) {
					continue;
				}
				String upgradeFc = condition.getUpgrades()[slot].getFc();
				Iterator<Cell> iter = row.cellIterator();
				int flag = 0;
				while (iter.hasNext()) {
					if (upgradeFc.equals(iter.next().getStringCellValue())) {
						flag += 1;
					}
					if (flag == slot + 1) {
						iter.next().setCellValue("1");
						break;

					}
				}
			}
			// 3.derive target
			// 56 -- 57 --58   -   59 60 -61 62  - 63 64
			// 5374CM1 A46P 1  -  A46Q 0 -A2JX 1 - A2HP 1
			row.createCell(56).setCellValue("5374CM1");
			row.createCell(58).setCellValue("1");
			/* no upgrade, default A46Q =0 */
			row.createCell(59).setCellValue("A46Q");
			row.createCell(62).setCellValue("1");
			row.createCell(63).setCellValue("A2HP");
			row.createCell(64).setCellValue("1");
			
			OneLineDeriveTarget deriveTarget = oneline.getDeriveTarget();
			if (StringUtils.isNotEmpty(deriveTarget.getRaidcard_twin_FC())) {
				row.createCell(57).setCellValue(deriveTarget.getRaidcard_twin_FC());
			}
			if (StringUtils.isNotEmpty(deriveTarget.getRaidcard_up_twin_FC())) {
				row.createCell(59).setCellValue(deriveTarget.getRaidcard_up_twin_FC());
				row.createCell(60).setCellValue("1");
			}
			if (StringUtils.isNotEmpty(deriveTarget.getCtrl_id_FC())) {
				row.createCell(61).setCellValue(deriveTarget.getCtrl_id_FC());
			}

		}

		// 创建文件流
		OutputStream stream = new FileOutputStream(excelPath);
		// 写入数据
		workbook.write(stream);
		// 关闭文件流
		stream.close();
	}
}