package com.yc.bean;

import java.sql.Timestamp;

public class Columns {
     private Long id;
     private Long parentId;
     private Long sort;
     private String columnName;
     private String aliasName;
     private String keyWords;
     private String description;
     private String createBy;
     private String status;
     private Timestamp createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getSort() {
		return sort;
	}
	public void setSort(Long sort) {
		this.sort = sort;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "columns [id=" + id + ", parentId=" + parentId + ", sort=" + sort + ", columnName=" + columnName
				+ ", aliasName=" + aliasName + ", keyWords=" + keyWords + ", description=" + description + ", createBy="
				+ createBy + ", status=" + status + ", createDate=" + createDate + "]";
	}
	public Columns(Long id, Long parentId, Long sort, String columnName, String aliasName, String keyWords,
			String description, String createBy, String status, Timestamp createDate) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.sort = sort;
		this.columnName = columnName;
		this.aliasName = aliasName;
		this.keyWords = keyWords;
		this.description = description;
		this.createBy = createBy;
		this.status = status;
		this.createDate = createDate;
	}
}
