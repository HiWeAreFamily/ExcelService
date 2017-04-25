/**
 * 
 */
package org.dcc.junit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dcc.excel.bean.cto_raid.Adapter;
import org.dcc.excel.bean.cto_raid.Constant;
import org.dcc.excel.bean.cto_raid.OneLine;
import org.dcc.excel.bean.cto_raid.OneLineCondition;
import org.dcc.excel.bean.cto_raid.OneLineDeriveTarget;
import org.dcc.excel.bean.cto_raid.Upgrade;
import org.dcc.excel.bean.cto_raid.main.CreateCTOTabelFor6241Utils;

/**
 * @author fangh1
 *
 */
public class CTOTabel {
	static List<Adapter> adapters = new ArrayList<Adapter>();
	static List<Upgrade> upgrades = new ArrayList<Upgrade>();
	static List<OneLineCondition> mixturelines = new ArrayList<OneLineCondition>();
	static List<OneLine> resultlines = new ArrayList<OneLine>();

	/**
	 * Add CPU for 7X21
	 * 
	 * @throws IOException
	 */
	// @Test

	public static void main(String[] args) throws Exception {
		CTOTabel action = new CTOTabel();
		// 1.把逻辑弄出来
		// 1.1基本选项组合
		action.initializeLine();
		int i = 0;
		int sum = 0;
		for (OneLineCondition line : mixturelines) {
			i++;
			sum += line.getLineAdapters().size();
			// System.out.println(i + ":]  " + line);
		}
		// 1.2 包含结果所有排列组合
		action.getResultLine();
		System.out.println(resultlines.size());
		System.out.println(sum);
		i = 0;
		for (OneLine oneline : resultlines) {
			i++;
			System.out.println("[" + i + "]:  " + oneline);
		}

		// 2.把文件写出来
		CreateCTOTabelFor6241Utils writeExcelUtils = new CreateCTOTabelFor6241Utils();
		String path = "D:/";
		String filename = "6241Raid_For_8U";
		String fileType = "xlsx";
		writeExcelUtils.writeExcel(path, filename, fileType, resultlines);

	}

	/**
	 * @param adapters
	 *            基本思路
	 */
	@Deprecated
	public void logicRaidTableFor6241(List<Adapter> adapters) {
		int i = 0;
		for (Adapter slot1 : adapters) {
			System.out.print(++i + "  ");
			System.out.println(slot1.getFc() + "  ");

			for (Adapter slot2 : adapters) {
				System.out.print(++i + "  ");
				System.out.print(slot1.getFc() + "  ");
				System.out.println(slot2.getFc() + "  ");
				for (Adapter slot3 : adapters) {
					System.out.print(++i + "  ");
					System.out.print(slot1.getFc() + "  ");
					System.out.print(slot2.getFc() + "  ");
					System.out.println(slot3.getFc() + "  ");
					for (Adapter slot4 : adapters) {
						System.out.print(++i + "  ");
						System.out.print(slot1.getFc() + "  ");
						System.out.print(slot2.getFc() + "  ");
						System.out.print(slot3.getFc() + "  ");
						System.out.println(slot4.getFc() + "  ");

					}
				}
			}
		}
	}

	/**
	 * @param line
	 * @param adapters
	 * @param upgrades
	 * @param slots
	 *            升级版递归
	 */
	private void updateLogic(OneLineCondition initializeLine, int slots) {
		slots++;

		if (slots > 4)
			return;
		for (Adapter slot : adapters) {
			OneLineCondition newLine1 = initializeLine.deepClone();
			newLine1.getLineAdapters().add(slot);
			mixturelines.add(newLine1);
			// 1.upgrade 递归
			if ("A3YZ".equals(slot.getFc())) {
				for (Upgrade upgrade : upgrades) {
					OneLineCondition newLine2 = newLine1.deepClone();
					newLine2.getUpgrades()[slots - 1] = upgrade;
					mixturelines.add(newLine2);
					updateLogic(newLine2, slots);
				}
			}
			// 2.Without Upgrade 递归
			updateLogic(newLine1, slots);

		}

	}

	public void initializeLine() {
		//
		adapters.add(new Adapter("A3YZ"));
		adapters.add(new Adapter("A3YY"));
		adapters.add(new Adapter("AS95"));

		upgrades.add(new Upgrade("A3Z0"));
		upgrades.add(new Upgrade("A3Z1"));
		upgrades.add(new Upgrade("A3Z2"));
		upgrades.add(new Upgrade("A3Z3"));
		// action.logicRaidTableFor6241(adapters);
		OneLineCondition initializeLine = new OneLineCondition();
		updateLogic(initializeLine, 0);
	}

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

	public void getResultLine() {
		for (OneLineCondition condition : mixturelines) {
			for (int i = 0; i < condition.getLineAdapters().size(); i++) {
				OneLine resultLine = new OneLine();

				OneLineDeriveTarget deriveTarget = createDeriveTarget(condition, i);
				resultLine.setCondition(condition);
				resultLine.setDeriveTarget(deriveTarget);
				resultlines.add(resultLine);

			}
			// switch (line.getLineAdapters().size()) {
			// case 1:
			// System.out.println(1);
			// if(){
			//
			// }
			// break;
			// case 2:
			// System.out.println(2);
			//
			// break;
			// case 3:
			// System.out.println(2);
			//
			// break;
			// case 4:
			// System.out.println(2);
			//
			// break;
			// default:
			// System.out.println("Error --> default");
			// break;
			// }
		}

	}

	/**
	 * @param line
	 * @param i
	 *            第几张卡1-4 ;从0开始计数
	 * @return
	 */
	private OneLineDeriveTarget createDeriveTarget(OneLineCondition line, int i) {
		OneLineDeriveTarget deriveTarget = new OneLineDeriveTarget();
		Adapter adapter = line.getLineAdapters().get(i);
		String pleacement = Constant.relationShip.get(adapter.getFc());
		deriveTarget.setRaidcard_twin_FC(pleacement);
		deriveTarget.setCtrl_id_FC(Constant.relationShip.get(Integer.toString(i + 1)));
		if (line.getUpgrades()[i] != null) {
			String upgradeFC = line.getUpgrades()[i].getFc();
			String something = Constant.relationShip.get(upgradeFC);
			deriveTarget.setRaidcard_up_twin_FC(something);
		}
		return deriveTarget;
	}
}
