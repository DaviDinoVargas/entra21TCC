package project.equo.exceptions;

public class RecursoJaExistente extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RecursoJaExistente(String msg) {
		super(msg);
	}
}
