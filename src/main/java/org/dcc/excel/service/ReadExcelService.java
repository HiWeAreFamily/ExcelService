package org.dcc.excel.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dcc.domain.Brand;
import org.dcc.domain.Category;
import org.dcc.domain.FunctionalType;
import org.dcc.domain.Mfg;
import org.dcc.domain.Product;
import org.dcc.domain.Release;
import org.dcc.excel.util.Common;
import org.dcc.excel.util.ExcelUtil;

/**
 * 2003 HSSFWorkbook HSSFSheet HSSFRow HSSFCell
 * 
 * 2010 XSSFWorkbook XSSFSheet XSSFRow XSSFCell
 * 
 * @author fangh1
 *
 */
public class ReadExcelService {

	/**
	 * read the Excel file
	 * 
	 * @param path
	 *            the path of the Excel file
	 * @return
	 * @throws IOException
	 */
	public List readExcel(String path) throws IOException {
		if (path == null || Common.EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = ExcelUtil.getPostfix(path);
			System.out.println(postfix);
			if (!Common.EMPTY.equals(postfix)) {
				if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return read2003Xls(path);
				} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return read2010Xlsx(path);
				}
			} else {
				System.out.println(path + Common.NOT_EXCEL_FILE);
			}
		}
		return null;
	}

	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public List<Product> read2010Xlsx(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

		Product product = null;
		List<Product> list = new ArrayList<Product>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					// SBB MFI FFI Option FeatureCode Description
					product = new Product();
					XSSFCell SBB = xssfRow.getCell(0);
					XSSFCell MFI = xssfRow.getCell(1);
					XSSFCell FFI = xssfRow.getCell(2);
					XSSFCell Option = xssfRow.getCell(3);
					XSSFCell FeatureCode = xssfRow.getCell(4);
					XSSFCell Description = xssfRow.getCell(5);

					product.setSbb(getValue(SBB));
					product.setMfi(getValue(MFI));
					product.setFfi(getValue(FFI));
					product.setOptPn(getValue(Option));
					// product.setScore(Float.valueOf(getValue(Description)));
					product.setFeatCode(getValue(FeatureCode));
					product.setDescription(getValue(Description));

					product.setCategory(new Category(10162, ""));
					product.setBrand(new Brand(1, "", null, null, null));
					product.setFunctionalType(new FunctionalType(26L, ""));
					product.setMfg(new Mfg(1));
					product.setPriced("Y");
					product.setVisible('1');
					product.setPassthru('1');

					product.getReleases().add(new Release(130, ""));
					product.getReleases().add(new Release(131, ""));
					product.getReleases().add(new Release(200, ""));

					System.out.println(product);
					list.add(product);
				}
			}
		}
		xssfWorkbook.close();
		return list;
	}

	/**
	 * Read the Excel 2003-2007
	 * 
	 * @param path
	 *            the path of the Excel
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public List<Product> read2003Xls(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {

			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				// hssfSheet.g
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					product = new Product();
					// SBB MFI FFI Option FeatureCode Description

					HSSFCell SBB = hssfRow.getCell(0);
					HSSFCell MFI = hssfRow.getCell(1);
					HSSFCell FFI = hssfRow.getCell(2);
					HSSFCell Option = hssfRow.getCell(3);
					HSSFCell FeatureCode = hssfRow.getCell(4);
					HSSFCell Description = hssfRow.getCell(5);

					product.setSbb(getValue(SBB));
					product.setMfi(getValue(MFI));
					product.setFfi(getValue(FFI));
					// product.setScore(Float.valueOf(getValue(Description)));
					product.setOptPn(getValue(Option));
					product.setFeatCode(getValue(FeatureCode));
					product.setDescription(getValue(Description));

					list.add(product);
				}
			}
		}
		return list;
	}

	@SuppressWarnings("static-access")
	private String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			return String.valueOf(xssfRow.getNumericCellValue());
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}

	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	/**
	 * Read the Excel 2010 From CSR Elois
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public List<Product> read2010XlsxFromCSR(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

		Product product = null;
		List<Product> list = new ArrayList<Product>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			System.out.println("======getSheetName():" + xssfSheet.getSheetName());
			// 1.Read SheetName
			if (xssfSheet != null && "CSR Sections".equals(xssfSheet.getSheetName())) {
				// 2.Read the Row(start line 2)
				for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
					XSSFRow xssfRow = xssfSheet.getRow(rowNum);
					if (xssfRow != null) {
						// SBB MFI FFI Option FeatureCode Description
						product = new Product();
						XSSFCell FeatureCode = xssfRow.getCell(1);
						XSSFCell Description = xssfRow.getCell(4);

						product.setFeatCode(getValue(FeatureCode));
						product.setDescription(getValue(Description));

						// 添加参数
						product.setCategory(new Category(321, ""));
						product.setBrand(new Brand(1, "", null, null, null));
						product.setFunctionalType(new FunctionalType(26L, ""));
						product.setMfg(new Mfg(31));
						product.setPriced("Y");
						product.setVisible('1');
						product.setPassthru('1');

						product.getReleases().add(new Release(130, ""));
						product.getReleases().add(new Release(131, ""));
						product.getReleases().add(new Release(200, ""));

//						System.out.println(product);
						list.add(product);
					}
				}
			}
		}
		xssfWorkbook.close();
		return list;
	}
}