package benchmark.sort;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public abstract class SortAlgorithm {

    private static final List<Integer> SIZES = List.of(
            10_000,
            50_000,
            100_000
    );

    public abstract String getName();

    protected abstract void sort(List<Integer> input);

    public void execute(int times) {
        SIZES.forEach(size -> {
            long msTotal = 0;

            for (int i = 1; i <= times; i++) {
                SecureRandom random = new SecureRandom();

                var numbers = IntStream.rangeClosed(1, size)
                        .map(it -> random.nextInt(0, Integer.MAX_VALUE))
                        .boxed()
                        .toList();

                System.out.printf("[%s - %s] #%s - Executing... %n", getName(), size, i);

                var now = System.currentTimeMillis();

                sort(new ArrayList<>(numbers));

                var executionMs = System.currentTimeMillis() - now;

                System.out.printf("[%s - %s] #%s - Executed: %s %n", getName(), size, i, executionMs);

                msTotal += executionMs;
            }
            var avg = msTotal / times;

            System.out.printf("[%s - %s] Average: %s %n%n", getName(), size, avg);
        });

    }

}
