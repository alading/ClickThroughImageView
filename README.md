# ClickThrough_ImageView
It is common that you only want the Imageview accept click event on some special area such as Actor , if the click is happend in other area, it shoudl pass through to beathe
It provides a imageview which could be click only inside its key image, otherwise, it will pass beneath.


## Gradle

```java
dependencies {
	...
	compile 'com.dualcores.swagpoints:swagpoints:1.0.2'
}
```

## Usage

* In XML layout: 

```xml
    <com.weimin.clickthroughimageview.CTImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:clickable="true"
        android:src="@drawable/deadpool" 
        />
```
## Sample
* Clone the repository and check out the `app` module.
* Download the app [Swag – Exchange Personal Snaps](https://play.google.com/store/apps/details?id=com.machipopo.swag) on Google Play. This widget is used in the send point dialog.

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
