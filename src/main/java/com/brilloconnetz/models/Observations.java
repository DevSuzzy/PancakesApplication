package com.brilloconnetz.models;

public class Observations {

    /**
     *
     *
     * Observations:
     *
     *
     * The non-concurrent solution uses CompletableFuture and array structures to manage concurrent operations and collect results.
     * The concurrent solution is more concise and direct in modeling the problem.
     * The non-concurrent solution calculates the time elapsed for each slot, which is not present in the concurrent solution.
     * The concurrent solution tracks the number of pancakes ordered by each user, which is not present in the non-concurrent solution.
     * In summary, the concurrent solution is simpler and more direct in modeling the problem without using complex asynchronous constructs.
     * However, the non-concurrent solution provides more detailed time tracking and may be beneficial if precise timing information is required.
     **/
}

