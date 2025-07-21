package Java8.LearnBasics;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTestDemo {

    static class User {
        String name;
        String email;
        String city;

        User(String name, String email, String city) {
            this.name = name;
            this.email = email;
            this.city = city;
        }
        Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }

    }

    public static void main(String[] args) {
        User u1 = new User("Adhavan", "Hi@gmail.com", "Thanjavur");
        User u2 = new User("Adithiyan", null, "Thanjavur");

        printUserEmail(u1);
        printUserEmail(u2);


    }

    static void printUserEmail(User u) {
        u.getEmail()
                .ifPresentOrElse(
                        email-> System.out.println(email),
                        ()-> System.out.println("no mail id")

                );

    }

}
