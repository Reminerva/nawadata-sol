import java.util.ArrayList;
import java.util.Scanner;

public class SortCharacter {
    public static void main(String[] args) {
        try {
            String s = input();
            solution(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void solution(String s) {
        s = s.toLowerCase();
        String[] arr = s.split("");
        ArrayList<String> arrList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arrList.contains(arr[i])) {
            } else {
                arrList.add(arr[i]);
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i].equals(arr[j])) {
                        arrList.add(arr[j]);
                    }
                }
            }
        }

        ArrayList<String> arrVowel = new ArrayList<>();
        ArrayList<String> arrConsonant = new ArrayList<>();

        for (String elem : arrList) {
            if (elem.equals(" ")) {
                continue;
            }
            if (elem.equals("a") || elem.equals("e") || elem.equals("i") || elem.equals("o") || elem.equals("u")) {
                arrVowel.add(elem);
            } else {
                arrConsonant.add(elem);
            }
        }
        System.out.println("Vocwel Character : \n" + String.join("", arrVowel));
        System.out.println("Consonant Character : \n" + String.join("", arrConsonant));
    }

    public static String input() {
        System.out.println("Input one line of words (S) :");
        try (Scanner scan = new Scanner(System.in)) {
            String s = scan.nextLine();
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
