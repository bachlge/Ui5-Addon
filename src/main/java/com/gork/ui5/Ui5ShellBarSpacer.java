/**
 * https://ui5.github.io/webcomponents/components/fiori/ShellBarSpacer/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-shell-bar-spacer")
@NpmPackage(value = "@ui5/webcomponents-fiori", version = "^2.22.0")
@JsModule("@ui5/webcomponents-fiori/dist/ShellBarSpacer.js")
public class Ui5ShellBarSpacer extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5ShellBarSpacer.class);

	public Ui5ShellBarSpacer() {
		LOGGER.info("constructor ...");
	}

}
