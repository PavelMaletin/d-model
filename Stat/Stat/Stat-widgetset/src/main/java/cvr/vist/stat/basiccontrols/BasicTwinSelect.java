package cvr.vist.stat.basiccontrols;

import com.vaadin.ui.TwinColSelect;

/**
 *
 * @author chernovvr
 */
public class BasicTwinSelect extends TwinColSelect{

    public BasicTwinSelect(String caption) {
        super(caption);
        setWidth("100%");
        setHeight(100, Unit.PIXELS);
        setImmediate(true);
        setRequired(true);
        setRequiredError("поле " + caption +" должно быть заполнено !");
    }    
}
