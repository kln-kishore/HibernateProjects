package com.kln.domain;

public class EmployeeDetails {

	private int empId;
	private String empName;
	private String city;
	private double pay;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", empName=" + empName + ", city=" + city + ", pay=" + pay + "]";
	}




}
