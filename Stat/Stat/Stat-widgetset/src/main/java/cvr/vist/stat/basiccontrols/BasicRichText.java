package cvr.vist.stat.basiccontrols;

import com.vaadin.ui.RichTextArea;

/**
 *
 * @author chernov
 */
public class BasicRichText extends RichTextArea {

    public BasicRichText(String caption) {
        super(caption);
        setWidth("100%");
        setHeight("100%");
    }

    public BasicRichText() {
        super();
        setWidth("100%");
        setHeight("100%");
    }

}
