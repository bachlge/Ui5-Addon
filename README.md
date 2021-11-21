# UI5 Vaadin-Addon

Java classes wrapping UI5 webcomponents
 
## Usage

add dependency in your `pom.xml`:

```
<dependency>
   <groupId>com.gork</groupId>
   <artifactId>ui5-addon</artifactId>
   <version>1.0-SNAPSHOT</version>
</dependency>
```

additionally add in the using application the dependencies like (don't know why this is necessary!)

```
cd /Users/georg/Develop/vaadin/flow/ui5-addon-demo
npm install @ui5/webcomponents
npm install @ui5/webcomponents-fiori
```

## Demo Application

see ui5-addon-demo how the components are used.

## Components and their features

---
| Component 				| HasComponents	| Binding		| Event			|<br>
| --- 					| ---	 		| ---	 		| --- 			|<br>
| Ui5Avatar				| no				| no				|				|<br>
| Ui5AvatarGroup			| yes			| no				|				|<br>
| Ui5Badge				| yes			| no				| 				|<br>
| Ui5Bar					| yes			| no				| 				|<br>
| Ui5Button				| no				| no				| click			|<br>
| Ui5Input				| no				| yes:String		| change			|<br>
| Ui5Label				| no				| no				| click			|<br>
| Ui5RadioButton			| no				| no				| select			|<br>
| Ui5AvatarGroup			| yes			| no				|				|<br>
| Ui5RatingIndicator		| no				| yes: Integer	| change			|<br>
| Ui5Timeline			| no				| no				|				|<br>
| Ui5TimelineItem		| no				| no				| item-name-click	|<br>
| Ui5ToggleButton		| no				| yes: Boolean	| click			|<br>
---

Binding ... means that the component is extending AbstractSinglePropertyField
HasComponents ... Components can be added 
Event ... Listeners can be attached for listed event(s)

For a fUll list, visit the [Playground](https://sap.github.io/ui5-webcomponents/playground/components) or have a look on the Sources in [Github](https://github.com/SAP/ui5-webcomponents)

## Known bugs & limitations

- bug: Ui5BusyIndicator: does not show
- bug: Ui5Card: setIcon() should replace the default icon but adds instead
- bug: Ui5Badge: should be possible to add icon/icon only
- general: no listeners yet implemented on buttons/menus 
- general: data binding not yet implemented 



