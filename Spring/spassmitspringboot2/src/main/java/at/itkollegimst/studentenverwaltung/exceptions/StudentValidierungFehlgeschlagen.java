package at.itkollegimst.studentenverwaltung.exceptions;

/**
 * Exception für die Validierung der Daten des Studentens.
 */
public class StudentValidierungFehlgeschlagen extends Exception {

    private FormValidierungExceptionDTO errors;

    public StudentValidierungFehlgeschlagen(String message)
    {
        super(message);
    }

    public StudentValidierungFehlgeschlagen(FormValidierungExceptionDTO errors)
    {
        this.errors = errors;
    }

    public FormValidierungExceptionDTO getErrorMap()
    {
        return errors;
    }
}
