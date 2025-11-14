//import java.lang.Math;
import java.util.TreeMap;
import java.util.Map;
public class MpShower {
    public static void main(String[] args){
        TreeMap<String, Integer> m1 = new TreeMap<String, Integer>();
        
        m1.put("Abebe", 23000);
        m1.put("Kebede", 45000);
        m1.put("Getachew", 12000);
        m1.put("Alemayehu", 67000);
        m1.put("Birhanu", 34000);
        m1.put("Daniel", 89000);
        m1.put("Fikadu", 56000);
        m1.put("Gashaw", 78000);
        m1.put("Hailu", 99000);
        m1.put("Tesfaye", 11000);
        m1.put("Yared", 47000);
        m1.put("Zewdu", 38000);
        m1.put("Meles", 150000);
        m1.put("Hailemariam", 130000);  
        m1.put("Abiy", 200000);
        m1.put("Sahlework", 175000);
        m1.put("Liya", 160000); m1.put("Muferiat", 140000); m1.put("Gedion", 125000);      m1.put("Ephrem", 115000); m1.put("Fekadu", 105000);
        int v = 0;
        int x = 0;
        int Max = 0;
        int Min = Integer.MAX_VALUE;
        String minName = "";
        String maxName = "";

        for (Map.Entry<String, Integer> entry : m1.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
            v = entry.getValue();
            x += v;
            
            if(v > Max){
                Max = v;
                maxName = entry.getKey();
            }
            if(v < Min){
                Min = v;
                minName = entry.getKey();
            }
            
            
        }
        

        System.out.println("========================");
        System.out.println("totalSalary:" + x);
        System.out.println("MaxSalary:" + Max + "("+ maxName+ ")");
        System.out.println("MinSalary:" + Min + "(" + minName + ")");

        

    }
}
