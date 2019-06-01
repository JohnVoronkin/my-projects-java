package tests;

import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.PdfComparator;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PDFCompareTest {

  @Test
  public void shouldComparePdf() throws IOException {

    String actual = "E:\\workflow\\my-projects-java\\example-automated\\src\\test\\resources\\actual.pdf";
    String actual2 = "E:\\workflow\\my-projects-java\\example-automated\\src\\test\\resources\\actual2.pdf";
    String expected = "E:\\workflow\\my-projects-java\\example-automated\\src\\test\\resources\\expected.pdf";

    String diffOutput = "E:\\workflow\\my-projects-java\\example-automated\\src\\test\\resources\\diffOutput\\diffOutput";

    CompareResult compareResult = new PdfComparator(expected, actual2).compare();
    assertThat(compareResult.getNumberOfPages())
            .isEqualTo(1);
    assertThat(compareResult.isEqual()).as("Имеются отличия в сравниваемых документах")
            .isEqualTo(true);
    compareResult.writeTo(diffOutput);

  }

  private InputStream r(final String s) {
    System.out.println(getClass().getResourceAsStream(s));
    return getClass().getResourceAsStream(s);
  }

}
