package cvr.vist.stat.basiccontrols;
import com.vaadin.event.FieldEvents;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import java.util.Date;


/**
 *
 * @author chernovvr
 */
public class BasicDateField extends PopupDateField {

    public BasicDateField() {
        setWidth("100%");
        setResolution(Resolution.DAY);
        setDateFormat("dd.MM.yy");
        setValue(new Date());
        addValidator(new BasicDateValidator());
        addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
           //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                validate();
                if(!isValid()){
                    Notification.show("Внимение","не верное значение даты", Notification.Type.ERROR_MESSAGE);
                }
            }
        });
    }

    public BasicDateField(String caption) {
        this();
        setCaption(caption);
//        setWidth("100%");
//        setResolution(Resolution.DAY);
//        setDateFormat("dd-MM-yyyy");
    }

    public BasicDateField(String caption, Date date, Boolean required) {
        this();
        setCaption(caption);
        setValue(date);
        setRequired(required);
        if (required) {
            setRequiredError("Поле должно быть заполнено!");
        }
    }
}
