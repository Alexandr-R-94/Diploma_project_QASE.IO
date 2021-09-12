package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBuilderError {

    String projectName;
    String incorrectProjectCode;
    String description;


}
