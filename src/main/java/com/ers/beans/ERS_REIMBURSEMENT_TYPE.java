package com.ers.beans;

public class ERS_REIMBURSEMENT_TYPE {

	private int typeId;
	private String type;
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ERS_REIMBURSEMENT_TYPE(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	public ERS_REIMBURSEMENT_TYPE() {
		super();
	}
	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT_TYPE [typeId=" + typeId + ", type=" + type + "]";
	}
	
	
}
