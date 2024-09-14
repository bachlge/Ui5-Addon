/**
 * https://sap.github.io/ui5-webcomponents/components/Form/
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
@Tag("ui5-form")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.1.1")
@JsModule("@ui5/webcomponents/dist/Form.js")
public class Ui5Form extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Form.class);

	public enum Layout { S, M, L, XL }
	public enum ItemSpacing { Normal, Large }

	public Ui5Form() {
		LOGGER.info("constructor ...");
	}

	/**
	 * Default "S1 M1 L2 XL2"
	 */
	public void setLayout(String layout) {
		this.getElement().setProperty("layout", layout);
	}

	/**
	 * Default "S12 M4 L4 XL4"
	 */
	public void setLabelSpan(String labelSpan) {
		this.getElement().setProperty("labelSpan", labelSpan);
	}

	public void setHeaderText(String headerText) {
		this.getElement().setProperty("headerText", headerText);
	}

	/**
	 * Type	"Normal" | "Large"
	 * Default"Normal"
	 */
	public void setItemSpacing(ItemSpacing itemSpacing) {
		this.getElement().setProperty("itemSpacing", itemSpacing.toString());
	}

}
