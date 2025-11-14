import java.util.*;
// import java.util.List;

public class ThreeList {
    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();

        l1.add(43); l1.add(48); l1.add(90);
        l2.add(23); l2.add(7); l2.add(43);
        l3.add(4); l3.add(8); l3.add(9);

        l3.addAll(l1);
        l3.addAll(l2);

        System.out.println("the size of l3 will be: " + l3.size());
        
        @SuppressWarnings("rawtypes")
        Iterator iter = l3.iterator();
        
        while(iter.hasNext()){
            System.out.print(iter.next() + "\n");
        }
        System.out.println();
        System.out.println(l3.lastIndexOf(43));
        System.out.println(l3.listIterator());
    }
}