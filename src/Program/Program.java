package Program;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;


public class Program {
    public static void main(String[] args) throws IOException{
        ArrayList<contact> contacts = new ArrayList();
        Gson GSON = new Gson();
        try (FileReader r = new FileReader("C:\\Users\\Admin\\Desktop\\info.json")){
            contacts = GSON.fromJson(r, new TypeToken<ArrayList<contact>>(){}.getType());
        }catch(IOException e){
            throw new RuntimeException(e);
        }



        Functions func = new Functions(contacts);
        Scanner scan = new Scanner(System.in);
        System.out.println("help(.h) - для перегляду комманд");
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("  Command: ");
            String c = scan.nextLine();
            if (c.equals("help") ||  c.equals(".h")) {
                System.out.println("help(.h),add(.a),list(.l),update(.u),delete(.d),sort(.srt),search(.sr),exit(.e)");
            }
            else if (c.equals("add") || c.equals(".a")){
                func.add(scan);
            }
            else if (c.equals("list") || c.equals(".l")){
                func.list(scan);
            }
            else if (c.equals("update")||  c.equals(".u")) {
                func.update(scan);
            }
            else if (c.equals("delete") || c.equals(".d")) {
                func.delete(scan);
            }
            else if (c.equals("sort")||  c.equals(".srt")) {

                func.sort(scan);
            }

            else if (c.equals("search") || c.equals(".sr")) {
                func.search(scan);
            }
            else if (c.equals("exit") || c.equals(".e")) {
                System.out.println("Зупиненно");
                String lp = GSON.toJson(func.contacts);
                try {
                    FileWriter w = new FileWriter("C:\\Users\\Admin\\Desktop\\info.json");
                    w.write(lp);
                    w.close();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                break;
            }
            else{
                System.out.println("Unknown command - " + c);}

        }
    }
}