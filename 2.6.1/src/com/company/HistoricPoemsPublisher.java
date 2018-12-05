package com.company;

public class HistoricPoemsPublisher implements Publisher {
    private String type;
    private String author;

    public HistoricPoemsPublisher(String author) {
        this.type = "Powieść historyczna";
        this.author = author;
    }

    @Override
    public HistoricPoem createBook(String title, int numberOfPages) {
        return new HistoricPoem(type, author, title, numberOfPages);
    }
}