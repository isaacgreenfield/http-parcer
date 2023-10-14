import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class alter {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
      }
    public static void main(String[] args) {
        String[] tr = in.nextLine().split(" ");
        List<String> arr1 = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        while(true){
            String b = in.nextLine();
            String[] base = new String[2];
            if(b == "") break;
            else base = b.split(": ");
            // out.println(base[0]);
            map1.put(base[0], base[1]);
            arr1.add(base[0]);
        }
        String body = "";
        while(true){
            body = body + in.nextLine();
            if(in.nextLine() == "") break;
        }
        String w = "";
        String[] tp = new String[4];
        if(tr[1].equals("/")) w = "root";
        else{
            tp = tr[1].split("/");
            if(tp.length == 1) w = "users page";
            if(tp.length == 2) w = "page of user " + tp[2];
            if(tp.length == 3) w = "achievments of user " + tp[2];
        }
        out.println("HTTP/1.1 200 OK");
        out.println("Server: my-test-server");
        out.println();
        out.println("answer: " + w);
        String s = "[";
        for(int i = 0;i<arr1.size();i++){
          s = s + arr1.get(i) + "=" + map1.get(arr1.get(i)); 
          if(i != arr1.size() - 1) s = s + ", "; 
        } 
        s = s + "]";
        out.println("Got request with headres: " + s);
        out.println("and body: " + body);
    }
}