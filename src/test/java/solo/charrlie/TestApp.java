package solo.charrlie;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestApp extends Base
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        getDriver().get("https://github.com/bonigarcia/webdrivermanager");
        System.out.println(getDriver().getTitle());
        assertTrue( true );
    }
}
