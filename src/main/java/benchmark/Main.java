package benchmark;

import benchmark.sort.impl.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final var algorithms = List.of(
                new BubbleSort(),
                new ImprovedBubbleSort(),
                new QuickSort(),
                new InsertionSort(),
                new ShellSort(),
                new SelectionSort(),
                new HeapSort(),
                new MergeSort(),
                new RadixSort(),
                new CountingSort(),
                new BucketSort()
        );

        algorithms.forEach(algorithm -> algorithm.execute(10));
    }

}