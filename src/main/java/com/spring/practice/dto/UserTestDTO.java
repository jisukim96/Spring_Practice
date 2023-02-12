package com.spring.practice.dto;

public class UserTestDTO {
	
	private int idx;
	
	private String id;
	
	private String pass;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserTestDTO [idx=" + idx + ", id=" + id + ", pass=" + pass + "]";
	}
	
	
}
