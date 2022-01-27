/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Breadcrumbs/
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
@Tag("ui5-breadcrumbs")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Breadcrumbs.js")
public class Ui5Breadcrumbs extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Breadcrumbs.class);

	public Ui5Breadcrumbs() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	/**
	 * Defines the visual indication and behavior of the breadcrumbs.
	 * Default: Standard
	 * @param design
	 */
	public void setDesign(BreadcrumbsDesign design) {
		this.getElement().setProperty("design", design.toString());
	}

	public enum BreadcrumbsDesign { Standard, NoCurrentPage }

	/**
	 * Determines the visual style of the separator between the breadcrumb items.
	 * Default: Slash
	 * @param separatorStyle
	 */
	public void setSeparatorStyle(BreadcrumbsSeparatorStyle separatorStyle) {
		this.getElement().setProperty("separatorStyle", separatorStyle.toString());
	}

	public enum BreadcrumbsSeparatorStyle { Slash, BackSlash, DoubleBackSlash, DoubleGreaterThan, DoubleSlash, GreaterThan }


}
