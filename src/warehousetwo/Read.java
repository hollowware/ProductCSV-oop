/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehousetwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IX Hero
 */
public class Read {

    public List<Product> readProductsFromCSV(String fileName) {
        List<Product> products = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            br.readLine(); // ignore header
            String line = br.readLine();
            while (line != null) {
                String[] values = line.split(",");
                Product product = createProduct(values);
                products.add(product);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return products;
    }

    public Product createProduct(String[] values) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String name = values[0];
        String code = values[1];
        int quantity = Integer.parseInt(values[2]);
        Date date = null;
        try {
            date = sdf.parse(values[3]);
        } catch (ParseException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Product(name, code, quantity, date);
    }

}
