package com.marcskow.spring.bootstrap.tests.mocked;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfigDto {
    private long id;
    private String userName;
    private String departmentName;
}
