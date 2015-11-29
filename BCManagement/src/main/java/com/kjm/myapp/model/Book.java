package com.kjm.myapp.model;

public class Book {
	private int bc_num;
	private String company;
    private String name;
    private String rank;
    private String phone;
    private String email;
    private String cp_addr;
    
    public Book(){}
    
	public Book(int bc_num, String company, String name, String rank,
			String phone, String email, String cp_addr) {
		super();
		this.bc_num = bc_num;
		this.company = company;
		this.name = name;
		this.rank = rank;
		this.phone = phone;
		this.email = email;
		this.cp_addr = cp_addr;
	}
	
	public int getBc_num() {
		return bc_num;
	}
	public void setBc_num(int bc_num) {
		this.bc_num = bc_num;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCp_addr() {
		return cp_addr;
	}
	public void setCp_addr(String cp_addr) {
		this.cp_addr = cp_addr;
	}
     
    
     
}
