package org.dcc.excel.bean.cto_raid;

import java.io.Serializable;

public class Upgrade implements Serializable {
	private int index;
	private String fc;

	/**
	 * @return the fc
	 */
	public String getFc() {
		return fc;
	}

	/**
	 * @param fc
	 *            the fc to set
	 */
	public void setFc(String fc) {
		this.fc = fc;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	public Upgrade(int index, String fc) {
		super();
		this.index = index;
		this.fc = fc;
	}

	public Upgrade(String fc) {
		super();
		this.fc = fc;
	}

	public Upgrade() {
		super();
		// TODO Auto-generated constructor stub
	}

}
