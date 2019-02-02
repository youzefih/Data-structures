/**
 * CS310: Data Structures
 * San Diego State University
 * <p>
 *     INSTRUCTOR PROVIDED FILE. DO NOT MODIFY.
 * </p>
 * @author: Shawn Healey
 */
package edu.sdsu.cs.datastructures;

public interface IQueue<E> extends Iterable<E> {

    /**
     * Inserts the provided item into the queue
     * <p>
     * Complexity: O(1) desired
     *
     * @param item the object to store in the queue
     */
    void enqueue(E item);


    /**
     * Removes and returns the highest priority item in the queue.
     * <p>
     * Complexity: O(1) desired
     *
     * @return The item of highest priority in the queue.
     */
    E poll();


    /**
     * Retrieves the next item in the queue without removing it or altering the
     * queue's contents.
     * <p>
     * Complexity: O(1) desired
     *
     * @return The item at the head of the queue
     */
    E peek();


    /**
     * Provides a count of the number of items stored in the queue.
     * <p>
     * Complexity: O(1) required
     *
     * @return A non-negative integer representing the item count.
     */
    int size();


    /**
     * Resets the queue to an empty state.
     */
    void clear();

    /**
     * Indicates if the queue contains zero elements.
     *
     * @return <tt>true</tt> if the queue is empty, <tt>false</tt> otherwise.
     */
    boolean isEmpty();
}
