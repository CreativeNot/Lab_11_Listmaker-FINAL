import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String menuChoice = " ";
        boolean keepgoin = false;
        boolean flag = false;
        boolean flag2 = false;
        int counter = 0;
        int deleted = 0;
        String userInput = " ";
        Scanner in = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        do {
            menuChoice = SafeInput.getRegExString(in, "Please enter a menu choice: Add, Delete, Print, or Quit ", "[AaDdPpQq]");
            if (menuChoice.equalsIgnoreCase("A"))
            {
                do {
                    userInput = SafeInput.getNonZeroLenString(in, "Please enter something to add to the list");
                    list.add(userInput);
                    flag = SafeInput.getYNConfirm(in, "Do you have more to add? [Y/N]");
                }while (flag == true);
            }
            else if (menuChoice.equalsIgnoreCase("D"))
            {
                counter = 0;
                do {
                    for (String str : list) {
                        counter++;
                        System.out.println(counter + ". " + str);
                    }
                    deleted = SafeInput.getRangedInt(in, "Please enter which item you would like to delete", 1, list.size());
                    in.nextLine();
                    deleted = deleted - 1;
                    userInput = SafeInput.getNonZeroLenString(in, "Add replacement entry");
                    list.set(deleted, userInput);
                    flag2 = true;
                }while (!flag2);
            }
            else if (menuChoice.equalsIgnoreCase("P"))
            {
                counter = 0;
                for (String str : list)
                {
                    counter++;
                    System.out.println(counter + ". " + str);
                }

            }
            else{
                keepgoin = SafeInput.getYNConfirm(in, "Are you sure you want to quit? [Y/N]");
            }
        }
        while (!keepgoin);
    }
    private static void display()
    {

    }
}
