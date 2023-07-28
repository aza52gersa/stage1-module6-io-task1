package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {
        BufferedReader reader = null;
        try {
            Profile profile = new Profile();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();
                    switch (key) {
                        case "Name":
                            profile.setName(value);
                            break;
                        case "Age":
                            profile.setAge(Integer.parseInt(value));
                            break;
                        case "Email":
                            profile.setEmail(value);
                            break;
                        case "Phone":
                            profile.setPhone(Long.parseLong(value));
                            break;
                        default:
                            // Ignore any unknown keys
                            break;
                    }
                }
            }
            return profile;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
