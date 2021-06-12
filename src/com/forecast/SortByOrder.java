package com.forecast;

import java.util.Comparator;
import java.util.List;

public class SortByOrder implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> IntegerList, List<Integer> t1) {
        return IntegerList.get(3) - t1.get(3);
    }
}
