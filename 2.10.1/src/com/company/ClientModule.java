package com.company;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientModule {
    public static void main(String[] args) {
        String indexOfStudent = StudentFinder.findStudentByIndex();
        List<Integer> possibleMarks = MarksMaker.perform();

        try {
            Socket socket = new Socket("localhost", 4242);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(indexOfStudent);

            try {
                Student studentToFind = (Student) objectInputStream.readObject();
                System.out.println("== Został znaleziony następujący student ==");
                System.out.println(studentToFind);

                studentToFind = MarkAdder.perform(possibleMarks, studentToFind);
                objectOutputStream.writeObject(studentToFind);
            } catch (ClassNotFoundException e) {
                e.getMessage();
            }
        } catch (EOFException e) {
            System.out.println("Nie znaleziono studenta o podanym numerze indeksu!");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
