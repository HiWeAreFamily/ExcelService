package org.dcc.excel.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelUtil {
	public static void main(String[] args) {
		System.out.println("Main");
	}

	public static String sameLine(String myString) {
		String newString = myString;
		Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
		Matcher m = CRLF.matcher(myString);
		if (m.find()) {
			newString = m.replaceAll(" ");
		}
		return newString;
	}

	/**
	 * 获取文件后缀名
	 * 
	 * get postfix后缀 of the path
	 * 
	 * @param path
	 * @return
	 */
	public static String getPostfix(String path) {
		if (path == null || Common.EMPTY.equals(path.trim())) {
			return Common.EMPTY;
		}
		if (path.contains(Common.POINT)) {
			return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
		}
		return Common.EMPTY;
	}

}
