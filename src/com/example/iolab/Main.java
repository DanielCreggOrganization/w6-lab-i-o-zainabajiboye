package com.example.iolab;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java I/O!");

        // Get the project's root directory
        Path projectRoot = Paths.get(System.getProperty("user.dir"));

        // Construct the path to input.txt
        Path inputFilePath = projectRoot.resolve("resources").resolve("input.txt");

        // check if file exists
        if (Files.exists(inputFilePath)) {
            System.out.println("input.txt found at: " + inputFilePath.toAbsolutePath());
        } else {
            System.out.println("input.txt not found! ");
        }
        // This reads the code from input.txt using FileInputStream with
        // try-catch-finally.
        String filePath = "resources/input.txt";
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filePath);
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
        //This adds a feature to convert all text to uppercase when writing to the output file.
        String inputPath = "resources/input.txt";
        String outputPath = "resource/output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            int data;
            int count = 0;
            while ((data = fis.read()) != -1) {
                fos.write(data);
                count ++;
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
          try (FileReader reader = new FileReader(inputPath);
             FileWriter writer = new FileWriter(outputPath)) {
            
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toUpperCase((char) character));
            }
            System.out.println("File copied and converted to uppercase.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        }
        }

    

