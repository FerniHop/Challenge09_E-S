package org.example;

import java.io.*;

public class PersonReader {
    private final BufferedReader reader;

    public PersonReader(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    public Person readPerson() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            return null; // Fin du fichier
        }
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IOException("Format de ligne invalide");
        }
        String firstName = parts[0];
        String lastName = parts[1];
        int age = Integer.parseInt(parts[2]);
        return new Person(firstName, lastName, age);
    }

    public void close() throws IOException {
        reader.close();
    }
}
