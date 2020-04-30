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
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.7")
@JsModule("@ui5/webcomponents/dist/Badge.js")
public class Ui5Badge extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Badge.class);

	public Ui5Badge() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("colorScheme", "7");
//		this.getElement().setProperty("icon", "sap-ui5");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setColor(ColorScheme color) {
		this.getElement().setProperty("colorScheme", color.toString().substring(1));
	}

	public enum ColorScheme { C1, C2, C3, C4, C5, C6, C7, C8, C9, C10 }

}
