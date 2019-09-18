package br.com.demospringboot.validation;

import br.com.demospringboot.model.EstudanteModel;

public class EstudanteValidation {

	public static boolean validaIfEstudanteExiste(EstudanteModel estudante) {
		if(estudante == null) {
			return false;
		}
		return true;
	}
}
