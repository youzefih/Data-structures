/**
 * Program 1
 *
 *  Program conducts timing tests on three
 *  data structures, including: a heap priority
 *  queue, an ordered priority queue, and an
 *  unordered priority queue. The tests are ran
 *  by creating random elements and filling the
 *  data structures in increasing test sizes,
 *  going from 50,000 up to 200,000.
 *  The times for offering and polling from the
 *  data structures are recorded and printed to both
 *  the console and a text file called 'output.txt'
 *
 * cs 310
 * 07/30/18
 *
 * @author Youssef Iraqi , Brian Raffery
 */

package edu.sdsu.cs;
import edu.sdsu.cs.datastructures.ArrayPriQueue;
import edu.sdsu.cs.datastructures.HeapPriQueue;
import edu.sdsu.cs.datastructures.UnorderedPriQueue;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class App<E> {
    private DecimalFormat formatOutput = new DecimalFormat("###.###");
    private double offerTime;
    private double pollTime;
    private Random randomElementBuilder = new Random(99999);
    private int testSize = 50000;
    private int resetTestSize = testSize;


    public static void main(String[] args) {
        App run = new App();
        System.out.print(run.runnerApp());

    }
    /**
     *  Tests out the unorderedPriQueue using Random Integers.
     *  3 tests: 50,000 elements ,  100, 000 elements and 200,000 elements.
     * @param
     * @return void
     * */
    private void unorderedPriQueueTest() {

        testSize = resetTestSize;
        String[] pop = new String[3];
        for (int j = 0; j < 3; j++) {
            UnorderedPriQueue Queue = new UnorderedPriQueue(Comparator.naturalOrder());
            double temp1 = System.nanoTime();
            for (int i = 0; i < testSize; i++) {
                Queue.enqueue(randomElementBuilder.nextInt());
            }
            offerTime = (System.nanoTime() - temp1) / (Math.pow(10, 6));
            offerTime = Double.valueOf(formatOutput.format(offerTime));
            writeToTxt("Elapsed offer time with an array size of " + testSize + ":  " + offerTime + "ms");

            temp1 = System.nanoTime();
            while (Queue.isEmpty() == false) {
                Queue.poll();
            }
            pollTime = (System.nanoTime() - temp1) / (Math.pow(10, 6));
            pollTime = Double.valueOf(formatOutput.format(pollTime));
            pop[j] = "Elapsed poll time with an array size of " + testSize + ":  " + pollTime + "ms";
            Queue.clear();
            testSize = testSize * 2;

        }
        writeToTxt("\n");
        for (int i = 0; i < 3; i++) {
            writeToTxt(pop[i]);
        }

    }

    /**
     *  Tests out the arrayPriQueue using Random Integers.
     *  3 tests: 50,000 elements ,  100, 000 elements and 200,000 elements.
     * @param
     * @return void
     * */
    private void arrayPriQueueTest() {

        testSize = resetTestSize;
        String[] pop = new String[3];
        for (int j = 0; j < 3; j++) {

            ArrayPriQueue Queue = new ArrayPriQueue(Comparator.naturalOrder());
            double temp1 = System.nanoTime();
            for (int i = 0; i < testSize; i++) {
                Queue.enqueue(randomElementBuilder.nextInt());
            }
            offerTime = (System.nanoTime() - temp1) / (Math.pow(10, 6));
            offerTime = Double.valueOf(formatOutput.format(offerTime));
            writeToTxt("Elapsed offer time with an array size of " + testSize + ":  " + offerTime + "ms");

            temp1 = System.nanoTime();
            while (Queue.isEmpty() == false) {
                Queue.poll();
            }

            pollTime = (System.nanoTime() - temp1) / (Math.pow(10, 6));
            pollTime = Double.valueOf(formatOutput.format(pollTime));
            pop[j] = "Elapsed poll time with an array size of " + testSize + ":  " + pollTime + "ms";
            Queue.clear();
            testSize = testSize * 2;

        }
        writeToTxt("\n");
        for (int i = 0; i < 3; i++) {
            writeToTxt(pop[i]);
        }
    }

    /**
     *  Tests out the heapPriQueueTest using Random Integers.
     *  3 tests: 50,000 elements ,  100, 000 elements and 200,000 elements.
     * @param
     * @return void
     * */
    private void heapPriQueueTest() {
        String[] pop = new String[3];
        for (int j = 0; j < 3; j++) {

            HeapPriQueue Queue = new HeapPriQueue(Comparator.naturalOrder());
            double temp1 = System.nanoTime();
            for (int i = 0; i < testSize; i++) {
                Queue.enqueue(randomElementBuilder.nextInt());
            }
            offerTime = (System.nanoTime() - temp1) / (Math.pow(10, 6));
            offerTime = Double.valueOf(formatOutput.format(offerTime));
            writeToTxt("Elapsed offer time with an array size of " + testSize + ":  " + offerTime + "ms");

            temp1 = System.nanoTime();
            while (Queue.isEmpty() == false) {
                Queue.poll();
            }
            pollTime = (System.nanoTime() - temp1) / (Math.pow(10, 6));
            pollTime = Double.valueOf(formatOutput.format(pollTime));
            pop[j] = "Elapsed poll time with an array size of " + testSize + ":  " + pollTime + "ms";
            Queue.clear();
            testSize = testSize * 2;
        }
        writeToTxt("\n");
        for (int i = 0; i < 3; i++) {
            writeToTxt(pop[i]);
        }
    }

    /**
     *  This method writes out all of the data collected in a .txt file
     * @param  data to be written in "output.txt" .
     * @return void
     * */

    private void writeToTxt(String data) {
        try {
            FileWriter fr = new FileWriter("./output.txt", true);
            fr.write(data + "\n");
            fr.close();
        } catch (IOException e1) {

            e1.printStackTrace();
        }

    }

    /**
     *  This method clears the "output.txt" everytime the program is ran.
     * @param
     * @return void
     * */
    private void clearTxt() {
        try {
            FileWriter fr = new FileWriter("./output.txt", false);
        } catch (IOException e1) {

            e1.printStackTrace();
        }
    }

    /**
     *  This method tests out all of the elements in the 3 Data Structures.
     * @param
     * @return void
     * */

    private void testing() {
        HeapPriQueue test = new HeapPriQueue();

        test.enqueue(2);
        test.enqueue(1);
        test.enqueue(3);
        test.enqueue(5);

        for (int i = 0; i < 5; i++) {
            System.out.print(test.poll() + " ");
        }


    }


    /**
     *  This method runs all of the other test methods, follows OOP guidelines.
     * @param
     * @return "Complete!" (if the tests were successfully completed.)
     * */

    private String runnerApp() {
        clearTxt();
        writeToTxt("\n* Program 1\n* cs310\n* 7/30/18\n* @author Youssef Iraqi, Brian Rafferty ");
        writeToTxt("\n\n Heap Priority Test:\n \n");
        heapPriQueueTest();
        writeToTxt("\n\n Array Priority Queue  Test: \n \n");
        arrayPriQueueTest();
        writeToTxt("\n\n Unordered priority Queue Test: \n \n");
        unorderedPriQueueTest();
       // testing();
        printToConsole();
        writeToTxt("\nComplete!\n");

        return "\n\nComplete!";
    }

    /**
     *  This method scans the file "output.txt" and prints the contents to the console
     * @param
     * @return void
     * */
    private void printToConsole() {
        try {
            File file = new File("./output.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (IOException E) {
            E.printStackTrace();
        }


    }


}