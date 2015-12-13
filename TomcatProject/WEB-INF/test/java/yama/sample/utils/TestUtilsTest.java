package yama.sample.utils;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestUtilsTest {

	@Test
	public void testテストの結果がfalseであること() {

		assertThat(TestUtils.test(), is(false));
	}

}
