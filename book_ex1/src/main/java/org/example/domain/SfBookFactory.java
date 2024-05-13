package org.example.domain;

public class SfBookFactory {
    public int count = 0;

    public SfBookFactory() {
    }

    public Book createSfBook(String author, String name, int pageNumber) {
        String category = "Science-fiction";
        String code = "SF-" + (++count);

        return new Book(author, name, pageNumber, category, code);
    }
}
