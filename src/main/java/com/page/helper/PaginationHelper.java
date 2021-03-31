package com.page.helper;

/**
 * This class supports pagination operation over a given data set.
 * 
 * @author Lindsey Houser
 *
 */
public class PaginationHelper {

	// This array holds the data set
	private Object[] data;

	private int itemsPerPage;

	/**
	 * Public constructor to create an instance of PaginationHelper
	 * 
	 * @param dataParam         Data set for the pagination
	 * @param itemsPerPageParam Count of the items for a page
	 */
	public PaginationHelper(Object[] dataParam, int itemsPerPageParam) {
		data = dataParam;
		itemsPerPage = itemsPerPageParam;
	}

	/**
	 * This method returns the number of pages which the set creates.
	 * 
	 * @return page count
	 */
	public int pageCount() {

		if (data == null || data.length == 0 || itemsPerPage <= 0) {
			return 0;
		} else if (data.length < itemsPerPage) {
			return 1;
		} else {

			int division = data.length / itemsPerPage;
			int remainder = data.length % itemsPerPage;

			if (remainder == 0) {
				return division;
			} else {
				return division + 1;
			}
		}
	}

	/**
	 * This method returns the total number of items in the given data set.
	 * 
	 * @return total item count
	 */
	public int itemCount() {
		if (data == null) {
			return 0;
		} else {
			return data.length;
		}
	}

	/**
	 * This method returns the count of the items in a given page. Page numbers are
	 * starting from 0.
	 * 
	 * @param PageNumber page number
	 * @return Item count in the page
	 */
	public int pageItemCount(int pageNumber) {

		int pageCount = this.pageCount();

		if (pageNumber < 0 || pageCount <= pageNumber || pageCount == 0) {
			return -1;
		} else {

			if (pageCount - 1 == pageNumber) {
				// Last page
				int remainder = data.length % itemsPerPage;
				if (remainder == 0) {
					return itemsPerPage;
				} else {
					return remainder;
				}
			} else {
				return itemsPerPage;
			}
		}

	}

	/**
	 * This method returns the page number of a given index of a value in the data
	 * set.
	 * 
	 * @param itemIndex Item index in the data set
	 * @return Page index the item resides
	 */
	public int pageIndex(int itemIndex) {

		if (itemIndex < 0 || this.itemCount() <= itemIndex || this.pageCount() == 0) {
			return -1;
		} else {
			int itemCountConsidering = itemIndex + 1;
			int division = itemCountConsidering / itemsPerPage;
			int remainder = itemCountConsidering % itemsPerPage;

			if (itemCountConsidering <= itemsPerPage) {
				return 0;
			} else if (remainder == 0) {
				return division - 1;
			} else {
				return division;
			}
		}
	}
}
