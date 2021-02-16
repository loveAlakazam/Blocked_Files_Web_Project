package com.madras.check.model.vo;

public class BlockedFile {
	private String name; //파일확장자이름
	private String isFixed; //고정확장자인지 확인
	
	public BlockedFile() {}
	public BlockedFile(String name, String isFixed) {
		this.name=name;
		this.isFixed=isFixed;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIsFixed() {
		return isFixed;
	}
	
	public void setIsFixed(String isFixed) {
		this.isFixed = isFixed;
	}
	
	@Override
	public String toString() {
		return "BlockedFile [name=" + name + ", isFixed=" + isFixed + "]";
	}
}
