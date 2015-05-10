package com.s3d.webapps.da.primarypage.persistence;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:12:47
 */
public class ExpenseInvoice {

	private BigDecimal totalAmount;
	private BigDecimal selfPayingAmount;
	public ExpenseItem m_ExpenseItem;

	public ExpenseInvoice(){

	}

    public ExpenseItem getM_ExpenseItem() {
        return m_ExpenseItem;
    }

    public void setM_ExpenseItem(ExpenseItem m_ExpenseItem) {
        this.m_ExpenseItem = m_ExpenseItem;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSelfPayingAmount() {
        return selfPayingAmount;
    }

    public void setSelfPayingAmount(BigDecimal selfPayingAmount) {
        this.selfPayingAmount = selfPayingAmount;
    }
}