package clone;

public class InnerObject {
    int num;
    AnotherInnerObject anotherInnerObject;

    @Override
    protected InnerObject clone() throws CloneNotSupportedException {
        return (InnerObject) super.clone();
    }

}
