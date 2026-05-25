/**
 * https://ui5.github.io/webcomponents/components/fiori/SideNavigationGroup/
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
@Tag("ui5-side-navigation-group")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.22.0")
@JsModule("@ui5/webcomponents-fiori/dist/SideNavigationGroup.js")
public class Ui5SideNavigationGroup extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SideNavigationGroup.class);

	public Ui5SideNavigationGroup() {
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String text) {
		this.getElement().setProperty("accessibleName", text);
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	/**
	 * Default: false
	 */
	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	/**
	 * convenience method
	 */
	public void setDisabled() {
		this.setDisabled();
	}

	/**
	 * Default: false
	 */
	public void setExpanded(Boolean value) {
		this.getElement().setProperty("expanded", value);
	}

	/**
	 * convenience method
	 */
	public void setExpanded() {
		this.setExpanded();
	}

	public void setTooltip(String text) {
		this.getElement().setProperty("tooltip", text);
	}


}
