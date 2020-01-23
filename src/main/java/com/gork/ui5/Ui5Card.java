package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-card")
@JsModule("@ui5/webcomponents/dist/Card.js")
@JsModule("@ui5/webcomponents-icons/dist/icons/example.js")
public class Ui5Card extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Card.class);

	public Ui5Card() {
		LOGGER.info("constructor ...");
		setIcon("example"); // default icon
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setIcon(String icon) {
		Ui5Icon ui5Icon = new Ui5Icon();
		ui5Icon.setIcon(icon);
		ui5Icon.getElement().setProperty("slot", "avatar");
		add(ui5Icon);
		// docu says: <ui5-card avatar="group" heading="Team Space" ...>
		// but: (Error) : Cannot set slots directly, use the DOM APIs
//		this.getElement().setProperty("avatar", icon);
	}

	public void setTitle(String title) {
		this.getElement().setProperty("heading", title);
	}

	public void setSubTitle(String title) {
		this.getElement().setProperty("subtitle", title);
	}

	public void setStatus(String status) {
		this.getElement().setProperty("status", status);
	}

}
