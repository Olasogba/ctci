
import java.util.*;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ground {
  public static void main(String[] args) {
      try {
          List<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 497; i++)
        {    
            String inp = sc.nextLine();
            list.add(inp);
        }
        
        FileWriter fileWriter = new FileWriter("fileName");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        
        for (int j = 0; j < list.size(); j++) {
            // System.out.println("https://ferguson-stg.b.lucidworks.cloud/api/query/ferguson_app2_lwdev?"+list.get(j).replaceAll(" ", "%20")+"\n");
            printWriter.print("https://ferguson-stg.b.lucidworks.cloud/api/query/ferguson_app2_lwdev?"+list.get(j).replaceAll(" ", "%20")+"\n");
        }

      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
  }
}