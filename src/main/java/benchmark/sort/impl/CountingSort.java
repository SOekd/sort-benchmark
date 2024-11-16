package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.Collections;
import java.util.List;

public final class CountingSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Counting Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
    }
}
