package com.brilloconnetz;

import com.brilloconnetz.models.NonConcurrentExecution;
import com.brilloconnetz.models.ConcurrentExecution;

import java.util.Scanner;

public class Main {
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