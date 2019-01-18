package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerModule {
    public static void main(String[] args) {
        Student[] students = MockStudentMaker.perform();
        MockStudentMaker.printListOfStudents(students);

        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            try {
                Socket socket = serverSocket.accept();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                String indexToFind = (String) objectInputStream.readObject();
                boolean isIndexFound = false;

                int i = 0, j = 0;
                for (Student student : students) {
                    if (student.getIndex().equals(indexToFind)) {
                        objectOutputStream.writeObject(student);
                        isIndexFound = true;
                        j = i;
                    }
                    i++;
                }

                if (!isIndexFound) {
                    System.out.println("Nie znaleziono studenta o podanym numerze indeksu!");
                } else {
                    students[j] = (Student) objectInputStream.readObject();
                }

                printStudentsAfterAddedMark(students);

            } catch (ClassNotFoundException e) {
                e.getMessage();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void printStudentsAfterAddedMark(Student[] students) {
        System.out.println();
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
