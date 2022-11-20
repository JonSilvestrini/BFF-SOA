package jonsilvestrini.BFFSOA.exception;

public class NotFoundException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = 6399087279047270163L;

	public NotFoundException(String msg) {
		super(msg);
	}

	public NotFoundException() {
		super();
	}

}
