package cvr.vist.stat.basiccontrols;
import com.vaadin.ui.ComboBox;

/**
 *
 * @author chernovvr
 */
public class BasicComboBox extends ComboBox{

    public BasicComboBox() {
        setWidth("100%");
        setNullSelectionAllowed(false);
        setRequired(true);
        setImmediate(true);
        setScrollToSelectedItem(true);
    }

    public BasicComboBox(String caption) {
        this();
        setCaption(caption);
        setRequiredError("Поле [" + caption + "] должно быть заполнено!");
        
    }
    
    
}
