package com.exp.ucmp.auth.dto;

import java.util.List;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SystemMenuDto", description = "系统菜单")
public class SystemMenuDto {
	
	@ApiModelProperty(value = "菜单名称")
	private String menuName;
	
	@ApiModelProperty(value = "菜单路径")
	private String menuPath;
	
	@ApiModelProperty(value = "菜单序号")
	private Long menuSequence;
	
	@ApiModelProperty(value = "子菜单集合")
	private List<SystemMenuDto> childMenu;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public Long getMenuSequence() {
		return menuSequence;
	}

	public void setMenuSequence(Long menuSequence) {
		this.menuSequence = menuSequence;
	}

	public List<SystemMenuDto> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<SystemMenuDto> childMenu) {
		this.childMenu = childMenu;
	}
}
