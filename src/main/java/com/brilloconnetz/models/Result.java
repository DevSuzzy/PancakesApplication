package com.brilloconnetz.models;

public class Result {
    private int totalPancakesMade = 0;
    private int totalPancakesEaten = 0;
    private int totalOrdersNotMet = 0;
    private int totalWastedPancakes = 0;

    public Result(int totalPancakesMade, int totalPancakesEaten, int totalOrdersNotMet, int totalWastedPancakes) {
        this.totalPancakesMade = totalPancakesMade;
        this.totalPancakesEaten = totalPancakesEaten;
        this.totalOrdersNotMet = totalOrdersNotMet;
        this.totalWastedPancakes = totalWastedPancakes;
    }

    public Result() {
    }

    public int getTotalPancakesMade() {
        return totalPancakesMade;
    }

    public void setTotalPancakesMade(int totalPancakesMade) {
        this.totalPancakesMade = totalPancakesMade;
    }

    public int getTotalPancakesEaten() {
        return totalPancakesEaten;
    }

    public void setTotalPancakesEaten(int totalPancakesEaten) {
        this.totalPancakesEaten = totalPancakesEaten;
    }

    public int getTotalOrdersNotMet() {
        return totalOrdersNotMet;
    }

    public void setTotalOrdersNotMet(int totalOrdersNotMet) {
        this.totalOrdersNotMet = totalOrdersNotMet;
    }

    public int getTotalWastedPancakes() {
        return totalWastedPancakes;
    }

    public void setTotalWastedPancakes(int totalWastedPancakes) {
        this.totalWastedPancakes = totalWastedPancakes;
    }
}
