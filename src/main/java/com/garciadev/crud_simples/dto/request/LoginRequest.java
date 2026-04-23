package com.garciadev.crud_simples.dto.request;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull(message = "campo obrigstorio!") String email,
                           @NotNull(message = "campo obrigstorio!") String password) {
}
