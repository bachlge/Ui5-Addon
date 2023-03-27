/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Breadcrumbs/
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
@Tag("ui5-menu-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.11.0")
@JsModule("@ui5/webcomponents/dist/MenuItem.js")
public class Ui5MenuItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5MenuItem.class);

	public Ui5MenuItem() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Defines whether the component is disabled.
	 * A disabled component can't be pressed or focused, and it is not in the tab chain.
	 * default: false
	 * @param value
	 */
	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	/**
	 * Defines whether a visual separator should be rendered before the item.
	 * default: false
	 * @param startsSection
	 */
	public void setStartsSection(Boolean startsSection) {
		this.getElement().setProperty("startsSection", startsSection);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

}
