package project.com.bo;

public class Cart {
	Long billNumber;
	Long id;
	Long userId;
	Long itemId;
	String name;
	Long quantity;
	Long price;
	Integer placed;
	public Long getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getUserId() {
		return userId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItem_id(Long itemId) {
		this.itemId = itemId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Integer getPlaced() {
		return placed;
	}
	public void setPlaced(Integer placed) {
		this.placed = placed;
	}
}
