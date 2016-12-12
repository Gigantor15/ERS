package com.ers.beans;

public class ERS_REIMBURSEMENT_STATUS {

	private int statusId;
	private String status;
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ERS_REIMBURSEMENT_STATUS(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	public ERS_REIMBURSEMENT_STATUS() {
		super();
	}
	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT_STATUS [statusId=" + statusId + ", status=" + status + "]";
	}
	
	
}
