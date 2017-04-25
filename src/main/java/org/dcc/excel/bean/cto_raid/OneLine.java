package org.dcc.excel.bean.cto_raid;

/**
 * @author fangh1
 *
 */
public class OneLine {
	OneLineCondition condition;
	OneLineDeriveTarget deriveTarget;

	/**
	 * @return the condition
	 */
	public OneLineCondition getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(OneLineCondition condition) {
		this.condition = condition;
	}

	/**
	 * @return the deriveTarget
	 */
	public OneLineDeriveTarget getDeriveTarget() {
		return deriveTarget;
	}

	/**
	 * @param deriveTarget
	 *            the deriveTarget to set
	 */
	public void setDeriveTarget(OneLineDeriveTarget deriveTarget) {
		this.deriveTarget = deriveTarget;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OneLine [condition=" + condition + ", deriveTarget=" + deriveTarget + "]";
	}

}
