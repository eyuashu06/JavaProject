import java.util.*;

public class SetHash {
    public static void main(String[] args)    
    {
        Set<String> s1= new HashSet<String>();

        s1.add("A");
        s1.add("B");
        s1.add("C");
        s1.add("B");
        s1.add("A");

        Iterator iter = s1.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

};
