package com.acn.nemo.dto;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginDtoInput {

    private String username;
    private String password;
    static boolean check = false;

}
