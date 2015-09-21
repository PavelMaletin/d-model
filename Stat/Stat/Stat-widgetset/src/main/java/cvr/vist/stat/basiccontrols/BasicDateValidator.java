package cvr.vist.stat.basiccontrols;

import com.vaadin.data.Validator;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author chernov
 */
public class BasicDateValidator implements Validator {

    private static final long serialVersionUID = 2141498272727834579L;

    public boolean isValid(Object value) {
        try {
            validate(value);
        } catch (Validator.InvalidValueException e) {
            return false;
        }
        return true;
    }

    public void validate(Object value) throws Validator.InvalidValueException {
        if (!(value instanceof Date))
            throw new Validator.InvalidValueException("Значение " + value.toString() + " не является датой ");
        Date date = (Date) value;
        if (date.before(new GregorianCalendar(1970, 0, 1).getTime()))
            throw new Validator.InvalidValueException("Значение " + value.toString() + " не является датой () ");
    }
}
