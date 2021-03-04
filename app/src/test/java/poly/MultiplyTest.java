package poly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class MultiplyTest {
    private static String resourceRoot = "./src/test/resources/multiply/";

    private Node fromFile(String fileName) throws IOException {
        File polyFile = new File(resourceRoot + fileName);
        Scanner scan = new Scanner(polyFile);
        return Polynomial.read(scan);
    }

    private String reduce(Node p1, Node p2) {
        return Polynomial.toString(Polynomial.multiply(p1, p2)).replaceAll(" ", "");
    }

    @Test
    void testCase1() throws IOException {
        Node p1 = fromFile("case1_1.txt");
        Node p2 = fromFile("case1_2.txt");
        Assertions
                .assertThat(reduce(p1, p2))
                .isEqualTo(
                        "-1.0x^12 + -4.0x^11 + -10.0x^10 + -20.0x^9 + -35.0x^8 + -56.0x^7 + -84.0x^6 + -104.0x^5 + -115.0x^4 + -116.0x^3 + -106.0x^2 + -84.0x + -49.0"
                .replaceAll(" ", ""));
    }

    @Test void testCase2() throws IOException {
        Node p1 = fromFile("case2_1.txt");
        Node p2 = fromFile("case2_2.txt");

        Assertions
                .assertThat(reduce(p1, p2))
                .isEqualTo("96 x^14 + 180 x^11 + 440 x^10 - 264 x^9 + 195 x^8 + 570 x^7 - 165 x^6 - 1135 x^5 + 575 x^4 - 55 x^2 + 25 x"
                .replaceAll(" x", ".0x")
                .replaceAll("- ", "+ -")
                .replaceAll(" ", ""));
    }

    @Test void testCase3() throws IOException {
        Node p1 = fromFile("case3_1.txt");
        Node p2 = fromFile("case3_2.txt");

        Assertions
                .assertThat(reduce(p1, p2))
                .isEqualTo("3.0x^48982 + 6.0x^48981 + 9.0x^48980 + 2.0x^1096 + 4.0x^1095 + 6.0x^1094 + -1.0x^12 + -4.0x^11 + -10.0x^10 + -12.0x^9 + -9.0x^8"
                        .replaceAll(" ", ""));
    }

    @Test void testCase4() throws IOException {
        Node p1 = fromFile("case4_1.txt");
        Node p2 = fromFile("case4_2.txt");
        Assertions.assertThat(Polynomial.multiply(p1, p2)).isNull();
    }

    @Test void testCase5() throws IOException {
        Node p1 = fromFile("case5_1.txt");
        Node p2 = fromFile("case5_2.txt");
        Assertions.assertThat(Polynomial.multiply(p1, p2)).isNull();
    }

}
