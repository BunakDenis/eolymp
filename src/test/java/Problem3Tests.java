import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem3Tests {

    @Test
    public void testIfAmountOfEdgesWorkOk() {
        //Given
        int[] edges = {1, 2, 3, 4, 5, 6};
        int[] expected = {12, 20, 28, 36, 44, 52};

        for (int i = 0; i < edges.length; i++) {
            Assertions.assertEquals(expected[i], new Problem3().amountEdgesOfCube(edges[i]));
        }
    }
}