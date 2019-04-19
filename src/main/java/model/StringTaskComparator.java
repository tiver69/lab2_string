package model;

import service.RegularExpressionFilter;

import java.util.Comparator;

public class StringTaskComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1 == null || o2 ==null) throw new NullPointerException("Word is empty");
        String fromConsonantO1 = RegularExpressionFilter.firstConsonantWord(o1);
        String fromConsonantO2 = RegularExpressionFilter.firstConsonantWord(o2);
        return (fromConsonantO1.compareTo(fromConsonantO2));
    }
}
