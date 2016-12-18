import java.util.Arrays;
import java.util.List;

/**
 * Created by Vlad on 16.12.2016.
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[] {11, 14, 12, 4};
        List<Integer> numbers = Arrays.asList(11, 14, 12, 4);
        int sum = numbers.stream()
                .filter( w -> { return w % 2 == 0; } )      // 14, 12, 4
                .map( w -> { return w * w; } )               //
                .reduce(0, (x, y) -> { return x + y; } );
        System.out.println(sum);
    }
}
