// .....This is word counter project used to give total counts of words present in file or text...

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Word_Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n_________WELCOME TO WORD COUNTER PROJECT____________");
        System.out.println();
        System.out.println("1. Enter the text manually: ");
        System.out.println("2. Read from file: ");
        System.out.println();
        System.out.println("Choose the option from the above: ");
        int choose = sc.nextInt();
        System.out.println();
        String input_text = "";
        switch (choose) {
            case 1:  System.out.println("Enter the text: ");
                     Scanner s = new Scanner(System.in);
                     input_text = s.nextLine();
                     break;

            case 2: System.out.println("Enter the file path: ");
                    Scanner scan = new Scanner(System.in);
                    String filepath = scan.nextLine();

                try {
                    input_text = readFromFile(filepath);
                }
                catch (IOException e) {
                    System.out.println("Error reading the file:" + e.getMessage());
                    System.exit(1);
                }
                break;

            default:
                     System.out.println("Invalid Choose, Please try again...");
                     System.exit(1);

        }

        int word = word_count(input_text);
        System.out.println("\nTotal counting words are: " + word);
    }

        private static int word_count(String input_text){

        String []words=input_text.split("[\\s\\p{Punct}]+");
        return words.length;
        }

        private static String readFromFile(String filepath)
            throws IOException{
               StringBuilder content = new StringBuilder();
                 try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
                   String line;
                   while((line = br.readLine())!=null){
                  content.append(line).append("\n");
            }
        }
        return content.toString();

    }
}
