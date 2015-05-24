package com.s3d.webapps.medicalrecord.persistence.expense;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name = "mr_expense_item")
public class ExpenseItem implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name = "category")
    protected String category;

    @Column(name = "item_name")
    protected String itemName;

    @Column(name = "amount")
    protected BigDecimal amount;

    @ManyToOne()
    @JoinColumn(name = "expense_invoice_id", referencedColumnName = "id")
    protected ExpenseInvoice expenseInvoice;

    public ExpenseItem() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public ExpenseInvoice getExpenseInvoice() {
        return expenseInvoice;
    }

    public void setExpenseInvoice(ExpenseInvoice expenseInvoice) {
        this.expenseInvoice = expenseInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenseItem)) return false;
        if (!super.equals(o)) return false;

        ExpenseItem that = (ExpenseItem) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (expenseInvoice != null ? !expenseInvoice.equals(that.expenseInvoice) : that.expenseInvoice != null)
            return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (expenseInvoice != null ? expenseInvoice.hashCode() : 0);
        return result;
    }
}