package org.dcc.excel.bean.cto_raid;

/**
 * @author fangh1
 * 
 *         RAIDCARD_TWIN RAIDCARD_TWIN Quantity
 * 
 *         RAIDCARD_UP_TWIN RAIDCARD_UP_TWIN Quantity
 * 
 *         CTRL_ID CTRL_ID Quantity
 */
public class OneLineDeriveTarget {
	String raidcard_twin_FC = "";
	String raidcard_up_twin_FC = "";
	String ctrl_id_FC = "";

	/**
	 * @return the raidcard_twin_FC
	 */
	public String getRaidcard_twin_FC() {
		return raidcard_twin_FC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return raidcard_twin_FC + "  -  " + raidcard_up_twin_FC + "  -  " + ctrl_id_FC;
	}

	/**
	 * @param raidcard_twin_FC
	 *            the raidcard_twin_FC to set
	 */
	public void setRaidcard_twin_FC(String raidcard_twin_FC) {
		this.raidcard_twin_FC = raidcard_twin_FC;
	}

	/**
	 * @return the raidcard_up_twin_FC
	 */
	public String getRaidcard_up_twin_FC() {
		return raidcard_up_twin_FC;
	}

	/**
	 * @param raidcard_up_twin_FC
	 *            the raidcard_up_twin_FC to set
	 */
	public void setRaidcard_up_twin_FC(String raidcard_up_twin_FC) {
		this.raidcard_up_twin_FC = raidcard_up_twin_FC;
	}

	/**
	 * @return the ctrl_id_FC
	 */
	public String getCtrl_id_FC() {
		return ctrl_id_FC;
	}

	/**
	 * @param ctrl_id_FC
	 *            the ctrl_id_FC to set
	 */
	public void setCtrl_id_FC(String ctrl_id_FC) {
		this.ctrl_id_FC = ctrl_id_FC;
	}

}
