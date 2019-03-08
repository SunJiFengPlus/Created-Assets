package top.realdoer.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 *  普通用户服务端模型 
 */
@JsonInclude(Include.NON_NULL)
@Data
public class User {
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String phone;
	private Date registerDate;
	// 简介
	private String profile;
	// 头像
	private String avatar;
}
