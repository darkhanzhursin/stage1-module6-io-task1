package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class FileReader {
    private static String name;
    private static Integer age;
    private static String email;
    private static Long phone;

    /*private static Map<String, String> readFileIntoString(File filePath) {
        HashMap<String, String> map = new HashMap<>();
        String line;
       try (BufferedReader buffer = new BufferedReader(
           new java.io.FileReader(filePath)
       )) {
           while ((line = buffer.readLine()) != null) {
               String[] keyValuePair = line.split(":", 2);
               if (keyValuePair.length > 1) {
                   String key = keyValuePair[0];
                   String value = keyValuePair[1];
                   map.put(key, value);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return map;
    }*/

    public static Profile getDataFromFile(File file) {
        getData(file);
        return new Profile(name, age, email, phone);
    }

    private static void getData(File file) {
        try (BufferedReader buffer =
            new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            String[] nameLine = buffer.readLine().split(":", 2);
            name = nameLine[1].trim();
            String[] ageLine = buffer.readLine().split(":", 2);
            age = Integer.parseInt(ageLine[1].toString().trim());
            String[] emailLine = buffer.readLine().split(":", 2);
            email = emailLine[1].trim();
            String[] phoneLine = buffer.readLine().split(":", 2);
            phone = Long.parseLong(phoneLine[1].toString().trim());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
