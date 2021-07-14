# AnimatedLoadingButton

![Jit](https://img.shields.io/jitpack/v/github/kojofosu/AnimatedLoadingButton?style=for-the-badge) 

## Setup

Add it in your root `build.gradle` at the end of repositories:

```groovy
allprojects {
    repositories {
        //...omitted for brevity
        maven { url 'https://jitpack.io' }
    }
}
```



Add the dependency

```groovy
dependencies {
   implementation "com.github.kojofosu:AnimatedLoadingButton:$latest_release"
}
```

## Usage
Sample implementation [here](app/)

- Add `FilledBoxSpinner` in your layout xml file
```xml
    <com.mcdev.animatedloadingbutton.ALBButton
        android:id="@+id/alb_btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:default_text="Login"
        app:success_text="Yipee!"
        app:loading_text="Loading..."
        android:layout_marginTop="40dp"
        android:gravity="center"/>
```

### Kotlin implementation
- you call `isSuccess()` to activate success button and `isError()` to activate error button.

```kotlin
        val alb_btn = findViewById<ALBButton>(R.id.alb_btn)
        val sBtn = findViewById<Button>(R.id.s_btn)
        val eBtn = findViewById<Button>(R.id.e_btn)

        alb_btn.setLoadingTextColor(Color.WHITE)
        alb_btn.setLoadingText("Loading...")

        alb_btn.setErrorText("Failed.")

        sBtn.setOnClickListener {
            alb_btn.isSuccess()
        }

        eBtn.setOnClickListener {
            alb_btn.isError()
        }
```
