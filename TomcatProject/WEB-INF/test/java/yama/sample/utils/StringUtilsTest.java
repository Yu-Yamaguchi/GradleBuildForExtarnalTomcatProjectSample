package yama.sample.utils;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class StringUtilsTest {

	@Test
	public void test取得した値がyamaであること() {

		assertThat(StringUtils.get(), is("yama"));
	}

	@Test
	public void test空文字の判別ができること() {
		assertThat(StringUtils.isEmpty(), is(true));
	}

}
