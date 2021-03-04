package poly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class AddTest {

    private Node fromFile(String fileName) throws IOException {
        String resourceRoot = "./src/test/resources/add/";
        File polyFile = new File(resourceRoot + fileName);
        Scanner scan = new Scanner(polyFile);
        return Polynomial.read(scan);
    }

    private String reduce(Node p1, Node p2) {
        return Polynomial.toString(Polynomial.add(p1, p2)).replaceAll(" ", "");
    }

    @Test void testCase1() throws IOException {
        Node p1 = fromFile("case1_1.txt");
        Node p2 = fromFile("case1_2.txt");
        Assertions.assertThat(Polynomial.add(p1, p2)).isNull();
    }

    @Test
    void testCase2() throws IOException {
        Node p1 = fromFile("case2_1.txt");
        Node p2 = fromFile("case2_2.txt");
        Assertions
                .assertThat(reduce(p1, p2))
                .isEqualTo("24.0x^8 + 4.0x^6 + 15.0x^5 + 110.0x^4 + 5.0x^3 + - 6.0x + 5.0");
    }

    @Test void testCase3() throws IOException {
        Node p1 = fromFile("case3_1.txt");
        Node p2 = fromFile("case3_2.txt");
        Assertions
                .assertThat(reduce(p1, p2))
                .isEqualTo("3.0x^48976 + 2.0x^1090".replaceAll(" ", ""));
    }

    @Test void testCase4() throws IOException {
        Node p1 = fromFile("case4_1.txt");
        Node p2 = fromFile("case4_2.txt");
        Assertions.assertThat(Polynomial.add(p1, p2)).isNull();
    }

    @Test void testCase5() throws IOException {
        Node p1 = fromFile("case5_1.txt");
        Node p2 = fromFile("case5_2.txt");
        Assertions
                .assertThat(Polynomial.toString(Polynomial.add(p1, p2)))
                .isEqualTo(Polynomial.toString(p1));
    }

}
