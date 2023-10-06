package org.example;

import java.io.*;

public class PersonWriter {
    private final BufferedWriter writer;

    public PersonWriter(Writer writer) {
        this.writer = new BufferedWriter(writer);
    }

    public void writePerson(Person person) throws IOException {
        writer.write(person.toString());
        writer.newLine();
        writer.flush();
    }

    public void close() throws IOException {
        writer.close();
    }
}
