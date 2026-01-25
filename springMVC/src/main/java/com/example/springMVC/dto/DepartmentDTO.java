package com.example.springMVC.dto;
import com.example.springMVC.annotations.StudentValidation;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Title can not be empty or null")
    @Size(min=3, max = 20)
    private String title;

    @NotBlank(message = "Email can not be empty or null")
    @Email(message = "Invalid mail format")
    private String email;

    @NotBlank(message = "Password can not be empty or null")
    @Size(min = 10,message = "Password must be at least 10 Characters long")
    @Pattern(regexp = ".*[A-Z].*", message = "At least one Uppercase character needed")
    @Pattern(regexp = ".*[a-z].*", message = "At least one Lowercase character needed")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "At least one Special character needed")
    private String password;

    @StudentValidation()
    @Max(value = 100, message = "No of Students cannot be more than 100")
    @Min(value = 10, message = "No of Students should be more than 10")
    private Integer students;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDateTime createdAt;

}
