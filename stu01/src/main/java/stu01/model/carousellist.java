package stu01.model;

import java.util.List;

public class carousellist {
	private int code;
	private ctotalRow  totalRow;
	private String msg;
	private int count;
	private List<carousel> data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ctotalRow getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(ctotalRow totalRow) {
		this.totalRow = totalRow;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<carousel> getData() {
		return data;
	}
	public void setData(List<carousel> data) {
		this.data = data;
	}

}
