

[![](https://jitpack.io/v/BradPatras/keyboard-visibility-event-android.svg)](https://jitpack.io/#BradPatras/keyboard-visibility-event-android)
![Kotlin](https://img.shields.io/badge/kotlin-v1.3.41-blue.svg) 
![License](https://img.shields.io/badge/license-MIT-blue.svg)

## About
A DSL to handle soft keyboard visibility change event written in Kotlin.
This fork was created to fix a null pointer exception crash due to an incorrect override function signature.

## How to use?
**Step 1.** Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```gradle
dependencies {
    implementation 'com.github.BradPatras:keyboard-visibility-event-android:1.0.10'
}
```

**Step 3.** Code example

Use the `keyboard` extension function available on `Activity` and `Fragment`
```kotlin
keyboard {
    onClosed { Toast.makeText(this@MainActivity, "onClosed", Toast.LENGTH_SHORT).show() }
    onOpened { Toast.makeText(this@MainActivity, "onOpened", Toast.LENGTH_SHORT).show() }
}
```

## Demo
<p align="center"> 
	  <img src="https://raw.githubusercontent.com/bradpatras/keyboard-visibility-event-android/master/keyboard_example.gif" width="40%" height="40%">
</p>

&nbsp;
Special thanks
--------
<a href="https://github.com/viniciusmo">@viniciusmo</a></br>
<a href="https://github.com/yshrsmz">@yshrsmz</a></br>
<a href="https://github.com/amadeu01">@amadeu01</a></br>
<a href="https://github.com/J-Jamet">@J-Jamet</a>

