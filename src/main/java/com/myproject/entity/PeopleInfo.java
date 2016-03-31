/**
 * 
 */
package com.myproject.entity;

import java.util.Date;

/**
 * @author feipt
 *
 */
public class PeopleInfo {
	private String name;
	private String id;
	private String address;
	private String gender;
	private String beginDate;
	private String endDate;
	private Date born;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	@Override
	public boolean equals(Object pi) {
		if(!(pi instanceof PeopleInfo)) {
			return false;
		}
		PeopleInfo p = (PeopleInfo) pi;
		String name = p.getName();
		String id = p.getId();
		if(name.equals(this.getName()) && id.equals(this.id)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "姓名:" + this.getName() + " 身份证号：" + this.getId();
	}
	
	
}
