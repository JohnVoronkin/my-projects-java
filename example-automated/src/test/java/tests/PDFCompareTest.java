package tests;

import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.PdfComparator;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PDFCompareTest {

  @Test
  public void shouldComparePdf() throws IOException {

    String actual = "E:\\workflow\\my-projects-java\\example-automated\\src\\test\\resources\\actual.pdf";
    String expected = "E:\\workflow\\my-projects-java\\example-automated\\src\\test\\resources\\expected.pdf";

    String diffOutput = "E:\\workflow\\my-projects-java\\example-automated\\src\\test\\resources\\diffOutput\\diffOutput";

    CompareResult compareResult = new PdfComparator(expected, actual).compare();
    assertThat(compareResult.getNumberOfPages())
            .isEqualTo(1);
    assertThat(compareResult.isEqual()).as("Имеются отличия в сравниваемых документах")
            .isEqualTo(true);
    compareResult.writeTo(diffOutput);

  }
}
