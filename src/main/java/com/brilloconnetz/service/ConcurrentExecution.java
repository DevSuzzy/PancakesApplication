package com.brilloconnetz.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class ConcurrentExecution {

    public void execute(int slot) {
        LocalDateTime startTime = LocalDateTime.now();

        for (int i = 1; i <= slot; i++) {
            run();
            System.out.println();
        }

        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);

        System.out.printf("Starting time for 30 seconds slot %s%n",  startTime);
        System.out.printf("Ending time for 30 seconds slot %s%n", endTime);
        System.out.println("Total Elapsed time for " + slot + " slot: " + duration.toMillis() + " milliseconds");
        System.out.println();

    }
    public void run() {

        Random random = new Random();

        int shopkeeperPancakes = random.nextInt(12) + 1;
        int user1Pancakes = random.nextInt(5) + 1;
        int user2Pancakes = random.nextInt(5) + 1;
        int user3Pancakes = random.nextInt(5) + 1;

        int totalPancakesRequested = user1Pancakes + user2Pancakes + user3Pancakes;

        int pancakesEaten = Math.min(totalPancakesRequested, shopkeeperPancakes);
        int pancakesWasted = Math.max(0, shopkeeperPancakes - totalPancakesRequested);
        int ordersNotMet = totalPancakesRequested - pancakesEaten;

        System.out.println("Shopkeeper made " + shopkeeperPancakes + " pancakes.");
        System.out.println("User 1 ordered: " + user1Pancakes);
        System.out.println("User 2 ordered: " + user2Pancakes);
        System.out.println("User 3 ordered: " + user3Pancakes);
        System.out.println("Pancakes eaten: " + pancakesEaten);
        System.out.println("Pancakes wasted: " + pancakesWasted);
        System.out.println("Orders not met: " + ordersNotMet);
        System.out.println();

    }


}
