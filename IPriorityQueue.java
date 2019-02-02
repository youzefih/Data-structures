/**
 * CS310: Data Structures
 * San Diego State University
 * <p>
 *     INSTRUCTOR PROVIDED FILE. DO NOT MODIFY.
 * </p>
 * @author: Shawn Healey
 */
package edu.sdsu.cs.datastructures;

import java.util.Comparator;

/**
 * Simplified priority queue interface; it provides the core ADT functionality.
 * <p>
 * Implementing classes should provide two constructors: <ul><li>a default
 * constructor, which takes zero parameters and uses a default Comparator</li>
 * <li>a single parameter constructor which accepts a <tt>Comparator</tt>
 * object.</li></ul>
 * <br>
 * The <tt>IPriorityQueue</tt> will either rank items in the array as they enter
 * or upon a removal request. In either event, the item returned by the queue
 * after a dequeue operation <i>must</i> rank equal to or lower (per the
 * internal <tt>Comparator</tt>) than every existing item in the queue.
 * <br><br>
 * Items with identical priority must exit the queue per traditional F-I-F-O
 * behavior to ensure stability. Thus, were everything entering the queue of
 * equal priority, then the items shall exit in precisely that order. This holds
 * true for sub-sequences of identical priority within the queue. Everything of
 * identical priority must exit the queue in their original insertion order.
 */
public interface IPriorityQueue<E> extends IQueue<E> {

    /**
     * Provides the caller with the <tt>Comparator</tt> object used by the
     * priority queue when ranking internal elements.
     * @return The <tt>Comparator</tt> currently in use
     */
    Comparator<E> comparator();

}
