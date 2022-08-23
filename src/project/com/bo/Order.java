package project.com.bo;

public class Order {
	private Long bill_number;
	private Long user_id;
	private java.sql.Date bill_date;
	private Integer status;
	public Long getBill_number() {
		return bill_number;
	}
	public void setBill_number(Long bill_number) {
		this.bill_number = bill_number;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public java.sql.Date getBill_date() {
		return bill_date;
	}
	public void setBill_date(java.sql.Date bill_date) {
		this.bill_date = bill_date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
