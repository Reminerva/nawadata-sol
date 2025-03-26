import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PSBB {
    public static void main(String[] args) {
        
        try {
            List<String> input = input();
            System.out.println("Minimum bus required is : "+solution(Integer.parseInt(input.get(0)), input.get(1)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int solution(int numberOfFamily, String numberOfMember) {
        
        try {
            ArrayList<Integer> numberOfMemberInt = validation(numberOfFamily, numberOfMember);

            for (int i = 0; i < numberOfMemberInt.size(); i++) {
                
                Integer j = i + 1;
                if (numberOfMemberInt.get(i) >= 4 || j >= numberOfMemberInt.size()) {
                    
                    continue;
                } 

                Integer checkpoint = 4;
                while(numberOfMemberInt.get(i) + numberOfMemberInt.get(j) != checkpoint && checkpoint != 0) {
                    
                    if (j == numberOfMemberInt.size() - 1) {
                        checkpoint -= 1;
                        j = i + 1;
                    }
                    j += 1;
                }
                
                if (numberOfMemberInt.get(i) + numberOfMemberInt.get(j) == checkpoint){
                    numberOfMemberInt.set(j, 90 + numberOfMemberInt.get(i) + numberOfMemberInt.get(j));
                    numberOfMemberInt.remove(i);
                    i -= 1;
                }
            }

            return numberOfMemberInt.size();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ArrayList<Integer> validation(int numberOfFamily, String numberOfMember) {
        String[] output = numberOfMember.split(" ");
        
        ArrayList<Integer> outputInt = new ArrayList<>();
        for (String output1 : output) {
            if (!"".equals(output1)) {
                outputInt.add(Integer.valueOf(output1.trim()));
            }
        }
        System.out.println(outputInt.toString());
        if (outputInt.size() != numberOfFamily) {
            throw new RuntimeException("Input must be equal with count of family");
        }


        for (int elem : outputInt) {
            if (elem < 0) {
                throw new RuntimeException("Input must be greater than 0");
            }
            if (elem > 4) {
                throw new RuntimeException("Input must be less than 4");
            }
        }

        return outputInt;
    }

    public static List<String> input() {

        try (Scanner scan = new Scanner(System.in)) {
            String numberOfFamily;
            String numberOfMember;

            try {
                System.out.println("Input the number of families : ");
                numberOfFamily = scan.nextLine();
                
                System.out.println("Input the number of members in the family (separated by a space): ");
                numberOfMember = scan.nextLine();

                return  List.of(numberOfFamily, numberOfMember);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

    }
}
