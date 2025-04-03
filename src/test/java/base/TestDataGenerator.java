package base;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static String generateName() {
        return faker.name().firstName(); // "John", "Emma" и т.д.
    }

    public static String generateEmail() {
        return faker.internet().emailAddress(); // "user123@gmail.com"
    }

    public static String generatePassword() {
        return faker.internet().password(8, 12, true, true); // "A1b2@c3d4"
    }
}
