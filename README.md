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

- Add `ALBButton` in your layout xml file
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
        val albButton = findViewById<ALBButton>(R.id.alb_btn)

        albButton.setLoadingTextColor(Color.WHITE)
        albButton.setLoadingText("Loading...")
        albButton.setErrorText("Failed.")

        albButton.setOnClickListener(object: OnClickListener{
            override fun onClick(view: View) {

                //write your loading or login listener

                //if login or loading is successful, call albButton.isSuccess() method.
                //if login or loading fails, call albButton.isError() method.

            }
        })

```
