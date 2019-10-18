package org.vaadin.mprdemo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.mpr.core.MprTheme;
import com.vaadin.ui.UI;

import java.util.HashMap;
import java.util.Map;

@Route("")
@MprTheme("mytheme")
public class MyUI extends AppLayout implements RouterLayout {

    public MyUI () {
        Image img = new Image("https://vaadin.com/images/vaadin-logo.svg", "Vaadin Logo");
        img.setHeight("35px");

        Map<Tab, String> nav = new HashMap();
        nav.put(new Tab(SpreadsheetView.TITLE), SpreadsheetView.ROUTE);
        nav.put(new Tab(TreeView.TITLE), TreeView.ROUTE);
        nav.put(new Tab(VideoView.TITLE), VideoView.ROUTE);

        Tabs tabs = new Tabs(nav.keySet().toArray(new Tab[nav.size()]));
        tabs.setAutoselect(true);
        tabs.addSelectedChangeListener(event -> getUI().ifPresent(ui -> ui.navigate(nav.get(event.getSelectedTab()))));
        addToNavbar(img, tabs);
    }

}
