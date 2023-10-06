package com.ubsvirtual.UbsVirtual.responsestatusexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Medico não encontrado")
public class MedicoNotFound extends Exception{

}
