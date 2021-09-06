package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginBuilder {

    String username;
    String password;

}
