package co.cantina.example.android.tdd;

import android.os.Bundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example unit test suite for {@link MainActivity}.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {

    /**
     * Minimalist unit test to demonstrate unit testing behavior for onCreate().
     */
    @Test
    public void testOnCreateWithSavedState() {
        // Given a Bundle with saved application state
        final String exampleState = "some string";
        Bundle bundle = mock(Bundle.class);
        when(bundle.get(eq(MainActivity.EXAMPLE_STATE))).thenReturn(exampleState);
        when(bundle.getString(eq(MainActivity.EXAMPLE_STATE))).thenReturn(exampleState);

        // When the Activity is created with the Bundle
        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create(bundle).get();
        //mainActivity.onCreate(bundle);

        // Then saved state is restored
        assertEquals("restored state", exampleState, mainActivity.exampleState);
    }
}
