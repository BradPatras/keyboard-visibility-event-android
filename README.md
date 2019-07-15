<p align="center">
  <img src="https://raw.githubusercontent.com/viniciusmo/keyboard-visibility-event-android/master/logo.png">
</p>


<p align="center"> 
	<img src="https://img.shields.io/badge/kotlin-v1.3.41-blue.svg" alt="Kotlin">
	<img src="https://circleci.com/gh/viniciusmo/keyboard-visibility-event-android.svg?style=shield" alt="Build Status">
	<img src="https://img.shields.io/badge/dependencies-up%20to%20date-brightgreen.svg" alt="Dependencies">
	<img src="https://img.shields.io/github/issues/viniciusmo/keyboard-visibility-event-android.svg" alt="GitHub Issues">
	<img src="https://img.shields.io/badge/contributions-welcome-violet.svg" alt="Contributions welcome">
	<img src="https://img.shields.io/badge/license-MIT-blue.svg" alt="License">
</p>


About
--------
A DSL to handle soft keyboard visibility change event written in Kotlin.


How to use?
--------

**Step 1.** Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

**Step 2.** Add the dependency

```gradle
dependencies {
	implementation 'com.github.viniciusmo:keyboard-visibility-event-android:1.0.5'
}
```

**Step 3.** Code example
``` kotlin
keyboard {
    onClosed { Toast.makeText(this@MainActivity, "onClosed", Toast.LENGTH_SHORT).show() }
    onOpened { Toast.makeText(this@MainActivity, "onOpened", Toast.LENGTH_SHORT).show() }
}

```

Demo
--------

<p align="center"> 
	  <img src="https://raw.githubusercontent.com/viniciusmo/keyboard-visibility-event-android/master/keyboard_example.gif" width="40%" height="40%">
</p>

Special thanks
--------
<a href="https://github.com/yshrsmz">@yshrsmz</a></br>
<a href="https://github.com/amadeu01">@amadeu01</a></br>
<a href="https://github.com/J-Jamet">@J-Jamet</a>

