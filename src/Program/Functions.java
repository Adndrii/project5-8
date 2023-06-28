package Program;

import java.util.*;

public class Functions {
    List<recipe> book = new ArrayList();

    public Functions(List<recipe> book){
        this.book = book;
    }

    public void add(Scanner scan){
        System.out.println("Назва рецепту:");
        String name = scan.nextLine();
        System.out.println("Інгридієнти:");
        String ing = scan.nextLine();
        System.out.println("Спосіб приготування:");
        String method = scan.nextLine();
        List<String> ingredient = Arrays.asList(ing.split(", "));
        book.add(new recipe(name, ingredient, method));
    }
    public void list() {
        for (int i = 0; i < book.size(); i++) {
            recipe Recipe = book.get(i);

            System.out.println("====================================\n"+(i+1)+"."+Recipe.getName());
            System.out.println("СПИСОК ІНГРИДІЄНТІВ:");
            for (int j = 0; j < Recipe.getIngredient().size(); j++) {
                String ingredient = Recipe.getIngredient().get(j);
            System.out.println((j+1)+") "+ingredient);
            }
            System.out.println("———————————————————");
            System.out.println("МЕТОД ПРИГОТУВАННЯ:");
            System.out.println(Recipe.getMethod()+"\n====================================\n");
        }
    }
    public void update(Scanner scan){
        System.out.println("Який елемент?");
        int el = scan.nextInt();
        String c = scan.nextLine();
        System.out.println("Назва рецепту:");
        String name = scan.nextLine();
        System.out.println("Інгридієнти:");
        String ing = scan.nextLine();
        System.out.println("Спосіб приготування:");
        String method = scan.nextLine();
        List<String> ingredient = Arrays.asList(ing.split(", "));
        book.set((el-1), new recipe(name, ingredient, method));
    }
    public void delete(Scanner scan){
        System.out.println("який елемент?");
        int l = scan.nextInt();
        String c = scan.nextLine();
        book.remove(l-1);
    }
    public void sort(Scanner scan){
        Collections.sort(book, new Comparator<recipe>() {
            @Override
            public int compare(recipe o1, recipe o2) {

                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Просортовано");
    }
    public void search(Scanner scan){
        System.out.println("Введіть ім'я");
        String d = scan.nextLine();
        for(recipe a : book){
            if(a.getName().contains(d)){
                System.out.println(a.getName()+" " +a.getIngredient()+" " +a.getMethod());
            }
        }
    }
}
