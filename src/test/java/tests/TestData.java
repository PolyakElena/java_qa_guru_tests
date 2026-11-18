package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {
    public Faker faker = new Faker();
    public Faker fakerRu = new Faker(new Locale("ru"));

    public String firstName = fakerRu.name().firstName();
    public String lastName = fakerRu.name().lastName();
    public String userEmail = faker.internet().emailAddress();

    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String genter = faker.options().option("Male", "Female", "Other");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String currentAddress = fakerRu.address().fullAddress();
    public String day = String.valueOf(faker.number().numberBetween(1, 28));
    public String month = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String year = String.valueOf(faker.number().numberBetween(1940, 2026));
    public String data = String.format("%s %s,%s", day, month, year);
    public String subject = faker.options().option(
            "Accounting", "Arts", "Biology", "Chemistry", "Civics",
            "Commerce", "Computer Science", "Economics", "English",
            "Hindi", "History", "Maths", "Physics", "Social Studies");
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = generateCity(state);
    public String picture = "1.jpg";

    public String wrongEmail = fakerRu.internet().emailAddress();
    public String shortEmail = RandomUtils.getRandomString(3);
    public String wrongNumber = RandomUtils.getRandomString(2);
}
