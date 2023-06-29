package Program;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;


public class Program {
    public static void main(String[] args) throws IOException {
        ArrayList<recipe> book = new ArrayList();
        Gson GSON = new Gson();
        try (FileReader r = new FileReader("C:\\java\\project5-8\\info.json")) {
            book = GSON.fromJson(r, new TypeToken<ArrayList<recipe>>() {
            }.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Functions func = new Functions(book);
        Scanner scan = new Scanner(System.in);
        System.out.println("help(.h) - для перегляду комманд");
        while (true) {
            System.out.println("Command: ");
            String c = scan.nextLine();
            switch (c) {
                case "help":
                    System.out.println("help(.h),add(.a),list(.l),update(.u),delete(.d),sort(.srt),search(.sr),exit(.e)");
                    break;
                case "add":
                    func.add(scan);
                    break;
                case "list":
                    func.list();
                    break;
                case "upd":
                    func.update(scan);
                    break;
                case "delete":
                    func.delete(scan);
                    break;
                case "sort":
                    func.sort(scan);
                    break;
                case "search":
                    func.search(scan);
                    break;
                case "exit":
                    System.out.println("Зупиненно");
                    String lp = GSON.toJson(func.book);
                    try {
                        FileWriter w = new FileWriter("C:\\java\\project5-8\\info.json");
                        w.write(lp);
                        w.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command - " + c);
                    break;
            }

        }
    }
}