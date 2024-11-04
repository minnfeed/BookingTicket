package models.dtos.Trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TripRespondDTO {
    Integer tripID;
    Integer bus;
    String departureLocation;
    String arrivalLocation;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
}
