import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class Question1Test {

	@Test
	void testSpliteString() {
		String origin1 = "&&&asdf&& asd && s &  & 23i&";
		String origin2 = "&&  asd && s &  & 23i&&";

		String origin3 = "&&";
		String origin4 = "&";
		String origin5 = "";
		assertEquals("&asdf asd  s &  & 23i&", concatStrList(Question1.spliteString(origin1)));
		assertEquals("  asd  s &  & 23i", concatStrList(Question1.spliteString(origin2)));
		assertEquals("", concatStrList(Question1.spliteString(origin3)));
		assertEquals("&", concatStrList(Question1.spliteString(origin4)));
		assertEquals("", concatStrList(Question1.spliteString(origin5)));

	}

	String concatStrList(List<String> listStr) {
		StringBuilder sb = new StringBuilder();
		for (String item : listStr) {
			sb.append(item);
		}
		return sb.toString();
	}

	@Test
	void testJoinStr() {
		String origin1 = "&&&asdf&& asd && s &  & 23i&";
		String origin2 = "&&  asd && s &  & 23i&&";

		String origin3 = "&&";
		String origin4 = "&";
		String origin5 = "";
		String origin6 = "a&&b";
		String origin7 = "b&a";
		String origin8 = "a&&";
		String origin9 = "&b";
		String listStr[] = { origin1, origin2, origin3, origin4, origin5, origin6, origin7, origin8, origin9, };

		for (String itm : listStr) {
			String compositStr = Question1.joinString(Question1.spliteString(itm));
			assertEquals(compositStr, itm);
		}

	}

}
