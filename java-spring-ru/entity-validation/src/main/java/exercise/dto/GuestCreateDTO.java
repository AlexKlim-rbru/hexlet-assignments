package exercise.dto;

// BEGIN
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Setter
@Getter
public class GuestCreateDTO {
    // BEGIN
    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp="^\\+[0-9]{11,13}$")
    private String phoneNumber;

    @Positive
    @Size(min = 4, max = 4)
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;
    // END

    @CreatedDate
    private LocalDate createdAt;
}
// END
