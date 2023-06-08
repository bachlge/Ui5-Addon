# UI5 Vaadin-Addon

Java classes wrapping UI5 webcomponents
 
## Usage

add dependency in your `pom.xml`:

```
<dependency>
   <groupId>com.gork</groupId>
   <artifactId>ui5-addon</artifactId>
   <version>1.0.0</version>
</dependency>
```

additionally add in the using application the dependencies like (don't know why this is necessary!)

```
1. open console
2. go to project root dir, eg:
cd /Users/georg/Develop/vaadin/flow/ui5-addon-demo
cd /Users/georg/Develop/vaadin/flow/fam
3. run scripts
npm install @ui5/webcomponents
npm install @ui5/webcomponents-fiori

```



## Demo Application

see ui5-addon-demo how the components are used.

## Components and their features

Component 				| HasComponents	| Binding		| Event				|<br>
Ui5Avatar				| no				| no				|					|<br>
| Ui5AvatarGroup			| yes			| no				|					|<br>
| Ui5Badge				| yes			| no				| 					|<br>
| Ui5Bar					| yes			| no				| 					|<br>
| Ui5Button				| no				| no				| click				|<br>
| Ui5Input				| no				| yes:String		| change				|<br>
| Ui5Label				| no				| no				| click				|<br>
| Ui5RadioButton			| no				| no				| select				|<br>
| Ui5AvatarGroup			| yes			| no				|					|<br>
| Ui5RatingIndicator		| no				| yes: Integer	| change				|<br>
| Ui5Timeline			| no				| no				|					|<br>
| Ui5TimelineItem		| no				| no				| item-name-click	|<br>
| Ui5ToggleButton		| no				| yes: Boolean	| click				|<br>
---

Binding ... means that the component is extending AbstractSinglePropertyField
HasComponents ... Components can be added 
Event ... Listeners can be attached for listed event(s)

For a full list, visit the [Playground](https://sap.github.io/ui5-webcomponents/playground/components) or have a look on the Sources in [Github](https://github.com/SAP/ui5-webcomponents)

## Events that have been successfully tested in the demo application

- Ui5Checkbox change (returns one boolean value)
- Ui5RadioButton change (returns no value)
- Ui5Slider change (returns one float value)
- Ui5Switch change (returns one boolean value)
- Ui5ToggleButton change (returns one boolean value)

## Events that need furter investigation

- Ui5Breadcrumbs item-click (complicated hadling, should it be added on Item level?)
- Ui5Button click (component event fires, npe in demo application)
- Ui5RangeSlider change (fires twice, should return two values, returns none)
- Ui5ToggleButton change (always is false, what is really returned in @EventData("element.pressed")?)



## Known bugs & limitations

- bug: Ui5BusyIndicator: does not show
- bug: Ui5Card: setIcon() should replace the default icon but adds instead
- bug: Ui5Badge: should be possible to add icon/icon only
- general: no listeners yet implemented on buttons/menus 
- general: data binding not yet implemented 



