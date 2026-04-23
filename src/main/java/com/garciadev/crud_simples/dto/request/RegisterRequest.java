package com.garciadev.crud_simples.dto.request;

import jakarta.validation.constraints.NotNull;

public record RegisterRequest(@NotNull(message = "campo obrigstorio!")String email,
                              @NotNull(message = "campo obrigstorio!") String password,
                              @NotNull(message = "campo obrigstorio!") String name) {
}
