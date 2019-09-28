package lists.map.treemap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class SubjectGrade implements Serializable {

  private final String subject;
  private final int grade;

}
