package com.company;
import java.io.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader fr = new BufferedReader(new FileReader("src//text.txt"))) {
            int k = 0;
            String text = "";
            while ((k = fr.read()) != -1) {
                text += (char) k;
            }
            int a = text.indexOf("//");
            int b = text.indexOf("\n", a);
            StringBuffer sb = new StringBuffer(text);
            sb.delete(a, b);
            int c = sb.indexOf("/*");
           int d = sb.lastIndexOf("*/");
            StringBuffer kb = new StringBuffer(sb);
            sb.delete(c, d + 2);
            System.out.println(kb);
            try (FileWriter fww = new FileWriter("src//text2.txt");
                 BufferedWriter ad = new BufferedWriter(fww)) {
                ad.write(sb.toString());
            } catch (IOException ex) {
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
