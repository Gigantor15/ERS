package com.ers.beans;

import java.util.Date;
import java.sql.Timestamp;

public class ERS_REIMBURSEMENT {

	private int id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private ERS_USERS author;
	private ERS_USERS resolver;
	private ERS_REIMBURSEMENT_STATUS statusId;
	private ERS_REIMBURSEMENT_TYPE typeId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ERS_USERS getAuthor() {
		return author;
	}
	public void setAuthor(ERS_USERS author) {
		this.author = author;
	}
	public ERS_USERS getResolver() {
		return resolver;
	}
	public void setResolver(ERS_USERS resolver) {
		this.resolver = resolver;
	}
	public ERS_REIMBURSEMENT_STATUS getStatusId() {
		return statusId;
	}
	public void setStatusId(ERS_REIMBURSEMENT_STATUS statusId) {
		this.statusId = statusId;
	}
	public ERS_REIMBURSEMENT_TYPE getTypeId() {
		return typeId;
	}
	public void setTypeId(ERS_REIMBURSEMENT_TYPE typeId) {
		this.typeId = typeId;
	}
	public ERS_REIMBURSEMENT(int id, double amount, Timestamp submitted, Timestamp resolved, String description, ERS_USERS author,
			ERS_USERS resolver, ERS_REIMBURSEMENT_STATUS statusId, ERS_REIMBURSEMENT_TYPE typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public ERS_REIMBURSEMENT() {
		super();
	}
	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
	
	
	
}
