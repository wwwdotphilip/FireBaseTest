package ph.com.juan.lazy.firebasetest;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule public final ActivityRules<MainActivity> main = new ActivityRules<>(MainActivity.class);

    @Test
    public void launchMainScreen(){
        onView(withText("Hello")).check(ViewAssertions.matches(isDisplayed()));
    }
}
