package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-08-06T19:44:40.063-04:00")
public class Comment   {
	// was generated with BigDecimal for id, changed to Integer
	private Integer id = null;
	private Integer postId = null;
	private String name = null;
	private String email = null;
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
	@JsonProperty("postId")
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 **/

	@ApiModelProperty(value = "")
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 **/

	@ApiModelProperty(value = "")
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		Comment comment = (Comment) o;
		return Objects.equals(id, comment.id) &&
				Objects.equals(postId, comment.postId) &&
				Objects.equals(name, comment.name) &&
				Objects.equals(email, comment.email) &&
				Objects.equals(body, comment.body);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, postId, name, email, body);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Comment {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    postId: ").append(toIndentedString(postId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

