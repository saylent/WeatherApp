package org.disciullo;

import io.swagger.model.Post;

/**
 * Object to hold data which will be displayed on web page. Made up of components from
 * {@link User}, {@link Post} and {@link Comment}.
 * @author Anne
 *
 */
public class DisplayObject {

	private Integer userId;
	private Integer postId;
	private String personName;
	private String title;
	private Integer commentCount;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

}
