package models.dtos.UserAccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateUseAccountDTO {
    @NotBlank(message = " Phone Number can't be null")
    String phoneNumber;

    @NotBlank(message = " Password can't be null")
    String password;

    @NotBlank(message = " Role can't be null")
    String role;
}
