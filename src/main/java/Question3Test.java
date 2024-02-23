import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Question3Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSameNum() {
		int[] nums = { 2, 3, 1, 0, 4, 5, 7, 6, 4, };
		assertEquals(4, Question3.getSameNum(nums));

		int[] nums1 = { 2, 3, 1, 0, 6, 5, 7, 6, 4, };
		assertEquals(6, Question3.getSameNum(nums1));

		int[] nums2 = { 2, 3, 1, 0, 4, 5, 7, 6, 7, };
		assertEquals(7, Question3.getSameNum(nums2));

		int[] nums3 = { 2, 3, 1, 0, 4, 5, 7, 6, 4, 8, 9, 10 };
		assertEquals(4, Question3.getSameNum(nums3));
	}

}
