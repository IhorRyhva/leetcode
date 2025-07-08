package LeetCode.oop;

import java.util.ArrayList;

public class Author {

    private String name;
    private ArrayList<Gender> genders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Gender> getGenders() {
        return genders;
    }

    public void setGenders(ArrayList<Gender> genders) {
        this.genders = genders;
    }
}
