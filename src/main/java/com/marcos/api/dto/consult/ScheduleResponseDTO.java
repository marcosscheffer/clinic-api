package com.marcos.api.dto.consult;

import java.time.LocalDateTime;

public record ScheduleResponseDTO(long id, long idPatient, long idDoctor, LocalDateTime date) {

}
