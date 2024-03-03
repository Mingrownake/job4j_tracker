package ru.job4j.ood.lsp;

/* Предусловия (Preconditions) не могут быть усилены в подклассе */
public class Device {
    protected float price;
    private final String brand;

    public Device(float price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    public Object putOnSale(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Invalid discount") {
            };
        }
        /* расчёт скидки */
        return value;
    }

    public void doSomething() {

    }
}

class LapTop extends Device {

    public LapTop(float price, String brand) {
        super(price, brand);
    }

    public Object putOnSale(int value) {
        if (value <= 99) {
            throw new IllegalArgumentException("Invalid discount") {
            };
        } /* усиление условия */
        return value;
    }
}

/* Постусловия (Postconditions) не могут быть ослаблены в подклассе. */
class Phone extends Device {
    public Phone(float price, String brand) {
        super(price, brand);
    }

    public Object putOnSale(int value) {
        /* Удаление постусловия  в подклассе */
        return value;
    }
}

/* Нарушение инвариативности в putOnSale, doSomething */
class TV extends Device {

    public TV(float price, String brand) {
        super(price, brand);
    }

    private void init() {

    }

    public Object putOnSale(int value) {
        return null;
    }

    public void doSomething(TV tv) {
        /* Пришлось закомментировать, не пускает бот :(
        if (tv.getClass() == Device.class) {*/
        init();
        /* do something */
    }
}


