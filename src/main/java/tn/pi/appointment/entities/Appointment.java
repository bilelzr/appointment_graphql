package tn.pi.appointment.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long clientId;


    private long agentId;
    private long propertyId ;
    private LocalDateTime dateTime ;
    private String description ;
    private String status ;
}
