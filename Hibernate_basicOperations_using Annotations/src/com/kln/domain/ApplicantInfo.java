package com.kln.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ApplicantTable")
public class ApplicantInfo {
	@Id
	@Column(name = "RegistrationID")
	private int appId;
	@Column(name = "ApplicantName", length = 20, nullable = false)
	private String appName;
	@Column(name = "Address", length = 30)
	private String appAddress;
	@Column(name = "PANCARD")
	private String appPanNo;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppAddress() {
		return appAddress;
	}

	public void setAppAddress(String appAddress) {
		this.appAddress = appAddress;
	}

	public String getAppPanNo() {
		return appPanNo;
	}

	public void setAppPanNo(String appPanNo) {
		this.appPanNo = appPanNo;
	}

	@Override
	public String toString() {
		return "ApplicantInfo [appId=" + appId + ", appName=" + appName + ", appAddress=" + appAddress + ", appPanNo="
				+ appPanNo + "]";
	}

}
