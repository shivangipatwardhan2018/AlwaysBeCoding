package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a graph of persons. Each node in the graph is of type class
 * person (see below). Each person is connected to their parents.
 *
 * Two persons A and B are defined to be blood relatives if they share atleast
 * one ancestor. Write a method to check if any two persons A and B in a graph
 * are blood relatives.
 */


class Person{

    List<Person> parents = new ArrayList<>();
    List<Person> children = new ArrayList<>();

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }
}

public class BloodRelatives {


    public boolean areBloodRelatives(Person A, Person B){


        return false;
    }

}
