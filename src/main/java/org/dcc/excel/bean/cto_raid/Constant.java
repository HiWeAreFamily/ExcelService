package org.dcc.excel.bean.cto_raid;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	public static Map<String, String> relationShip = new HashMap<String, String>();
	// A3YZ A46P
	// A3YY A46U
	// AS95 AT0P
	//
	// Z3Z0 A46Q
	// Z3Z1 A46R
	// Z3Z2 A46S
	// Z3Z3 A46T
	//
	// 1 A2JX
	// 2 A2JY
	// 3 A2JZ
	// 4 A2JW
	static {
		relationShip.put("A3YZ", "A46P");
		relationShip.put("A3YY", "A46U");
		relationShip.put("AS95", "AT0P");

		relationShip.put("A3Z0", "A46Q");
		relationShip.put("A3Z1", "A46R");
		relationShip.put("A3Z2", "A46S");
		relationShip.put("A3Z3", "A46T");

		relationShip.put("1", "A2JX");
		relationShip.put("2", "A2JY");
		relationShip.put("3", "A2JZ");
		relationShip.put("4", "A2JW");

	}

}
