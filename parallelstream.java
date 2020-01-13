import java.util.stream.IntStream;
import java.util.stream.Stream;

public class parallelstream {

    public static void main(String[] args){
//        System.out.println("Normal...");
//        long startTime = System.nanoTime();
//        IntStream range = IntStream.rangeClosed(1, 10);
//        range.forEach(System.out::println);
//        long endTime = System.nanoTime();
//
//        System.out.println("Parallel...");
//        long startparalleltime = System.nanoTime();
//
//        IntStream range2 = IntStream.rangeClosed(1, 10);
//        range2.parallel().forEach(System.out::println);
//        long endparalleltime = System.nanoTime();
//
//        System.out.println("Normal Time is " + ( endTime - startTime));
//        System.out.println("Parallel Time is " + ( endparalleltime - startparalleltime));
        long startTime = System.nanoTime();
        long count = Stream.iterate(0, n -> n + 1)
                .limit(1000000)
                //.parallel()   with this 23s, without this 1m 10s
                .filter(parallelstream::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);
            long endTime = System.nanoTime();
            long startparalleltime = System.nanoTime();
        long countparallel = Stream.iterate(0, n -> n + 1)
                .limit(1000000)
                .parallel()
                .filter(parallelstream::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + countparallel);
        long endparalleltime = System.nanoTime();

        System.out.println("Normal Time is " + ( endTime - startTime));
        System.out.println("Parallel Time is " + ( endparalleltime - startparalleltime));


    }
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }
}
