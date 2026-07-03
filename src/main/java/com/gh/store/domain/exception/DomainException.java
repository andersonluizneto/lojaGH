package com.gh.store.domain.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class DomainException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final String code;
	private final String message;
	private final int status;
	
}
