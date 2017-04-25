/**
 * 
 */
package org.dcc.excel.bean.cto_raid;

import java.io.Serializable;

/**
 * @author fangh1
 *
 */
public class Adapter implements Serializable {
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

	public Adapter(String fc) {
		super();
		this.fc = fc;
	}

	public Adapter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
