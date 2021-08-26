# Identity(동일성) vs Equivalence(동등성)

## 1. Identity
* 인스턴스의 참조 값을 비교
* == 사용
```java
int a = 10;
int b = 10;
System.out.println("a == b: " + (a == b));

var numberA = new Number(10);
var numberB = new Number(10);
System.out.println("numberA == numberB: " + (numberA == numberB));
```
```text
a == b: true
numberA == numberB: false
```

## 2. Equivalence
* 인스턴스의 값을 비교
* equals() 사용
```java
var numberA = new Number(10);
var numberB = new Number(10);
System.out.println("numberA == numberB: " + (numberA == numberB));
System.out.println("numberA.equals(numberB): " + numberA.equals(numberB));
```
```text
numberA == numberB: false
numberA.equals(numberB): false
```
이상하게도, 위에서 equals() 함수를 사용해서 동등성비교의 결과값으로 true를 예상했지만 false가 반환되었다.<br>
Java에서 equals()를 이용한 객체의 동등성 비교를 위해서는 equals() 메소드와 hashCode() 메소드를 재정의 해주어야 정상적으로 동작한다고 한다.<br>
```java
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
```
equals()와 hashcode()를 재정의 하는 이유는 메모리 공간을 효율적으로 사용하기 위해서 이다.<br>
재정의 하기 이전과 이후의 해쉬코드는 아래처럼 차이가 있다.
```java
System.out.println(numberA);
System.out.println(numberB);
```
1. 해쉬코드 적용 전
    ```text
    Main$Number@96532d6
    Main$Number@3796751b
    ```
2. 해쉬코드 적용 후
    ```text
    Main$Number@29
    Main$Number@29
    ```

아래와 같이 Number class에 equals() 메소드와 hashCode() 메소드를 재정의 한후 실행하면, `numberA.equals(numberB)`의 결과값이 정상적으로 true가 반환된다.

```java
var numberA = new Number(10);
var numberB = new Number(10);
System.out.println("numberA == numberB: " + (numberA == numberB));
System.out.println("numberA.equals(numberB): " + numberA.equals(numberB));
```
```text
numberA == numberB: false
numberA.equals(numberB): true
```
