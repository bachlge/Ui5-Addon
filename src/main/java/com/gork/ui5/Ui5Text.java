/**
 * https://sap.github.io/ui5-webcomponents/components/Text/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-text")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/Text.js")
public class Ui5Text extends Component implements HasComponents, HasStyle {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Text.class);

	public Ui5Text() {
		LOGGER.info("constructor ...");
	}

	public Ui5Text(String value) {
		this();
		add(value);
	}

	public void setMaxLines(int value) {
		this.getElement().setProperty("maxLines", value);
	}

}
