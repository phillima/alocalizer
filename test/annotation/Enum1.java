package annotation;

@AnnotationEnum
public enum Enum1 {
    ONE(1),
    TWO(2);

    private final int value;

    Int(final int value) { this.value = value; }

    public int getValue() { return value; }

    @Override
    public String toString() { return "Test " + value; }
}