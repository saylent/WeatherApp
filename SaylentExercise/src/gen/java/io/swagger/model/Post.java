package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-08-06T19:44:40.063-04:00")
public class Post   {
	// was generated with BigDecimal for id, changed to Integer
	private Integer id = null;
	private Integer userId = null;
	private String title = null;
	private String body = null;

	/**
	 **/

	@ApiModelProperty(value = "")
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 **/

	@ApiModelProperty(value = "")
	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 **/

	@ApiModelProperty(value = "")
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 **/

	@ApiModelProperty(value = "")
	@JsonProperty("body")
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Post post = (Post) o;
		return Objects.equals(id, post.id) &&
				Objects.equals(userId, post.userId) &&
				Objects.equals(title, post.title) &&
				Objects.equals(body, post.body);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userId, title, body);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Post {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    body: ").append(toIndentedString(body)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

