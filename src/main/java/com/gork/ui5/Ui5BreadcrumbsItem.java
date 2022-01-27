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
@Tag("ui5-breadcrumbs-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Breadcrumbs.js")
public class Ui5BreadcrumbsItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5BreadcrumbsItem.class);

	public Ui5BreadcrumbsItem() {
		LOGGER.info("constructor ...");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setHref(String href) {
		this.getElement().setProperty("href", href);
	}

	public void setTarget(Target target) {
		this.getElement().setProperty("target", target.toString());
	}

	public enum Target { _self, _top, _blank, _parent, _search }

}
