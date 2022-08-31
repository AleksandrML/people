public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1; // отриц означает, что возраст неизвестен. Использовать nullable Integer было бы красивее, но условие задачи - int age
    protected String city; // nullable String

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 300) {
            throw new IllegalArgumentException("указан недопустимый возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (name != null && surname != null) {
            Person person;
            if (age != -1) {
                person = new Person(name, surname, age);
            } else {
                person = new Person(name, surname);
            }
            if (city != null) {
                person.setAddress(city);
            }
            return person;
        } else throw new IllegalArgumentException("не хватает обязательных полей");
    }

}
