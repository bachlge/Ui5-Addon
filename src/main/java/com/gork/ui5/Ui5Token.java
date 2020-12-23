/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiInput/
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
@Tag("ui5-token")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/Token.js")
public class Ui5Token extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Token.class);

	public Ui5Token() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("slot", "tokens"); // default value
	}

	public Ui5Token(String text) {
		super();
		LOGGER.info("constructor(text) ...");
		setText(text);
	}

	public void setText(String value) {
		this.getElement().setProperty("text", value);
	}

	public void setSlot(String value) {
		this.getElement().setProperty("slot", value);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
