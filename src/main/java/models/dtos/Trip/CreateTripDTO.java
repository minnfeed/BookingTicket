package models.dtos.Trip;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateTripDTO {
    @NotNull(message = " Trip ID can't be null")
    Integer tripID;

    @NotNull(message = " Bus ID can't be null")
    Integer bus;

    @NotBlank(message = " Departure Location can't be null")
    String departureLocation;

    @NotBlank(message = " Arrival Location can't be null")
    String arrivalLocation;

    @NotBlank(message = " Departure Time can't be null")
    LocalDateTime departureTime;

    @NotBlank(message = " Arrival Time can't be null")
    LocalDateTime arrivalTime;
}
