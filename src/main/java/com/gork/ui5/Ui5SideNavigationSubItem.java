/**
 * https://sap.github.io/ui5-webcomponents/playground/components/SideNavigation/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-side-navigation-sub-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.1.1")
@JsModule("@ui5/webcomponents-fiori/dist/SideNavigationSubItem.js")
public class Ui5SideNavigationSubItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SideNavigationSubItem.class);

	public Ui5SideNavigationSubItem() {
		LOGGER.info("constructor ...");
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setSelectded(Boolean value) {
		this.getElement().setProperty("selected", value);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

}
