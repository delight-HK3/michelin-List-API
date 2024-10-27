package com.api.michelinAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class errorResultDTO {
    private final String code;
	private final String message;
}
