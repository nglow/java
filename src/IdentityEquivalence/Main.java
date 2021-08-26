package IdentityEquivalence;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println("a == b: " + (a == b));

        var numberA = new Number(10);
        var numberB = new Number(10);
        System.out.println("numberA == numberB: " + (numberA == numberB));
        System.out.println(numberA);
        System.out.println(numberB);
        System.out.println("numberA.equals(numberB): " + numberA.equals(numberB));
    }

    static class Number {
        private Integer value;

        public Number(Integer value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number = (Number) o;
            return Objects.equals(value, number.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

}
