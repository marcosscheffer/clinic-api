package com.marcos.api.dto.consult;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record ScheduleRequestDTO(long idDoctor, @NotNull long idPatient,
        @NotNull @Future LocalDateTime date) {

}
