import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1; // отриц означает, что возраст неизвестен. Использовать nullable Integer было бы красивее, но условие задачи - int age
    protected String city; // nullable String

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age += 1;
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + getAge() + " лет, из " + getAddress();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(this.surname).setAge(0).setAddress(this.city);
        return personBuilder;
    }

}
