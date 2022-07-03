/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Badge/
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
@Tag("ui5-badge")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.4.0")
@JsModule("@ui5/webcomponents/dist/Badge.js")
public class Ui5Badge extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Badge.class);

	public Ui5Badge() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	/**
	 * There are 10 predefined schemes
	 * To use one you can set a number from "1" to "10"
	 * default: 1
	 * @param color
	 */
	public void setColorScheme(ColorScheme color) {
		this.getElement().setProperty("colorScheme", color.toString().substring(1));
	}

	public enum ColorScheme { C1, C2, C3, C4, C5, C6, C7, C8, C9, C10 }

	/**
	 * Convenience Method
	 * @param icon
	 */
	public void addIcon(Ui5Icon icon) {
		icon.setSlot("icon");
		add(icon);
	}

}
