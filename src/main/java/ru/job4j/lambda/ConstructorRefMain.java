package ru.job4j.lambda;

public class ConstructorRefMain {
    public static void main(String[] args) {
        /**
         * ссылка на конструктор Model(String str){}
         * записывается в переменную modelConstructor
         */
        FuncInterface modelConstructor = Model::new;
        Model model = modelConstructor.function("Hello");
        FuncInterface2 modelConstructor2 = Model::new;
        Model model1 = modelConstructor2.function2("Test");
        System.out.println("Значение равно : " + model.getName());
    }
}
