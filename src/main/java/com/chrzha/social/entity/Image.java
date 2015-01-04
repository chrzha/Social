package com.chrzha.social.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "social_images")
public class Image {
	private Integer id;
	private String title;
	private String content;
	private String path;
	public Image(){}
	public Image(String title, String content, String path) {
		this.title = title;
		this.content = content;
		this.path = path;
	}
	@Override
	public String toString() {
		return "Image [title=" + title + ", content=" + content + ", path="
				+ path + "]";
	}
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "path")
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
