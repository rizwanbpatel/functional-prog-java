package com.rp.fp;

public class Chap2V4 {

    protected static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader {

        public final NoArgFunction<Person> loadPerson;

        public DataLoader(Boolean isDevelopment) {
            this.loadPerson = isDevelopment
                    ? this::loadPersonFake
                    : this::loadPersonReal;
        }

        private Person loadPersonReal() {
            System.out.println("Loading person");
            return new Person("Real P", 30);
        }

        private Person loadPersonFake() {
            System.out.println("Returning fake person");
            return new Person("Fake P", 31);
        }
    }

    public static void main(String[] args) {
        final Boolean IS_DEVelopment = true;
        DataLoader dataLoader = new DataLoader(IS_DEVelopment);
        System.out.println(dataLoader.loadPerson.apply());
    }
}
