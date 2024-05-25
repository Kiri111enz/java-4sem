package com.example.prac12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component(value = "deleter")
public class PostConstructFile {

    @PostConstruct
    public void init() {
        String firstPath = FilePathStorage.getFirstPath();
        String secondPath = FilePathStorage.getSecondPath();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(firstPath)));
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(secondPath), "utf-8"));
            writer.write(data.hashCode());
            reader.close();
            writer.close();
        } catch (IOException e) {
            try {
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(secondPath), "utf-8"));
                writer.write("null");
                writer.close();
            } catch (Exception er) {
                System.out.println("Вообще ничего не получилось");
            }
        }
    }

    @PreDestroy
    public void destroy() {
        String firstPath = FilePathStorage.getFirstPath();
        File fileToDelete = new File(firstPath);
        System.out.println(fileToDelete.delete());
    }
}
