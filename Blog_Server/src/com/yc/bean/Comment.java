package com.yc.bean;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private Long titleId;
    private Long userId;
    private String content;
    private Timestamp commentTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTitleId() {
		return titleId;
	}
	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return "comment [id=" + id + ", titleId=" + titleId + ", userId=" + userId + ", content=" + content
				+ ", commentTime=" + commentTime + "]";
	}
	public Comment(Long id, Long titleId, Long userId, String content, Timestamp commentTime) {
		super();
		this.id = id;
		this.titleId = titleId;
		this.userId = userId;
		this.content = content;
		this.commentTime = commentTime;
	}
    
}
