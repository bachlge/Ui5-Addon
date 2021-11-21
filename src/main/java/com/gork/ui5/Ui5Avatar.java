/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Avatar/
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
@Tag("ui5-avatar")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.0.1")
@JsModule("@ui5/webcomponents/dist/Avatar.js")
public class Ui5Avatar extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Avatar.class);

	public Ui5Avatar() {
		LOGGER.info("constructor ...");
		setSize(AvatarSize.S); // default
		setIcon("employee"); // default
	}

	public Ui5Avatar(String initials) {
		this();
		setInitials(initials);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setImage(String image) {
		this.getElement().setProperty("image", image);
	}

	public void setShape(Shape shape) {
		this.getElement().setProperty("shape", shape.toString());
	}

	public void setSize(AvatarSize size) {
		this.getElement().setProperty("size", size.toString());
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setInitials(String initials) {
		this.getElement().setProperty("initials", initials);
	}

	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	public void setBackgroundColor(BackgroundColor color) {
		this.getElement().setProperty("backgroundColor", color.toString());
	}

	public void setImageFitType(ImageFitType type) {
		this.getElement().setProperty("imageFitType", type.toString());
	}

	public enum ImageFitType { Contain, Cover }
	public enum BackgroundColor { Accent1, Accent2, Accent3, Accent4, Accent5, Accent6, Accent7, Accent8, Accent9, Accent10, Placeholder }
	public enum Shape { Circle, Square }
	public enum AvatarSize { XS, S, M, L, XL }

}
