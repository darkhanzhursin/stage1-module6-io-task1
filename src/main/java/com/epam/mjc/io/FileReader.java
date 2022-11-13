package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {
    private static String name;
    private static Integer age;
    private static String email;
    private static Long phone;

    private static Map<String, String> readFileIntoString(File filePath) {
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
    }

    public static Profile getDataFromFile(File file) {
        HashMap<String, String> profileMap = (HashMap<String, String>) readFileIntoString(file);
        name = profileMap.get("Name").trim();
        age = Integer.parseInt(profileMap.get("Age").trim());
        email = profileMap.get("Email").trim();
        phone = Long.parseLong(profileMap.get("Phone").trim());
        return new Profile(name, age, email, phone);
    }
}
