package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "users")
@NamedQueries({
    @NamedQuery(
    		name = "LoginCheck",
    		query = "SELECT u FROM User AS u WHERE u.user_id = :user_id AND u.password = :password"
    		),
    @NamedQuery(
    		name = "User_id_duplicate_Check",
    		query = "SELECT COUNT(u) FROM User AS u WHERE u.user_id = :user_id"
    		)
    })
@Entity
public class User {
	@Id
	@Column(name = "primary_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer primary_id;

	@Column(name = "user_id", nullable = false, unique = true)
	private String user_id;

	@Column(name = "password", length = 64, nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "admin_flag", nullable = false)
	private Integer admin_flag;

	@Column(name = "created_at", nullable = false)
	private Timestamp created_at;

	@Column(name = "updated_at", nullable = false)
	private Timestamp updated_at;


	public Integer getPrimary_id() {
		return primary_id;
	}
	public void setPrimary_id(Integer primary_id) {
		this.primary_id = primary_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAdmin_flag() {
		return admin_flag;
	}
	public void setAdmin_flag(Integer admin_flag) {
		this.admin_flag = admin_flag;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}



}
