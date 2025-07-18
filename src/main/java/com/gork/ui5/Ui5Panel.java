/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Panel/
 * 
 * The ui5-panel component is a container which has a header and a content area
 * and is used for grouping and displaying information.
 * It can be collapsed to save space on the screen.
 * 
 * Guidelines:
 * Nesting two or more panels is not recommended.
 * Do not stack too many panels on one page.
 * 
 * Structure
 * The panel's header area consists of a title bar with a header text or custom header.
 * The header is clickable and can be used to toggle between the expanded and collapsed state.
 * It includes an icon which rotates depending on the state.
 * The custom header can be set through the header slot and it may contain arbitraray content, such as:
 * title, buttons or any other HTML elements.
 * The content area can contain an arbitrary set of controls.
 * 
 * Note: The custom header is not clickable out of the box, but in this case the icon is interactive
 * and allows to show/hide the content area.
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
@Tag("ui5-panel")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/Panel.js")
public class Ui5Panel extends Component implements HasComponents, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Panel.class);

	public Ui5Panel() {
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleRole(String accessibleRole) {
		this.getElement().setProperty("accessibleRole", accessibleRole);
	}

	/**
	 * default: false
	 */
	public void setCollapsed(boolean value) {
		this.getElement().setProperty("collapsed", value);
	}

	/**
	 * convenience method
	 */
	public void setCollapsed() {
		setCollapsed(true);
	}


	/**
	 * default: false
	 */
	public void setFixed(boolean value) {
		this.getElement().setProperty("fixed", value);
	}

	/**
	 * convenience method
	 */
	public void setFixed() {
		setFixed(true);
	}

	/**
	 * default: false
	 */
	public void setNoAnimation(boolean value) {
		this.getElement().setProperty("noAnimation", value);
	}

	/**
	 * convenience method
	 */
	public void setNoAnimation() {
		setNoAnimation(true);
	}

	/**
	 * default: false
	 */
	public void setStickyHeader(boolean value) {
		this.getElement().setProperty("stickyHeader", value);
	}

	/**
	 * convenience method
	 */
	public void setStickyHeader() {
		setStickyHeader(true);
	}

	/**
	 * Default: H2
	 * @param HeaderLevel
	 */
	public void setHeaderLevel(HeaderLevel HeaderLevel) {
		this.getElement().setProperty("headerLevel", HeaderLevel.toString());
	}

	public enum HeaderLevel { H1, H2, H3, H4, H5, H6 }

	public void setHeaderText(String headerText) {
		this.getElement().setProperty("headerText", headerText);
	}

	public void addToHeader(Component component) {
		component.getElement().setAttribute("slot", Slot.header.toString());
		add(component);
	}

	/**
	 * there is also a slot `defaut` which is omitted because of default is a keyword
	 */
	public enum Slot {
		header,
	}

	public void setNoAnimation(Boolean value) {
		this.getElement().setProperty("noAnimation", value);
	}

}
