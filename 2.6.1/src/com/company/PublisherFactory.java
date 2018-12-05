package com.company;

public class PublisherFactory {
    public static Publisher getInstance(String author) {
        if(author == "Józef Ignacy Kraszewski") return new HistoricPoemsPublisher ("Józef Ignacy Kraszewski");
        if(author == "Katarzyna Bonda") return new ThrillersPublisher("Katarzyna Bonda");
        if(author == "Henryk Sienkiewicz") return new PoemsPublisher("Henryk Sienkiewicz");
        return null;
    }
}