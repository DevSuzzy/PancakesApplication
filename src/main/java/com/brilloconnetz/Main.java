package com.brilloconnetz;

import com.brilloconnetz.service.NonConcurrentExecution;
import com.brilloconnetz.service.ConcurrentExecution;

import java.util.Scanner;

public class Main {


    /** this Class is used to initialize a program that has a concurrent and non-current solution
     *
     * Observations:
     *
     * The non-concurrent solution uses CompletableFuture and array structures to manage concurrent
     * operations and collect results.
     *
     * The non-concurrent solution is more concise and direct in modeling the problem.
     * In summary, the non-concurrent solution offers a straightforward and simplified approach to modeling
     * the problem without the need for complex asynchronous constructs. On the other hand, the concurrent
     * solution is slower due to its presence of blocking operations.
     *
     **/

    public static void main(String[] args) {
        executeProgram();
    }

    private static void executeProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello world! Welcome to Sussy's Pancake shop");

        int slot = getNumberOfSlot(scanner);

        int algorithm = getAlgorithm(scanner);

        if (algorithm == 1) {
            new NonConcurrentExecution().execute(slot);
        }

        if (algorithm == 2) {
            new ConcurrentExecution().execute(slot);
        }

    }

    private static int getAlgorithm(Scanner scanner) {
        System.out.println("Please choose an algorithm: \n1. Concurrent\n2. Non Concurrent");
        return scanner.nextInt();
    }

    private static int getNumberOfSlot(Scanner scanner) {
        System.out.println("Please choose a slot from 1 to 100?");
        int slot = scanner.nextInt();
        if (slot < 1 || slot > 100) {
            System.out.println("Only slot from one to 100 is allowed");
            System.exit(0);
        }
        return slot;
    }
}