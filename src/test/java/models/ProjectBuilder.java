package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBuilder {

    String projectName;
    String projectCode;
    String description;
}
