package com.chrzha.social.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="social_role")
public class Role {
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	
	public Role(){}
	public Role(Integer roleId, String roleName, String roleDesc) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleDesc=" + roleDesc + "]";
	}
	@Id
	@Column(name="role_id")
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Column(name="role_name")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Column(name="role_desc")
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	

}
