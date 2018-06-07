package com.multicampus.biz.post;

import java.sql.Date;

public class PostVO {
	private String postId;
	private String blogId;
	private String categoryId;
	private String title;
	private String content;
	private Date createdDate;
	private Date modifiedDate;

	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "PostVO [categoryId=" + categoryId 
				+ ", content=" + content 
				+ ", blogId=" + blogId
				+ ", postId=" + postId 
				+ ", title=" + title 
				+ ", createdDate=" + createdDate 
				+ ", modifiedDate=" + modifiedDate + "]";
	}
}
