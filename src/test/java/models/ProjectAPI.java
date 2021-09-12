package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectAPI {

    @Expose
    boolean status;
    @Expose
    String title;
    @Expose
    String code;
    @Expose
    String description;
    String access;
    String group;
}
