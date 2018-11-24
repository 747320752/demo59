package com.yc.bean;

import java.sql.Timestamp;

public class Flink {
    private Long id;
    private Long sort;
    private String name;
    private String webUrl;
    private String linkImg;
    private String description;
    private String status;
    private String openWays;
    private String createBy;
    private Timestamp createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSort() {
		return sort;
	}
	public void setSort(Long sort) {
		this.sort = sort;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOpenWays() {
		return openWays;
	}
	public void setOpenWays(String openWays) {
		this.openWays = openWays;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "flink [id=" + id + ", sort=" + sort + ", name=" + name + ", webUrl=" + webUrl + ", linkImg=" + linkImg
				+ ", description=" + description + ", status=" + status + ", openWays=" + openWays + ", createBy="
				+ createBy + ", createDate=" + createDate + "]";
	}
	public Flink(Long id, Long sort, String name, String webUrl, String linkImg, String description, String status,
			String openWays, String createBy, Timestamp createDate) {
		super();
		this.id = id;
		this.sort = sort;
		this.name = name;
		this.webUrl = webUrl;
		this.linkImg = linkImg;
		this.description = description;
		this.status = status;
		this.openWays = openWays;
		this.createBy = createBy;
		this.createDate = createDate;
	}
	
}
