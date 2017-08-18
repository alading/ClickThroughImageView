[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[ ![Download](https://api.bintray.com/packages/alading/Android/ClickThroughImageView/images/download.svg?version=1.0.2) ](https://bintray.com/alading/Android/ClickThroughImageView/1.0.2/link)

# ClickThrough_ImageView
It provides a imageview which could be click only inside its meaningful image, otherwise, it will pass beneath.

There is common request that click event should be accepted only in some special area within imageview such as actor face or animal, if the click is happend in other area, it should be ignored. However, current imageview will not provide this feature as the imageview will overtake all click event. If there 2 imageview overlap, it will cause trouble.

ClickThroughImageView(CTImageView) will provide this feature for developer.

For example: you will find the demo app which include a fox and a bamdi. Click each of them will trigger some action. If you click transparent part which might overlap with other will not take effect.

It will perfectly handle overlap imageview click handerling.


<img src="https://raw.githubusercontent.com/alading/ClickThroughImageView/master/ClickThroughImageViewDemo/screenshot/forest.gif" width="320" height="640" />




## Gradle

```java
dependencies {
	...
	compile ('com.weimin.clickthroughimageview:CTImageView:1.0.2'){
        	exclude group: 'com.android.support', module: 'appcompat-v7'
    	}
}
```

## Usage


* All customizable attributes:

```xml
	<declare-styleable name="CTImageView">
	    <attr name="keyingcolor" format="color"/>
	</declare-styleable>
```

* In XML layout: 

```xml
    <com.weimin.clickthroughimageview.CTImageView
    	xmlns:cti="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:clickable="true"
        android:src="@drawable/deadpool"  <-- It should be your drawable resource
	cti:keyingcolor="@color/color_key"  <-- It should the color key which will not reponse click 
        />
```

color_key will define the click through area. If it does not set, any transparent area is click through.


## Sample
* Clone the repository and check out the `app` module.
* Download the app [Demo-Click Through Image View](https://play.google.com/store/apps/details?id=com.applandus.ringmyphone.android) on Google Play.( will be upload soon :)

## Licence
Copyright 2017 Weimin Ding

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
