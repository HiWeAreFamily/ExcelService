/**
 * 
 */
package org.dcc.excel.bean.cto_raid;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fangh1 代表一行
 */
public class OneLineCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Adapter> lineAdapters = new ArrayList<Adapter>();
	Upgrade[] upgrades = new Upgrade[4];

	/**
	 * @return the lineAdapters
	 */
	public List<Adapter> getLineAdapters() {
		return lineAdapters;
	}

	/**
	 * @param lineAdapters
	 *            the lineAdapters to set
	 */
	public void setLineAdapters(List<Adapter> lineAdapters) {
		this.lineAdapters = lineAdapters;
	}

	/**
	 * @return the upgrades
	 */
	public Upgrade[] getUpgrades() {
		return upgrades;
	}

	/**
	 * @param upgrades
	 *            the upgrades to set
	 */
	public void setUpgrades(Upgrade[] upgrades) {
		this.upgrades = upgrades;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer strs = new StringBuffer();
		for (Adapter Adapter : lineAdapters) {
			strs.append(Adapter.getFc() + "    ");
		}
		strs.append("----");
		for (int i = 0; i < upgrades.length; i++) {
			if (upgrades[i] != null) {
				strs.append(i + "-" + upgrades[i].getFc() + ";    ");
			}
		}
		// strs.append("\r\n");
		return strs.toString();

	}

	/**
	 * 利用串行化深克隆一个对象，把对象以及它的引用读到流里，在写入其他的对象
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public OneLineCondition deepClone() {
		// 将对象写到流里
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(bos);

			oos.writeObject(this);
			// 从流里读回来
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			return (OneLineCondition) ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(4 * 4 * 4 * 4);

		int i = 5;
		int k = 5;
		System.out.println(i += 1);
		System.out.println(k = +1);
		// System.out.println(k++++);
	}
}
