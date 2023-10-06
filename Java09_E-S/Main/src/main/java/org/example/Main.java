package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Créez une liste de personnes
            List<Person> team = new ArrayList<>();
            team.add(new Person("Test1", "Test1", 30));
            team.add(new Person("Test2", "Test2", 25));

            // Écriture de la liste de personnes dans un fichier texte .txt
            FileWriter fileWriter = new FileWriter("team.txt");
            PersonWriter personWriter = new PersonWriter(fileWriter);
            for (Person person : team) {
                personWriter.writePerson(person);
            }
            personWriter.close();

            // Lecture de la liste de personnes depuis le fichier texte .txt
            FileReader fileReader = new FileReader("team.txt");
            PersonReader personReader = new PersonReader(fileReader);
            List<Person> loadedTeam = new ArrayList<>();
            Person person;
            while ((person = personReader.readPerson()) != null) {
                loadedTeam.add(person);
            }
            personReader.close();

            // Affichage des personnes chargées depuis le fichier
            for (Person loadedPerson : loadedTeam) {
                System.out.println(loadedPerson);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
