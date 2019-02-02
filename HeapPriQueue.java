/**
 * Program 1
 *
 * HeapPriQueue Data Structure
 * cs 310
 * 07/30/18
 *
 * @author Youssef Iraqi , Brian Raffery
 */

package edu.sdsu.cs.datastructures;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapPriQueue<E extends Comparable<E>>implements IPriorityQueue<E> {
    private Comparator<E> order;
   private PriorityQueue<E> list;
    public HeapPriQueue(Comparator<E> order) {
        this.order = order;
        list = new PriorityQueue<E>(order);
    }

    public HeapPriQueue() {
         order = Comparator.naturalOrder();
        list = new PriorityQueue<E>(order);
    }

    @Override
    public Comparator<E> comparator() {

        return comparator();
    }


    @Override
    public void enqueue(E item) {
        list.add(item);
    }

    @Override
    public E poll() {

        return list.poll();
    }

    @Override
    public E peek() {
        return list.peek();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }


}
