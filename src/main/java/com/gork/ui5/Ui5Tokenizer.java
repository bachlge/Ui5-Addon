/**
 * https://sap.github.io/ui5-webcomponents/playground/components/MultiInput/
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@SuppressWarnings("serial")
@Tag("ui5-tokenizer")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/Tokenizer.js")
public class Ui5Tokenizer extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Tokenizer.class);

	public Ui5Tokenizer() {
		LOGGER.info("constructor ...");
	}

}
