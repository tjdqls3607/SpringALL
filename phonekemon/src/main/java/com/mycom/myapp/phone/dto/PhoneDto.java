package com.mycom.myapp.phone.dto;

import java.math.BigDecimal;

public class PhoneDto {
    private int phoneId;
    private String modelName;
    private String manufacturer;
    private BigDecimal price;
    private int stockQuantity;
	
    public PhoneDto() {}
    public PhoneDto(int phoneId, String modelName, String manufacturer, BigDecimal price, int stockQuantity) {
		super();
		this.phoneId = phoneId;
		this.modelName = modelName;
		this.manufacturer = manufacturer;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	@Override
	public String toString() {
		return "PhoneDto [phoneId=" + phoneId + ", modelName=" + modelName + ", manufacturer=" + manufacturer
				+ ", price=" + price + ", stockQuantity=" + stockQuantity + "]";
	}
    
    
 
    
    
}
