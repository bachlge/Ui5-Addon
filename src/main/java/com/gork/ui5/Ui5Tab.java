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
@Tag("ui5-tab")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.0-rc.6")
@JsModule("@ui5/webcomponents/dist/Tab.js")
public class Ui5Tab extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Tab.class);

	public Ui5Tab() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setText(String text) {
		this.getElement().setProperty("text", text);
	}

	public void setAdditionalText(String text) {
		this.getElement().setProperty("additionalText", text);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setSemanticColor(SemanticColor color) {
		this.getElement().setProperty("semanticColor", color.toString());
	}

	public enum SemanticColor { Default, Neutral, Positive, Critical, Negative }
	
}
