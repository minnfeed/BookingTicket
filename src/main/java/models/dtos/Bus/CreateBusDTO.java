package models.dtos.Bus;

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
public class CreateBusDTO {

    @NotNull(message = " Bus ID can't be null")
    Integer busID;

    @NotNull(message = "Bus Company ID can't be null")
    Integer busCompanyID;

    @NotBlank(message = "License Plate can't be null")
    String licensePlate;

    @NotNull(message = "Seat Count can't be null")
    Integer seatCount;

    @NotNull(message = "Bus Type can't be null")
    String busType;

}
