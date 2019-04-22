package model;

import service.RegularExpressionFilter;

import java.util.Comparator;

/**
 * Comparator implementation for TreeSet constructor
 */
public class StringTaskComparator implements Comparator<String> {

    /**
     * Compare two string by first consonant letter
     * @param o1 string variable which is up to add in Collection
     * @param o2 string variable from collection
     * @return int value 1 if variable from collection is 'lesser', 0 - if variables are equals,
     * -1 - if variable from collection is 'bigger'
     */
    @Override
    public int compare(String o1, String o2) {
        if (o1 == null || o2 ==null) throw new NullPointerException("Word is empty");
        if (o1.equals(o2)) return 0;
        String fromConsonantO1 = RegularExpressionFilter.firstConsonantWord(o1);
        String fromConsonantO2 = RegularExpressionFilter.firstConsonantWord(o2);
        int compareResult = fromConsonantO1.compareTo(fromConsonantO2);
        if (compareResult == 0) return -1;
        else return compareResult;
    }
}
