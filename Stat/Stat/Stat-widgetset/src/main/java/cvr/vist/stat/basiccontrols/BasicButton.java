package cvr.vist.stat.basiccontrols;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;

/**
 *
 * @author chernovvr
 */
public class BasicButton extends Button{

    public BasicButton(String name) {
        super(name);
        this.setImmediate(false);
        this.setWidth("-1px");
        this.setHeight("-1px");        
    }

    public BasicButton(String name, String desc) {
        super(name);
        this.setDescription(desc);
        this.setImmediate(false);
        this.setWidth("-1px");
        this.setHeight("-1px");        
    }

    public BasicButton(String name, String desc, String icon) {
        super(name);
        this.setIcon(new ThemeResource(icon));
        this.setDescription(desc);
        this.setImmediate(false);
        this.setWidth("-1px");
        this.setHeight("-1px");        
    }
}
