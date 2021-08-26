package NullEmpty;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var emptyList = new ArrayList<Integer>();
        System.out.println("Is emptyList null?: " + (emptyList == null));
        System.out.println("Is emptyList empty?: " + emptyList.isEmpty());

        List<Integer> nullList = null;
        System.out.println("Is nullList null?: " + (nullList == null));
        System.out.println("Is nullList null?: " + nullList.isEmpty()); // NullPointerException
    }
}
