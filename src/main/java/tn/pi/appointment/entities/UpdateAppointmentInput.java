package tn.pi.appointment.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class UpdateAppointmentInput {
    private Long id;
    private String description;
    private String status;
}
