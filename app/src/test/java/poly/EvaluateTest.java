package poly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class EvaluateTest {
    private static String resourceRoot = "./src/test/resources/evaluate/";

    private Node fromFile(String fileName) throws IOException {
        File polyFile = new File(resourceRoot + fileName);
        Scanner scan = new Scanner(polyFile);
        return Polynomial.read(scan);
    }

    @Test void testCase1() throws IOException {
        Node p = fromFile("case1.txt");
        Assertions.assertThat(Polynomial.evaluate(p, 0.0f)).isEqualTo(5.0f);
    }


    @Test void testCase2() throws IOException {
        Node p = fromFile("case2.txt");
        Assertions.assertThat(Polynomial.evaluate(p, 8.0f)).isEqualTo(342391.0f);
    }
}
