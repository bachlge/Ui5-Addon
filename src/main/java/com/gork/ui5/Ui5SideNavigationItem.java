/**
 * https://sap.github.io/ui5-webcomponents/playground/components/SideNavigation/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-side-navigation-item")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.4.0")
@JsModule("@ui5/webcomponents-fiori/dist/SideNavigationItem.js")
public class Ui5SideNavigationItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SideNavigationItem.class);

	public Ui5SideNavigationItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setExpanded(Boolean value) {
		this.getElement().setProperty("expanded", value);
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

	public void setWholeItemToggleable(Boolean value) {
		this.getElement().setProperty("wholeItemToggleable", value);
	}

}
