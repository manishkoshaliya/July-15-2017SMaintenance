package com.example.school.objects;
/**
 * @author dipenp
 *
 */
public class Items {

	private String itemName;

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	private int Quantity;
	private String itemDesc;
	private int iconId;

	public int getIconId() {
		return iconId;
	}

	public void setIconId(int iconId) {
		this.iconId = iconId;
	}

	public Items(String itemName, int iconid) {
		this.itemName = itemName;
		this.iconId = iconid;

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
}
