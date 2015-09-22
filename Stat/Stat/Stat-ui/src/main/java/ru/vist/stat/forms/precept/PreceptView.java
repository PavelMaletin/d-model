package ru.vist.stat.forms.precept;

import com.vaadin.server.FontAwesome;
import ru.vist.stat.subs.CView;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.themes.ValoTheme;

public class PreceptView extends CView {

    public static String name = "Предписания(Grid)";
    private final TabSheet sheet = new TabSheet();

    public PreceptView() {
        super();
        setMargin(true);
        setFa(FontAwesome.APPLE);
        setSizeFull();
        sheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        sheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        TabSheet.Tab tab1 = sheet.addTab(new PreceptList());
        tab1.setCaption("Список");
        TabSheet.Tab tab2 = sheet.addTab(new PreceptDetail());
        tab2.setCaption("Детали");
        addComponent(sheet);
    }

    @Override
    public void init() {
    }

}
