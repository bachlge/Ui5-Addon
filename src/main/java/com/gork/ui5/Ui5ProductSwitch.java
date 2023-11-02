/**
 * 
 * https://sap.github.io/ui5-webcomponents/playground/components/ProductSwitch/
 * 
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-product-switch")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.19.0")
@JsModule("@ui5/webcomponents-fiori/dist/ProductSwitch.js")
public class Ui5ProductSwitch extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ProductSwitch.class);

	public Ui5ProductSwitch() {
		LOGGER.info("constructor ...");
		setWidthFull();
//		this.getElement().setProperty("slot", "default");
	}

	/**
	 * Convienience Method
	 * @param component
	 * @param slot
	 */
	public void addTo(Component component, String slot) {
		component.getElement().setAttribute("slot", slot);
		this.add(component);
	}

}
