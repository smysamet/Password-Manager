package com.example.passwordmanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PasswordEntryManager {

    private static final String JSON_FILE_PATH = "src/main/resources/com/example/passwordmanager/";

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void savePasswordEntry(PasswordEntry passwordEntry) {
        File dataFile = new File(JSON_FILE_PATH + "data.json");
        List<PasswordEntry> passwordEntries = null;

        if (dataFile.exists() && !dataFile.isDirectory()) {
            try {
                passwordEntries = objectMapper.readValue(dataFile, new TypeReference<>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            passwordEntries = new ArrayList<>();
        }

        passwordEntries.add(passwordEntry);
        try {
            objectMapper.writeValue(dataFile, passwordEntries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
