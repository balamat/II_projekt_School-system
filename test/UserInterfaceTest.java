import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

public class UserInterfaceTest {
InputStream mockStream = mock(InputStream.class);

    @Test
    void teacherScannerShouldTakeUserInput() {
        String input = "Kovács Kálmán";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("Kovács Kálmán", UserInterface.teacherScan());
    }


}
