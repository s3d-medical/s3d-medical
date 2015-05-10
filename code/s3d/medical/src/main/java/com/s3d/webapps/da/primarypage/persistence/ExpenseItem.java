package com.s3d.webapps.da.primarypage.persistence;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:12:48
 */
public class ExpenseItem {

	private int category;
	private String itemName;
	private BigDecimal amount;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}