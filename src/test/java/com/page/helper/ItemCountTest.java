package com.page.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This test class contains the unit tests for PaginationHelper.itemCount()
 * method.
 * 
 * @author Lindsey Houser
 *
 */
public class ItemCountTest {

	/**
	 * There are no items in the following data set. Item count should be zero for
	 * an empty data set.
	 */
	@Test
	public void testPageCount1() {

		Object[] data = {};

		PaginationHelper pageHelper = new PaginationHelper(data, 0);
		assertEquals(0, pageHelper.itemCount());

	}

	/**
	 * There is only one item in the data set. Item count should be one for a single
	 * item.
	 */
	@Test
	public void testPageCount2() {

		Object[] data = { "a" };

		PaginationHelper pageHelper = new PaginationHelper(data, 5);
		assertEquals(1, pageHelper.itemCount());

	}

	/**
	 * There are two items in the data set.
	 */
	@Test
	public void testPageCount3() {

		Object[] data = { "a", "a" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(2, pageHelper.itemCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 2);
		assertEquals(2, pageHelper2.itemCount());

	}

	/**
	 * Here we have a data set with numbers. Page count of a two paged data set.
	 */
	@Test
	public void testPageCount4() {

		Object[] data = { "0", "1" };

		PaginationHelper pageHelper = new PaginationHelper(data, 1);
		assertEquals(2, pageHelper.itemCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 10);
		assertEquals(2, pageHelper2.itemCount());

	}

	/**
	 * We got 4 items in this data set.
	 */
	@Test
	public void testPageCount5() {

		Object[] data = { "a", "b", "c", "1" };

		PaginationHelper pageHelper = new PaginationHelper(data, 2);
		assertEquals(4, pageHelper.itemCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 4);
		assertEquals(4, pageHelper2.itemCount());

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
		assertEquals(45, pageHelper.itemCount());

		PaginationHelper pageHelper1 = new PaginationHelper(data, 40);
		assertEquals(45, pageHelper1.itemCount());

		PaginationHelper pageHelper2 = new PaginationHelper(data, 50);
		assertEquals(45, pageHelper2.itemCount());

	}

	/**
	 * Here we have the example data set given in the exercise.
	 */
	@Test
	public void testPageCount7() {

		Object[] data = { "a", "b", "c", "d", "e", "f" };

		PaginationHelper pageHelper = new PaginationHelper(data, 4);
		assertEquals(6, pageHelper.itemCount());
	}

}
