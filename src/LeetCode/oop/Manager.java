package LeetCode.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Manager {

    public static void main(String[] args) {
        Manager manager = new Manager();
        HashMap<Author, ArrayList<Book>> data = manager.generate();
        List<Gender> genders = Arrays.asList(Gender.FANTASY, Gender.SCIENCE_FICTION, Gender.MYSTERY);
        List<Book> test = manager.sort("Molodec", genders, 2022, data);
        for(Book book: test){
            System.out.println(book.getName());
            System.out.println(book.getAuthor().getName());
            System.out.println(book.getYearOfPublic());
            for(Gender gender: book.getGenders()){
                System.out.println(gender);
            }
            System.out.println("__________________________________________");
        }
        Book book = getBookByName("LalaTopovi2", data);
        System.out.println(book.getName());
        System.out.println(book.getAuthor().getName());
    }

    private static Book getBookByName(String nameOfBook, HashMap<Author, ArrayList<Book>> data) {
        Book result = null;
        for(List<Book> books: data.values()){
            for(Book book: books){
                if(book.getName().equals(nameOfBook)){
                    result = book;
                    break;
                }
            }
            if(result != null) break;
        }
        if(result == null){
            throw new RuntimeException();
        }
        return result;
    }

    private List<Book> sort(String authorName, List<Gender> sortGenders, int yearOfPublic, HashMap<Author, ArrayList<Book>> data){
        ArrayList<Book> result = new ArrayList<>();
        Author key = getAuthor(authorName, data);
        if(key == null){
            throw new RuntimeException();
        }

        for(Book book: data.get(key)){
            boolean fitGender = containsGender(book.getGenders(), sortGenders);
            boolean fitYear = book.getYearOfPublic() == yearOfPublic;

            if(fitGender || fitYear){
                result.add(book);
            }
        }
        return result;
    }

    private boolean containsGender(List<Gender> genders, List<Gender> sortGenders) {
        for(Gender gender: genders){
            if(sortGenders.contains(gender)){
                return true;
            }
        }
        return false;
    }


    private Author getAuthor(String authorName, HashMap<Author, ArrayList<Book>> data) {
        Author key = null;
        for(Author author: data.keySet()){
            if(authorName.equals(author.getName())){
                key = author;
                break;
            }
        }
        return key;
    }


    private HashMap<Author, ArrayList<Book>> generate(){
        Author author1 = new Author();
        author1.setGenders(gendersForAuthor());
        author1.setName("Molodec");

        Author author2 = new Author();
        author2.setGenders(gendersForAuthor());
        author2.setName("Krasava");

        Author author3 = new Author();
        author3.setGenders(gendersForAuthor());
        author3.setName("Topovi");

        HashMap<Author, ArrayList<Book>> result = new HashMap<>();
        result.put(author1, bookList(author1));
        result.put(author2, bookList(author2));
        result.put(author3, bookList(author3));

        return result;
    }

    private ArrayList<Gender> gendersForAuthor(){
        List<Gender> genders = Arrays.asList(Gender.FANTASY, Gender.SCIENCE_FICTION, Gender.MYSTERY, Gender.THRILLER, Gender.HORROR, Gender.ROMANCE, Gender.HISTORICAL_FICTION, Gender.ADVENTURE, Gender.DYSTOPIAN, Gender.CRIME, Gender.BIOGRAPHY, Gender.AUTOBIOGRAPHY, Gender.MEMOIR, Gender.NON_FICTION, Gender.CLASSICS, Gender.YOUNG_ADULT, Gender.CHILDREN, Gender.POETRY, Gender.DRAMA, Gender.COMEDY, Gender.SELF_HELP, Gender.PHILOSOPHY, Gender.SPIRITUALITY, Gender.GRAPHIC_NOVEL, Gender.SHORT_STORIES, Gender.LITERARY_FICTION, Gender.CONTEMPORARY, Gender.PARANORMAL, Gender.FANFICTION, Gender.WAR, Gender.POLITICAL_FICTION, Gender.URBAN);
        int mathRandom = ThreadLocalRandom.current().nextInt(0, 32);
        ArrayList<Gender> authorsGender = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if(!authorsGender.contains(genders.get(mathRandom))){
                authorsGender.add(genders.get(mathRandom));
            }
            mathRandom = ThreadLocalRandom.current().nextInt(0, 32);
        }
        return authorsGender;//
    }

    private ArrayList<Book> bookList(Author author){
        ArrayList<Gender> authorsGender = author.getGenders();
        int randomGender = ThreadLocalRandom.current().nextInt(0, authorsGender.size());
        int year = 2019;
        ArrayList<Book> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            ArrayList<Gender> genders = new ArrayList<>();
            setData(author, book, year, randomGender, i, genders, authorsGender);
            result.add(book);
        }
        return result;
    }

    private void setData(Author author, Book book, int year, int randomGender, int i, ArrayList<Gender> genders, ArrayList<Gender> authorsGender) {
        book.setAuthor(author);
        book.setYearOfPublic(year + randomGender);
        book.setName("Lala" + author.getName() + i);
        for (int j = 0; j < 3; j++) {
            if(!genders.contains(authorsGender.get(randomGender))){
                genders.add(authorsGender.get(randomGender));
            }
            randomGender = ThreadLocalRandom.current().nextInt(0, authorsGender.size());
        }
        book.setGenders(genders);
    }
}
