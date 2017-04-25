/**
 * 
 */
package org.dcc.junit;

import java.io.IOException;

import org.dcc.excel.service.ReadExcelService;
import org.junit.Test;

/**
 * @author fangh1
 *
 */
public class ExcelJunitTest {

	//@Test
	public void test() throws IOException {

		ReadExcelService excelUtils = new ReadExcelService();
		String path = "D:\\MT\\7x21\\CSR_manual_20170223055757.xlsx";
//		excelUtils.read2010XlsxFromCSR(path);
	}

}
