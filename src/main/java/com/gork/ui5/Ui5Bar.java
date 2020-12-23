/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Bar/
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
@Tag("ui5-bar")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^1.0.0-rc.11")
@JsModule("@ui5/webcomponents-fiori/dist/Bar.js")
public class Ui5Bar extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Bar.class);

	public Ui5Bar() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
