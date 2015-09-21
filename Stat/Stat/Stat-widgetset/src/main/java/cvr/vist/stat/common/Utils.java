package cvr.vist.stat.common;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;


public class Utils {
    public static void showNotification(Notification notification) {
        notification.setDelayMsec(2000);
        notification.show(Page.getCurrent());
    }
    
}
