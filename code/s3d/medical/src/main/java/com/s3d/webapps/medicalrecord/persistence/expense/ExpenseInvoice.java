package com.s3d.webapps.medicalrecord.persistence.expense;

import com.s3d.tech.data.po.AbstractGeneralProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @version 1.0
 */

@Entity
@Table(name = "mr_expense_invoice")
public class ExpenseInvoice extends AbstractGeneralProperties {
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "self_paying_amount")
    private BigDecimal selfPayingAmount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "expenseInvoice")
    @JoinColumn(name = "expense_invoice_id")
    private List<ExpenseItem> expenseItems = new ArrayList<ExpenseItem>();

    public ExpenseInvoice() {

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

    public List<ExpenseItem> getExpenseItems() {
        return expenseItems;
    }

    public void setExpenseItems(List<ExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenseInvoice)) return false;
        if (!super.equals(o)) return false;

        ExpenseInvoice that = (ExpenseInvoice) o;

        if (expenseItems != null ? !expenseItems.equals(that.expenseItems) : that.expenseItems != null) return false;
        if (selfPayingAmount != null ? !selfPayingAmount.equals(that.selfPayingAmount) : that.selfPayingAmount != null)
            return false;
        if (totalAmount != null ? !totalAmount.equals(that.totalAmount) : that.totalAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (selfPayingAmount != null ? selfPayingAmount.hashCode() : 0);
        result = 31 * result + (expenseItems != null ? expenseItems.hashCode() : 0);
        return result;
    }
}