package br.com.labdna.error;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.labdna.util.LabDnaConstantesUtil;

/**
 * Classe que representa um handler para exceções ao realizar a chamada nos
 * endpoints de dnas.
 * 
 * @author Danillo
 *
 */
@ControllerAdvice
public class LabDnaErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("mensagem", LabDnaConstantesUtil.DNA_FORA_PADRAO);
		return new ResponseEntity<Object>(body, HttpStatus.FORBIDDEN);
	}

}
