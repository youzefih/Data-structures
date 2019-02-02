/**
 *
 * Program 1
 *
 * ArrayPriQueue Data Structure
 * cs 310
 * 07/30/18
 * @author Youssef Iraqi , Brian Raffery
 */


package edu.sdsu.cs.datastructures;



import java.util.ArrayList;

import java.util.Comparator;
import java.util.Iterator;


public class ArrayPriQueue<E extends Comparable<E>> implements IPriorityQueue<E>  {
    private ArrayList<E> list = new ArrayList();
    private int curSize = 0;
    private Comparator<E>  order;


    public ArrayPriQueue (Comparator<E> order) {
        this.order = order;
    }
    public ArrayPriQueue(){
        order = Comparator.naturalOrder();
    }

    @Override
    public Comparator<E> comparator() {
        return order;
    }
    @Override
    public void enqueue(E item) {
        int index = binarySearch(item, 0, curSize-1);
            list.add(index, item);
        curSize++;

    }

    /**
     *  Finds the input location and adds it to the List
     * @param E obj, lo , hi (object to be inserted, lowest object index, highest object index)
     * @return int (Index on the list in which it will be put.)
     * */
    private int binarySearch( E obj,int lo,int hi) {

        if (hi < lo) return lo;
        int mid = (lo + hi) >> 1;
        int result = order.compare(obj,list.get(mid));
        if (result >= 0) return binarySearch(obj, lo, mid-1);  //go right
        return binarySearch(obj, mid+1, hi);
    }

    @Override
    public E poll() {

        if(list.size() == 0) {
            return null;
        }

        return list.remove(list.size()-1);
    }

    @Override
    public E peek() {
        if(list.size() == 0)
            return null;
        return list.get(list.size()-1);

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
        if(list.size() ==0 ) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return list.iterator();
    }


}