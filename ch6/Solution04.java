package ch6;

public class Solution04 {
    /**
     * Answer:
     * There are only two ways that the ants are not collided, either they all move in clockwise direction in counterclockwise
     *
     * For a triangle -
     *  P(collision) = 1 - P(move in the same direction) = 1 - 2 * (1/2) ^ 3 = 3/4
     *
     * For a n - polygon -
     *  P(collision) = 1 - P(move in the same direction) = 1 - 2 * (1/2) ^ n = 1 - (1/2) ^ (n - 1)
     * */
}
