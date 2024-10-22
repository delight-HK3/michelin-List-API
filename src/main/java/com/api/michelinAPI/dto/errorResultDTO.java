package com.api.michelinAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class errorResultDTO {
    private String code;
	private String message;
}
