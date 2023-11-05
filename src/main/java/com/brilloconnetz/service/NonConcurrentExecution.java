package com.brilloconnetz.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class NonConcurrentExecution {

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

    private void run() {
        try {
            AtomicInteger shopkeeperPancakes = new AtomicInteger();

            int[] userPancakes = new int[3];
            int[] userPancakesEaten = new int[3];

            int unmetUserRequests = 0;
            int wastedPancakes = 0;

            CompletableFuture<Integer> shopkeeperProducedFuture = CompletableFuture.supplyAsync(() -> {
                int shopkeeperProduced = new Random().nextInt(12);
                shopkeeperPancakes.addAndGet(shopkeeperProduced);
                return shopkeeperProduced;
            });

            CompletableFuture[] userRequestsFutures = new CompletableFuture[3];
            for (int i = 0; i < 3; i++) {
                int finalI = i;
                userRequestsFutures[i] = CompletableFuture.supplyAsync(() -> {
                    int userRequests = new Random().nextInt(6);
                    userPancakes[finalI] += userRequests;
                    return userRequests;
                });
            }

            CompletableFuture<Void> allOf = CompletableFuture.allOf(userRequestsFutures);
            allOf.get();

            int shopkeeperProduced = shopkeeperProducedFuture.get();

            if (shopkeeperProduced < userPancakes[0] + userPancakes[1] + userPancakes[2]) {
                unmetUserRequests += userPancakes[0] + userPancakes[1] + userPancakes[2] - shopkeeperProduced;
            }

            if (shopkeeperProduced > userPancakes[0] + userPancakes[1] + userPancakes[2]) {
                wastedPancakes += shopkeeperProduced - userPancakes[0] - userPancakes[1] - userPancakes[2];
            }

            int[] userRequests = new int[3];
            for (int i = 0; i < 3; i++) {
                userRequests[i] = (int) userRequestsFutures[i].get();
            }

            for (int i = 0; i < 3; i++) {
                int userEaten = Math.min(userPancakes[i], 5);
                userPancakesEaten[i] = userEaten;
                userPancakes[i] -= userEaten;
            }

            System.out.println("Shopkeeper made " + shopkeeperPancakes + " pancakes.");
            System.out.println("User 1 ordered: " + userRequests[0]);
            System.out.println("User 2 ordered: " + userRequests[1]);
            System.out.println("User 3 ordered: " + userRequests[2]);
            System.out.println("Pancakes eaten: " + Arrays.stream(userPancakesEaten).sum());
            System.out.println("Pancakes wasted: " + wastedPancakes);
            System.out.println("Orders not met: " + unmetUserRequests);
            System.out.println();


        } catch (Exception e) {
            System.out.println("An error occurred while processing");
        }

    }
}
