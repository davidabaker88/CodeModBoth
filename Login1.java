import java.util.ArrayList;
import java.util.Scanner;

public class Login1 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        String createOrLogin ="";
        String username="";
        String password="";
        while (true) {

            System.out.println("Would you like to (create account) or (login)?");
            createOrLogin = console.nextLine();
            if (createOrLogin.equalsIgnoreCase("create account") || createOrLogin.equalsIgnoreCase("login")) {
                continue;
            }
            //region createAccount
            if(createOrLogin.equalsIgnoreCase("create account")){
                while(true) {
                    System.out.println("Enter Username:");
                    username = console.nextLine().toLowerCase(); //ignore case by converting to lowercase
                    System.out.println("Enter Password:");
                    password = console.nextLine();
                    //region make sure username is valid
                    if (usernames.contains(username)){
                        //if username exists go back to getting username
                        continue;
                    }
                    //endregion
                    usernames.add(username);
                    passwords.add(password);
                    break;
                }
            } //endregion
            //region login
            else{
                System.out.println("Enter Username:");
                username = console.nextLine().toLowerCase();//ignore case by converting to lowercase
                System.out.println("Enter Password:");
                password = console.nextLine();
                //region check if UN/PASS matches
                int index = usernames.indexOf(username);
                if(index != -1){
                    if(password.equals(passwords.get(index))){
                        //correct password and username
                        System.out.println("welcome, "+username);
                        System.exit(1);
                    }
                }
                //endregion
                System.out.println("sorry account does not match records");
            }
            //endregion
        }
    }
}