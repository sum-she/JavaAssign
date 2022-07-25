import java.util.*;

import static java.util.Collections.addAll;

public class Assignment4 {
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.revArrList();

        Swap swap = new Swap();
        swap.swapArrList();

        Replace replace = new Replace();
        replace.itLinkList();
        replace.repLinkList();

        Convert convert = new Convert();
        convert.hashToArr();
    }
}     

/* i)Write a Java program to reverse elements in a array list? */
class Reverse {
    //attribute
    ArrayList<Integer> revList;
    ArrayList<Integer> newList;

    public void revArrList() {

        //ArrayList using Collection
        revList = new ArrayList<>();
        newList = new ArrayList<>();
        addAll(revList, 7, 1, 2, 5, 8, 9, 3);

        int n = revList.size() - 1;

        for (int i = n; i >= 0; i--) {
            newList.add(n - i, revList.get(i));
        }
        System.out.println("Original list: " + this.revList +
                "\nReversed list: " + newList);
    }
}

/* ii) Write a Java program of swap two elements in an array list? */
class Swap {
    ArrayList<String> swapList;
    ArrayList<String> cloneList;

    public void swapArrList() {

        swapList = new ArrayList<>();
        swapList.add("Asch");
        swapList.add("Rawan");
        swapList.add("Pot");

        System.out.println("\nOriginal list: " + swapList);
        //clone original list
        cloneList = (ArrayList<String>) swapList.clone();
        swapList.set(0, swapList.get(2));
        swapList.set(2, cloneList.get(0));
        System.out.println("Swapped list: " + swapList + "\n");
    }
}

/* iii)Write a Java program to iterate through all elements
   in a linked list starting at the specified position? */
class Iterate {
    LinkedList<Integer> itList = new LinkedList<>();

    void itLinkList() {
        //LinkedList using a loop
        for (int i = 0; i < 7; i++) {
            int addIn = i * i + 2 * i + 2;
            itList.add(addIn);
        }

        ListIterator<Integer> iterator = itList.listIterator(3);

        System.out.print("Original list: " + itList +
                "\nList starting from index 3: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}

/* iv)Write a Java program to replace an element in a linked list? */
class Replace extends Iterate {
    LinkedList<Integer> repList;

    void repLinkList() {
        this.repList = super.itList;
        System.out.println("\n\nOriginal List: " + super.itList);

        this.repList.set(1, 33321);
        System.out.println("After replacement: " + this.repList);
    }
}

/* v)Write a Java program to convert a hash set to an array? */
class Convert {
    HashSet<String> hashSet;
    ArrayList<String> hashArr;


    public void hashToArr() {
        //hashset using Collection
        hashSet = new HashSet<>();
        addAll(hashSet, "Midori", "Love", "Hanna");

        System.out.println("\nOriginal hash set: " + hashSet);
        this.hashArr = new ArrayList<>();
        String[] toArray = hashSet.toArray(new String[0]);

        System.out.println("Hash set to array: " + Arrays.toString(toArray));

    }
}