/**
 * Program 1
 *
 * UnorderedPriQueue Data Structure
 * cs 310
 * 07/30/18
 *
 * @author Youssef Iraqi , Brian Raffery
 */
package edu.sdsu.cs.datastructures;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class UnorderedPriQueue<E extends Comparable<E>>  implements IPriorityQueue<E> {
    private ArrayList<E> list = new ArrayList<E>();
    private Comparator<E> order;

    public UnorderedPriQueue(Comparator<E> order) {
        this.order = order;
    }
    public UnorderedPriQueue() {
        order = Comparator.naturalOrder();
    }

    @Override
    public Comparator<E> comparator() {
        return order;
    }

    @Override
    public void enqueue(E item) {

        list.add(list.size(), item);
    }

    /**
     *
     *  iterates through the list and adds element to the end.
     * @param ArrayList <E> List
     * @return E
     * */
    private E sequentialSearch(ArrayList<E> list) {
        E max = list.get(0);
        for (int i = 0; i < list.size(); i++) {

            int result = order.compare(max ,list.get(i));
            if (result > 0) {
                max = list.get(i);
            }
        }
        list.remove(max);
        return max;
    }

    @Override
    public E poll() {
        if (list.size() == 0) {
            return null;
        }
        return sequentialSearch(list);
    }

    @Override
    public E peek() {
        if (list.size() == 0) {
            return null; }
        return list.get(list.size() - 1);
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