import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final String OPERATION_SYMBOLS = "['*','-','+','/']";
    private final String TRIM = "";

    @Test
    public void calculator(){
        String input = "2 + 3 * 4 / 2";
        String[] split = input.split(TRIM);

        //Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
        //    .isThrownBy(()-> {
        //
        //    })
    }
}
