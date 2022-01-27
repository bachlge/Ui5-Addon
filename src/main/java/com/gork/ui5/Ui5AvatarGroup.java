/**
 * https://sap.github.io/ui5-webcomponents/playground/components/AvatarGroup/
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
@Tag("ui5-avatar-group")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/AvatarGroup.js")
public class Ui5AvatarGroup extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5AvatarGroup.class);

	public Ui5AvatarGroup() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setType(AvatarTypeGroup type) {
		this.getElement().setProperty("type", type.toString());
	}

	public enum AvatarTypeGroup { Group, Individual }

}
