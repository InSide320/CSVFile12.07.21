package com.company;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.management.openmbean.ArrayType;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Date;

public class Main {
//    static Employee[] abc = new Employee[3];
//    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("acme_worksheet1.csv"));
        CSVPrinter printer = new CSVPrinter(new FileWriter("acme_test.csv"), CSVFormat.EXCEL);
        String line = null;
        int index = 0;
//        List<String> emList = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
        String [] strname = new String[1];
        String [] name = new String[265];
        String [] strdate = new String[1];
        String [] date = new String[265];
        String [] strhour = new String[1];
        String [] hour = new String[265];
        int j =0;
        while ((line = reader.readLine()) != null) {
            Employee employee = new Employee();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {

                String data = scanner.next();
                if (index == 0) {
                    employee.setName(data);
                    for(int i =0;i< strname.length;i++){
                        try {
                            strname[i] = data;
                            name[j] = data;
                        }catch (ArrayIndexOutOfBoundsException e){
                            e.getMessage();
                        }
                    }
                } else if (index == 1) {
                    employee.setDate(data);
                    for(int i =0;i< strname.length;i++){
                        try {
                            strdate[i] = data;
                            date[j] = data;
                        }catch (ArrayIndexOutOfBoundsException e){
                            e.getMessage();
                        }
                    }

                } else if (index == 2) {
                    employee.setWork_hours(data);
                    for(int i =0;i< strname.length;i++){
                        try {
                            strhour[i] = data;
                            hour[j] = data;
                        }catch (ArrayIndexOutOfBoundsException e){
                            e.getMessage();
                        }
                    }
                } else
                    System.out.println("Error" + data);
                index++;

            }
            index = 0;
            j++;
        }
        String[] savename = new String[265];
        int[][] saveindex = new int[265][265];
        String[] savedate = new String[265];
        String[] savehour = new String[265];
        for(int i =0;i< name.length;i++){
            int count = 1;
            for (int k=i+1;k< name.length;k++){
                try {
                    if(name[i].equals(name[k])){
                        savename[i]=name[i];
                        count ++;
                        name[k] = null;
//                        System.out.println(name[i] + " " +k);
                    }
                }
                catch (NullPointerException e){
                    e.getMessage();
                }
            }
            if(savename[i]!=null)
                try {
//                    System.out.println(savename[i]+ " Cout: "+ count);
//                    printer.printRecord(savename);
//                    printer.printRecord(savename[i]);
                }
            catch (NullPointerException e){
                    e.getMessage();
            }

        }
        for(int i =0;i< date.length;i++){
            int count = 1;
            for (int k=i+1;k< date.length;k++){
                try {
                    if(date[i].equals(date[k])){
                        savedate[i]=date[i];
                        count ++;
                        date[k] = null;
//                        System.out.println(name[i] + " " +k);
                    }
                }
                catch (NullPointerException e){
                    e.getMessage();
                }
            }
            if(savedate[i]!=null)
                try {
//                    System.out.println(savedate[i] + " Count: " + count);
//                    printer.print(savedate[i]);
                }
                catch (NullPointerException e){
                    e.getMessage();
                }

        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        printer.print("Name/Date");
        for (int i=0;i< savedate.length;i++){
//            Date[] date1 = new SimpleDateFormat("yyyy-MM-dd").format(savedate[i]);
//            System.out.println(savedate[i]);
            if(savedate[i]!=null)
                    printer.print(savedate[i]);
        }
        printer.println();
        for (int i=0;i< hour.length;i++){
            printer.print(hour[i]);
        }
        printer.println();
        for(int i =0;i<265;i++){
            if(savename[i]!=null){
                printer.printRecord(savename[i]);
            }
        }
        printer.flush();
        reader.close();
        printer.close();
    }
}
