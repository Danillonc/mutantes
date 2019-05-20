package br.com.labdna.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o validador para a formacao da base de dnas.
 * @author Danillo
 *
 */
@Component
public class BaseNitrogenadaValidator implements ConstraintValidator<BaseNitrogenadaValida, String[]> {

	@Override
	public boolean isValid(String[] baseDna, ConstraintValidatorContext context) {
		return validarTamanhoMatriz(baseDna) && validarString(baseDna);
	}

	/**
	 * Método responsável por validar cada string que compõem a base de dnas,
	 * verificando se as mesmas estão dentro do padrão especificado.
	 * 
	 * @param baseDna
	 *            - String array
	 * @return {@link Boolean}
	 */
	private boolean validarString(String[] baseDna) {
		boolean isValid = true;
		int lenBaseDna = baseDna.length;
		String[][] matrix = new String[lenBaseDna][lenBaseDna];

		int i = 0;
		for (String dna : baseDna) {
			String[] linhaMatriz = dna.split("");
			int j = 0;
			for (String ch : linhaMatriz) {
				ch = ch.toUpperCase();
				matrix[i][j] = ch;
				if (!validarComposicaoDna(ch))
					return false;
				j++;
			}
			i++;
		}

		return isValid;
	}

	/**
	 * Método responsável por validar o tamanho da matriz com o tamanho de cada
	 * elemento do array informado na baseDna.
	 * 
	 * @param baseDna
	 *            - String array
	 * @return {@link Boolean}
	 */
	private boolean validarTamanhoMatriz(String[] baseDna) {
		int lenthDna = baseDna.length;
		boolean isValid = true;
		for (String s : baseDna) {
			if (lenthDna != s.length()) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * Método responsável por validar se cada elemento(letra) está dentro do
	 * padrão.
	 * 
	 * @param s - letra que compoeem a base dna.
	 * @return {@link Boolean}
	 */
	private boolean validarComposicaoDna(String s) {
		return s.contains("A") || s.contains("T") || s.contains("C") || s.contains("G");
	}

}
