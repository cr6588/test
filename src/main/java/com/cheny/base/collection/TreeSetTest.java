package com.cheny.base.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest implements Comparable {
    public String username = "";

    public TreeSetTest(String username) {
        this.username = username;
    }

    public static void main(String args[]) {
        Set<String> set = new TreeSet<>();
        set.add("abc");
        set.add("x");
        set.add("d");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        Set<TreeSetTest> TreeSetTests = new TreeSet<>();
        TreeSetTests.add(new TreeSetTest("username3"));
        TreeSetTests.add(new TreeSetTest("username2"));
        TreeSetTests.add(new TreeSetTest("username1"));
        Iterator<TreeSetTest> its = TreeSetTests.iterator();
        while (its.hasNext()) {
            System.out.println(its.next().username);
        }

        System.out.println("Sasdf".compareTo("S") + " " +  "Sasdf".length() +  "_" + "S".length());

    }

    @Override
    public int compareTo(Object o) {
        TreeSetTest t = (TreeSetTest) o;
        return this.username.compareTo(t.username);
    }
}
