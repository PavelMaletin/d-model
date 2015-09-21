package cvr.vist.stat.basiccontrols;
import com.vaadin.ui.Panel;

/**
 *
 * @author chernovvr
 */
public class BasicPanel extends Panel {

    public BasicPanel(String caption) {
        super(caption);
        setImmediate(false);
        setSizeFull();
//        setWidth("100.0%");
//        setHeight("100.0%");
    }

    
    public BasicPanel() {
        super();
        setImmediate(false);
//        setWidth("100.0%");
//        setHeight("100.0%");
        setSizeFull();
    }
}
