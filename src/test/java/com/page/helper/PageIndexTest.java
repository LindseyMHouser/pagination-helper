package com.page.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This test class contains the unit tests for PaginationHelper.pageIndex()
 * method.
 * 
 * @author Lindsey Houser
 *
 */
public class PageIndexTest {

	/**
	 * There are no items in the following data set.Page count should be zero for an
	 * empty data set.
	 */
	@Test
	public void testPageCount1() {

		Object[] data = {};

		PaginationHelper pageHelper = new PaginationHelper(data, 0);
		assertEquals(-1, pageHelper.pageIndex(0));

		PaginationHelper pageHelper2 = new PaginationHelper(data, 10);
		assertEquals(-1, pageHelper2.pageIndex(1));

		PaginationHelper pageHelper3 = new PaginationHelper(data, 1);
		assertEquals(-1, pageHelper3.pageIndex(-1));

	}

	/**
	 * There is only one item in the data set. Page count should be one for a single
	 * item.
	 */
	@Test
	public void testPageCount2() {

		Object[] data = { "a" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(0, pageHelper.pageIndex(0));
		assertEquals(-1, pageHelper.pageIndex(1));
		assertEquals(-1, pageHelper.pageIndex(-2));

		PaginationHelper pageHelper2 = new PaginationHelper(data, 4);
		assertEquals(0, pageHelper2.pageIndex(0));
		assertEquals(-1, pageHelper2.pageIndex(1));
	}

	/**
	 * There are two items in the data set. We will be providing multiple 'item per
	 * page' values in this test.
	 */
	@Test
	public void testPageCount3() {

		Object[] data = { "a", "a" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(0, pageHelper.pageIndex(0));
		assertEquals(1, pageHelper.pageIndex(1));
		assertEquals(-1, pageHelper.pageIndex(2));

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(0, pageHelper2.pageIndex(0));
		assertEquals(0, pageHelper2.pageIndex(1));
		assertEquals(-1, pageHelper2.pageIndex(2));

		PaginationHelper pageHelper3 = new PaginationHelper(data, 10);
		assertEquals(0, pageHelper3.pageIndex(0));
		assertEquals(0, pageHelper3.pageIndex(1));
		assertEquals(-1, pageHelper3.pageIndex(2));

	}

	/**
	 * Here we have a data set with numbers. Page count of a two paged data set.
	 */
	@Test
	public void testPageCount4() {

		Object[] data = { "0", "1" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(0, pageHelper.pageIndex(0));
		assertEquals(1, pageHelper.pageIndex(1));
		assertEquals(-1, pageHelper.pageIndex(2));

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(0, pageHelper2.pageIndex(0));
		assertEquals(0, pageHelper2.pageIndex(1));
		assertEquals(-1, pageHelper2.pageIndex(2));

		PaginationHelper pageHelper3 = new PaginationHelper(data, 10);
		assertEquals(0, pageHelper3.pageIndex(0));
		assertEquals(0, pageHelper3.pageIndex(1));
		assertEquals(-1, pageHelper3.pageIndex(2));
	}

	/**
	 * We got 4 items in this data set.
	 */
	@Test
	public void testPageCount5() {

		Object[] data = { "a", "b", "c", "1" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(0, pageHelper.pageIndex(0));
		assertEquals(3, pageHelper.pageIndex(3));
		assertEquals(-1, pageHelper.pageIndex(5));

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(0, pageHelper2.pageIndex(1));
		assertEquals(1, pageHelper2.pageIndex(2));
		assertEquals(-1, pageHelper2.pageIndex(5));

		PaginationHelper pageHelper3 = new PaginationHelper(data, 4);
		assertEquals(0, pageHelper3.pageIndex(0));
		assertEquals(0, pageHelper3.pageIndex(1));
		assertEquals(-1, pageHelper3.pageIndex(10));

		PaginationHelper pageHelper4 = new PaginationHelper(data, 5);
		assertEquals(0, pageHelper4.pageIndex(0));
		assertEquals(0, pageHelper4.pageIndex(1));
		assertEquals(-1, pageHelper4.pageIndex(5));
	}

	/**
	 * Here we are using a lengthy data set with 45 items.
	 */
	@Test
	public void testPageCount6() {
		Object[] data = { "a", "b", "c", "1", "2", "3", "a", "b", "c", "1", "2", "3", "a", "b", "c", "a", "b", "c", "1",
				"2", "3", "a", "b", "c", "1", "2", "3", "a", "b", "c", "a", "b", "c", "1", "2", "3", "a", "b", "c", "1",
				"2", "3", "a", "b", "c" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(1, pageHelper.pageIndex(1));
		assertEquals(2, pageHelper.pageIndex(2));
		assertEquals(-1, pageHelper.pageIndex(50));

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(0, pageHelper2.pageIndex(1));
		assertEquals(1, pageHelper2.pageIndex(2));
		assertEquals(-1, pageHelper2.pageIndex(50));

		PaginationHelper pageHelper3 = new PaginationHelper(data, 20);
		assertEquals(0, pageHelper3.pageIndex(0));
		assertEquals(1, pageHelper3.pageIndex(25));
		assertEquals(2, pageHelper3.pageIndex(44));

		PaginationHelper pageHelper4 = new PaginationHelper(data, 50);
		assertEquals(0, pageHelper4.pageIndex(0));
		assertEquals(0, pageHelper4.pageIndex(44));
		assertEquals(-1, pageHelper4.pageIndex(45));
		assertEquals(-1, pageHelper4.pageIndex(60));

	}

	/**
	 * Here we have the example data set given in the exercise.
	 */
	@Test
	public void testPageCount7() {

		Object[] data = { "a", "b", "c", "d", "e", "f" };

		PaginationHelper pageHelper = new PaginationHelper(data, 4);
		assertEquals(1, pageHelper.pageIndex(5));
		assertEquals(0, pageHelper.pageIndex(2));
		assertEquals(-1, pageHelper.pageIndex(20));
		assertEquals(-1, pageHelper.pageIndex(-10));
	}

}
