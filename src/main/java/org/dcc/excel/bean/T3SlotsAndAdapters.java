package org.dcc.excel.bean;

import org.dcc.excel.util.ExcelUtil;

/**
 * T3 T3SlotsAndAdapters Sheet
 * 
 * @author fangh1
 * 
 */
public class T3SlotsAndAdapters {
	String status;
	String category;
	String SBB;
	String option;
	String FeatureCode;
	String Description;
	String AdapterLength;
	String PCISupportSlotsSupported;
	String HotPlugCapable;
	String MaxSupported;
	String AdapterHeight;

	public T3SlotsAndAdapters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public T3SlotsAndAdapters(String status, String category, String sBB,
			String option, String featureCode, String description,
			String adapterLength, String pCISupportSlotsSupported,
			String hotPlugCapable, String maxSupported, String adapterHeight) {
		super();
		this.status = status;
		this.category = category;
		this.SBB = sBB;
		this.option = option;
		this.FeatureCode = featureCode;
		this.Description = description;
		this.AdapterLength = adapterLength;
		this.PCISupportSlotsSupported = pCISupportSlotsSupported;
		this.HotPlugCapable = hotPlugCapable;
		this.MaxSupported = maxSupported;
		this.AdapterHeight = adapterHeight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSBB() {
		return SBB;
	}

	public void setSBB(String sBB) {
		SBB = sBB;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
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

	public String getAdapterLength() {
		return AdapterLength;
	}

	public void setAdapterLength(String adapterLength) {
		AdapterLength = adapterLength;
	}

	public String getPCISupportSlotsSupported() {
		return PCISupportSlotsSupported;
	}

	public void setPCISupportSlotsSupported(String pCISupportSlotsSupported) {
		PCISupportSlotsSupported = pCISupportSlotsSupported;
	}

	public String getHotPlugCapable() {
		return HotPlugCapable;
	}

	public void setHotPlugCapable(String hotPlugCapable) {
		HotPlugCapable = hotPlugCapable;
	}

	public String getMaxSupported() {
		return MaxSupported;
	}

	public void setMaxSupported(String maxSupported) {
		MaxSupported = maxSupported;
	}

	public String getAdapterHeight() {
		return AdapterHeight;
	}

	public void setAdapterHeight(String adapterHeight) {
		AdapterHeight = adapterHeight;
	}

	public String toString() {
		return "\"" + ExcelUtil.sameLine(status) + "\"|\"" + category + "\"|\""
				+ SBB + "\"|\"" + option + "\"|\"" + FeatureCode + "\"|\""
				+ Description + "\"|\"" + AdapterLength + "\"|\""
				+ ExcelUtil.sameLine(PCISupportSlotsSupported) + "\"|\""
				+ ExcelUtil.sameLine(HotPlugCapable) + "\"|\""
				+ ExcelUtil.sameLine(MaxSupported) + "\"|\""
				+ ExcelUtil.sameLine(AdapterHeight) + "\"";
	}
}
