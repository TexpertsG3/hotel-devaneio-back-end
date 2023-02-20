package exception;

public class SalarioInvalidoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2922190513456230143L;

	public SalarioInvalidoException (String mensagem) {
		super(mensagem);
	}

}
