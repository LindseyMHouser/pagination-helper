package com.page.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This test class contains the unit tests for PaginationHelper.pageCount()
 * method.
 * 
 * @author Lindsey Houser
 *
 */
public class PageCountTest {

	/**
	 * There are no items in the following data set.Page count should be zero for an
	 * empty data set.
	 */
	@Test
	public void testPageCount1() {

		Object[] data = {};

		PaginationHelper pageHelper = new PaginationHelper(data, 0);
		assertEquals(0, pageHelper.pageCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 10);
		assertEquals(0, pageHelper2.pageCount());

	}

	/**
	 * There is only one item in the data set. Page count should be one for a single
	 * item.
	 */
	@Test
	public void testPageCount2() {

		Object[] data = { "a" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(1, pageHelper.pageCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 5);
		assertEquals(1, pageHelper2.pageCount());
	}

	/**
	 * There are two items in the data set. We will be providing multiple 'item per
	 * page' values in this test.
	 */
	@Test
	public void testPageCount3() {

		Object[] data = { "a", "a" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(2, pageHelper.pageCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(1, pageHelper2.pageCount());

		PaginationHelper pageHelper3 = new PaginationHelper(data, 10);
		assertEquals(1, pageHelper3.pageCount());
	}

	/**
	 * Here we have a data set with numbers. Page count of a two paged data set.
	 */
	@Test
	public void testPageCount4() {

		Object[] data = { "0", "1" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(2, pageHelper.pageCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(1, pageHelper2.pageCount());

		PaginationHelper pageHelper3 = new PaginationHelper(data, 3);
		assertEquals(1, pageHelper3.pageCount());
	}

	/**
	 * We got 4 items in this data set.
	 */
	@Test
	public void testPageCount5() {

		Object[] data = { "a", "b", "c", "1" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(4, pageHelper.pageCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(2, pageHelper2.pageCount());

		PaginationHelper pageHelper3 = new PaginationHelper(data, 4);
		assertEquals(1, pageHelper3.pageCount());

		PaginationHelper pageHelper4 = new PaginationHelper(data, 5);
		assertEquals(1, pageHelper4.pageCount());
	}

	/**
	 * Here we are using a lengthy data set.
	 */
	@Test
	public void testPageCount6() {
		Object[] data = { "a", "b", "c", "1", "2", "3", "a", "b", "c", "1", "2", "3", "a", "b", "c", "a", "b", "c", "1",
				"2", "3", "a", "b", "c", "1", "2", "3", "a", "b", "c", "a", "b", "c", "1", "2", "3", "a", "b", "c", "1",
				"2", "3", "a", "b", "c" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(45, pageHelper.pageCount());

		PaginationHelper pageHelper1 = new PaginationHelper(data, 2);
		assertEquals(23, pageHelper1.pageCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 10);
		assertEquals(5, pageHelper2.pageCount());

		PaginationHelper pageHelper3 = new PaginationHelper(data, 20);
		assertEquals(3, pageHelper3.pageCount());

		PaginationHelper pageHelper4 = new PaginationHelper(data, 50);
		assertEquals(1, pageHelper4.pageCount());
	}

	/**
	 * Here we have the example data set given in the exercise.
	 */
	@Test
	public void testPageCount7() {

		Object[] data = { "a", "b", "c", "d", "e", "f" };

		PaginationHelper pageHelper = new PaginationHelper(data, 4);
		assertEquals(2, pageHelper.pageCount());
	}

}
