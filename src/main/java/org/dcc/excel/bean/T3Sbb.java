package org.dcc.excel.bean;

/**
 * T3 SBB Sheet 最常用的T3
 * 
 * @author fangh1
 * 
 */
public class T3Sbb {
	String status;
	String SBBType;
	String SBB;
	String MFI;
	String FFI;
	String Option;
	String FeatureCode;
	String Description;
	String Rules;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSBBType() {
		return SBBType;
	}

	public void setSBBType(String sBBType) {
		SBBType = sBBType;
	}

	public String getSBB() {
		return SBB;
	}

	public void setSBB(String sBB) {
		SBB = sBB;
	}

	public String getMFI() {
		return MFI;
	}

	public void setMFI(String mFI) {
		MFI = mFI;
	}

	public String getFFI() {
		return FFI;
	}

	public void setFFI(String fFI) {
		FFI = fFI;
	}

	public String getOption() {
		return Option;
	}

	public void setOption(String option) {
		Option = option;
	}

	public String getFeatureCode() {
		return FeatureCode;
	}

	public void setFeatureCode(String featureCode) {
		FeatureCode = featureCode;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getRules() {
		return Rules;
	}

	public void setRules(String rules) {
		Rules = rules;
	}

	public T3Sbb(String status, String sBBType, String sBB, String mFI, String fFI, String option, String featureCode, String description,
	        String rules) {
		super();
		this.status = status;
		SBBType = sBBType;
		SBB = sBB;
		MFI = mFI;
		FFI = fFI;
		Option = option;
		FeatureCode = featureCode;
		Description = description;
		Rules = rules;
	}

	public T3Sbb() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\"" + status + "\"|\"" + SBBType + "\"|\"" + SBB + "\"|\"" + MFI + "\"|\"" + FFI + "\"|\"" + Option + "\"|\"" + FeatureCode + "\"|\""
		        + Description + "\"|\"" + /* Rules */"\"";
	}

}
