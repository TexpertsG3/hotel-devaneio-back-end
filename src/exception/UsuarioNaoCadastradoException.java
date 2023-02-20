package exception;

public class UsuarioNaoCadastradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4481978495686510489L;
	
	public UsuarioNaoCadastradoException (String mensagem) {
		super(mensagem);
	}

}
