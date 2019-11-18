/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousetwo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author IX Hero
 */
public class Product {
    
    private String productName;
    private String productCode;
    private int quantity;
    private Date expirationDate;

    public Product(String productName, String productCode, int quantity, Date expirationDate) {
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }
 
    public String setStringDate (Date expirationDate) {
        String stringDate = new SimpleDateFormat("yyyy-MM-dd").format(expirationDate);
        return stringDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    @Override
    public String toString() {
        return "Product{" + "productName = " + productName + ", productCode = " + productCode + ", quantity = " + quantity + ", expirationDate = " + setStringDate(expirationDate) + '}';
    }
    
}
