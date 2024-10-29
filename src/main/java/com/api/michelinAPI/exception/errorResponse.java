package com.api.michelinAPI.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class errorResponse {
    private final String code;
	private final String message;
}
