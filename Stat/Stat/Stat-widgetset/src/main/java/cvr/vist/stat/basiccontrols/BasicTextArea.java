package cvr.vist.stat.basiccontrols;

import com.vaadin.ui.TextArea;

/**
 *
 * @author chernovvr
 */
public class BasicTextArea extends TextArea {
    
    public BasicTextArea(String caption) {
        super(caption);
        setWidth("100%");
        setHeight("100%");
    }

    public BasicTextArea() {
        super();
        setWidth("100%");
        setHeight("100%");
    }
}
