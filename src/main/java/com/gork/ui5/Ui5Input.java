/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Input/
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-input")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents/dist/Input.js")
public class Ui5Input extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Input.class);

	public Ui5Input() {
		LOGGER.info("constructor ...");
	}

	public void setValue(String value) {
		this.getElement().setProperty("value", value);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
