import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem20Tests {

    @Test
    public void testThatTimeOfCalculationDivineIsOk() {
        //Given
        boolean expected = true;

        //When
        long startTime = System.currentTimeMillis();
        Problem20.divineNumberV2(2000000000);
        long finishTime = System.currentTimeMillis() - startTime;
        boolean actual = false;
        System.out.println("finishTime = " + finishTime);
        if (finishTime < 2000) {
            actual = true;
        }

        //Then
        Assertions.assertEquals(expected, actual);
    }
}