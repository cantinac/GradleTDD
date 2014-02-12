package co.cantina.example.android.bdd;

import android.os.Bundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/**
 * Created by mfremont on 2/10/14.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {

    @Test
    public void testOnCreateWithSavedState() {
        MainActivity mainActivity = new MainActivity();
        Bundle savedInstanceState = mock(Bundle.class);
    }

    @Test
    public void exampleFailingTest() {
        fail("example failure");
    }
}
