/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousetwo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IX Hero
 */
public class Menu extends Read {
    
    List<Product> productList = readProductsFromCSV("sample.csv");
    List<Product> orderedList = orderedProductsByName(productList);
    List<Product> mergedList = mergeDuplicates(orderedList);

    public void menu() {
        System.out.println("●	Peržiūrėti trūkstamų prekių kiekius - '1'");
        System.out.println("●	Patikrinti prekes, kurių galiojimo laikas pasibaigęs arba pasibaigs greitu metu - '2'");
        System.out.println("●	Prekių sąrašas - '3'");
        System.out.println("●	Išeiti iš sistemos - '4'");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Nurodykite prekių likutį: ");
                int choiceTwo = scan.nextInt();
                System.out.println();
                List<Product> listOne = checkAmount(mergedList, choiceTwo);
                break;
            case 2:
                System.out.println("Nurodykite galiojimo pabaigos datą (yyyy-MM-dd): ");
                String choiceFour = scan.next();
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(choiceFour);
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<Product> listTwo = checkExpireDate(mergedList, date);
                break;
            case 3:
                mergedList.forEach((products) -> {
                    System.out.println(products);
                });
                break;
            case 4:
                break;
            default:
                break;
        }
    }

}
