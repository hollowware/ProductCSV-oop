/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousetwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author IX Hero
 */
public class WillCompare {
    
    public List<Product> orderedProductsByName(List<Product> productList) {
        Collections.sort(productList, (Product strings, Product otherStrings) -> strings.getProductName().compareTo(otherStrings.getProductName()));
        return productList;
    }
    
    public List<Product> mergeDuplicates(List<Product> productList) {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (i == 0) {
                list.add(productList.get(0));
            }
            int count = 0;
            for (int k = 0; k < list.size(); k++) {
                if (productList.get(i).getProductName().equals(list.get(k).getProductName()) 
                        && productList.get(i).getProductCode().equals(list.get(k).getProductCode()) 
                        && productList.get(i).getExpirationDate().equals(list.get(k).getExpirationDate())) {
                    int intOne = list.get(k).getQuantity();
                    int intTwo = productList.get(i).getQuantity();
                    intOne += intTwo;
                    list.get(k).setQuantity(intOne);
                    productList.get(i).setQuantity(intTwo);
                } else {
                    count++;
                }
            }
            if (count == list.size()) {
                list.add(productList.get(i));
            }
        }
        return list;
    }
    
    public List<Product> checkAmount(List<Product> productList, int amount) {
        int count = 1;
        for (Product product : productList) {
            if (product.getQuantity() < amount) {
                System.out.println(count + " - " + product);
                count++;
            }
        }
        return productList;
    }
    
    public List<Product> checkExpireDate(List<Product> productList, Date date) {
        int count = 1;
        for (Product product : productList) {
            if (product.getExpirationDate().before(date)) {
                System.out.println(count + " - " + product);
                count++;
            }
        }
        return productList;
    }
    
}
