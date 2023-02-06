package ru.job4j.inheritance;

public class Animal {
    public void instanceInvoke() {
        System.out.println("Вызов метода экземпляра Animal");
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Animal");
    }

    public class HideExampleMain {
        public static void main(String[] args) {
            Animal animal = new Animal();
            Animal cat = new Catt();
            animal.instanceInvoke();
            cat.instanceInvoke();
            Animal.staticInvoke();
          //  Animal.Catt.staticInvoke();
        }
    }
}

