package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class MailBox {

    public void sendEmail() {
    }

    public void receiveEmail() {
    }

    public void composeEmail() {
    }

    public void deleteEmail() {
    }

    public void filterSpam() {
    }

    public void searchFile(Predicate<String> predicate) {
    }

    public void convertEncoding() {
    }
    /* Нарушения SRP :
    * Методы, выполняющие разные цели,
    * composeEmail : Создание и инициализциая объектов,
    * В searchFile идёт проверка условий, диктуемых извне,
    * В convertEncoding может поменяться (преобразование)
    * */
}
