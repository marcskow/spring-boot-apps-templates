package com.marcskow.complex.criteria.api.person

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonNotFound(message: String) : RuntimeException(message)
