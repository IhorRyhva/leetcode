package LeetCode.oop;

import java.util.List;

public class Book {
    private String name;
    private Integer yearOfPublic;
    private Author author;
    private List<Gender> genders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfPublic() {
        return yearOfPublic;
    }

    public void setYearOfPublic(Integer yearOfPublic) {
        this.yearOfPublic = yearOfPublic;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }
}
