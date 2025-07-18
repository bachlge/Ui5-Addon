/**
 * https://sap.github.io/ui5-webcomponents/components/Avatar/
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
@Tag("ui5-avatar")

@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")

@JsModule("@ui5/webcomponents/dist/Avatar.js")

public class Ui5Avatar extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Avatar.class);

	public Ui5Avatar() {
		LOGGER.info("constructor ...");
//		setIcon("employee"); // default
	}

	public Ui5Avatar(String initials) {
		this();
		setInitials(initials);
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibilityAttributes(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	/**
	 * Defines the background color of the desired image.
	 * Default: Accent6
	 * @param colorScheme
	 */
	public void setColorScheme(AvatarColorScheme colorScheme) {
		this.getElement().setProperty("colorScheme", colorScheme.toString());
	}

	public enum AvatarColorScheme { Accent1, Accent2, Accent3, Accent4, Accent5, Accent6, Accent7, Accent8, Accent9, Accent10, Placeholder }

	/**
	 * Defines whether the component is disabled. A disabled component can't be pressed or focused, and it is not in the tab chain.
	 * Default: false
	 * @param value
	 */
	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	/**
	 * convenience method
	 */
	public void setDisabled() {
		setDisabled(true);
	}

	public void setIcon(String icon) {
		this.getElement().setProperty("icon", icon);
	}

	public void setFallbackIcon(String icon) {
		this.getElement().setProperty("fallbackIcon", icon);
	}

	public void setInitials(String initials) {
		this.getElement().setProperty("initials", initials);
	}

	/**
	 * Defines if the avatar is interactive (focusable and pressable)
	 * Note: This property won't have effect if the disabled property is set to true.
	 * Default: false
	 * @param interactive
	 */
	public void setInteractive(Boolean value) {
		this.getElement().setProperty("interactive", value);
	}

	/**
	 * convenience method
	 */
	public void setInteractive() {
		setInteractive(true);
	}

	/**
	 * Default: Circle
	 * @param shape
	 */
	public void setShape(AvatarShape shape) {
		this.getElement().setProperty("shape", shape.toString());
	}

	public enum AvatarShape { Circle, Square }

	/**
	 * Default: S
	 * @param size
	 */
	public void setSize(AvatarSize size) {
		this.getElement().setProperty("size", size.toString());
	}

	public enum AvatarSize { XS, S, M, L, XL }

	/**
	 * Convenience Method
	 * Ui5CardHeader for example wants the Avatar to be put in slot `avatar`
	 * Ui5NotifcationListItem also wants the Avatar to be put in slot `avatar`
	 * therefore will apply this method
	 * @param slot
	 */
	public void setSlot(String slot) {
		this.getElement().setProperty("slot", slot);
	}

	@Deprecated
	public void setImage(String image) {
//		this.getElement().setProperty("image", image);
	}

	public void setImageUrl(String image) {
		this.getElement().setProperty("image", image);
	}

	@Deprecated
	public void setImageFitType(ImageFitType type) {
		this.getElement().setProperty("imageFitType", type.toString());
	}

	@Deprecated
	public enum ImageFitType { Contain, Cover }

	
}
