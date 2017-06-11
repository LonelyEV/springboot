/**
 * Project Name:springboot
 * File Name:QueryBase.java
 * Package Name:com.example.springboot.common
 * Date:2017年6月11日下午6:09:30
 * Copyright (c) 2017, Shanghai Law Cloud Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.example.springboot.common;

import java.io.Serializable;

/**
 * ClassName:QueryBase <br/>
 * Function: 分页基类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月11日 下午6:09:30 <br/>
 * @author   屈志刚  598700560@qq.com
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class QueryBase implements Serializable {

	public QueryBase() {
		needQeryTotal = false;
		needDelete = false;
		needQueryAll = false;
		language = "en_US";
		currentUserName = "";
	}

	protected final Integer getDefaultPageSize() {
		return defaultPageSize;
	}

	public Integer getCurrentPage() {
		if (currentPage == null) {
			currentPage = pageNumber;
		}

		if (currentPage == null)
			return defaultFriatPage;
		else
			return currentPage;
	}

	public void setCurrentPage(Integer cPage) {
		if (cPage == null || cPage.intValue() <= 0)
			currentPage = defaultFriatPage;
		else
			currentPage = cPage;
	}

	public Integer getPageSize() {
		if (pageSize == null)
			return getDefaultPageSize();
		else
			return pageSize;
	}

	public boolean hasSetPageSize() {
		return pageSize != null;
	}

	public void setPageSize(Integer pSize) {
		this.pageSize = pSize;
	}

	public Integer getTotalItem() {
		if (totalItem == null)
			return defaultTotleItem;
		else
			return totalItem;
	}

	public void setTotalItem(Integer tItem) {
		if (tItem == null)
			tItem = new Integer(0);
		totalItem = tItem;
	}

	public int getTotalPage() {
		int pgSize = getPageSize().intValue();
		int total = getTotalItem().intValue();
		int result = total / pgSize;
		if (total % pgSize != 0)
			result++;
		return result;
	}

	public int getPageFristItem() {
		if (!needQeryTotal) {
			int cPage = getCurrentPage().intValue();
			if (cPage == 1) {
				return 1;
			} else {
				cPage--;
				int pgSize = getPageSize().intValue();
				return pgSize * cPage + 1;
			}
		} else {
			return 0;
		}
	}

	public int getPageLastItem() {
		if (!needQeryTotal) {
			int cPage = getCurrentPage().intValue();
			int pgSize = getPageSize().intValue();
			int assumeLast = pgSize * cPage;
			int totalItem = getTotalItem().intValue();
			if (assumeLast > totalItem)
				return totalItem;
			else
				return assumeLast;
		} else {
			return getTotalItem().intValue();
		}
	}

	public int getEndRow() {

		if (currentPage == null) {
			currentPage = 1;
		}
		return currentPage * pageSize;
	}

	public int getStartRow() {

		if (currentPage == null) {
			currentPage = pageNumber;
		}

		if (currentPage == null) {
			currentPage = 1;
		}
		return (currentPage - 1) * this.getPageSize();
	}

	protected String getSQLBlurValue(String value) {
		if (value == null)
			return null;
		else
			return (new StringBuilder(String.valueOf(value))).append('%').toString();
	}

	public boolean isNeedQeryTotal() {
		return needQeryTotal;
	}

	public void setNeedQeryTotal(boolean needQeryTotal) {
		this.needQeryTotal = needQeryTotal;
	}

	public boolean isNeedDelete() {
		return needDelete;
	}

	public void setNeedDelete(boolean needDelete) {
		this.needDelete = needDelete;
	}

	public boolean isNeedQueryAll() {
		return needQueryAll;
	}

	public void setNeedQueryAll(boolean needQueryAll) {
		this.needQueryAll = needQueryAll;
	}

	public void copyProperties(QueryBase k) {
		if (k == null)
			return;
		k.setCurrentPage(currentPage);
		k.setNeedDelete(needDelete);
		k.setNeedQeryTotal(needQeryTotal);
		k.setNeedQueryAll(needQueryAll);
		k.setTotalItem(totalItem);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	public String getDataSource() {
		return dataSource == null ? "dataSource1" : dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getPageNumber() {

		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	private static final long serialVersionUID = 0x7570ab2517f4b46dL;
	private static final Integer defaultPageSize = new Integer(20);
	private static final Integer defaultFriatPage = new Integer(1);
	private static final Integer defaultTotleItem = new Integer(0);
	private Integer totalItem;
	private Integer pageSize;
	private Integer currentPage;
	private Integer pageNumber;

	private boolean needQeryTotal;
	private boolean needDelete;
	private boolean needQueryAll;
	private String language;
	private String currentUserName;
	private String dataSource;
	private String orderBy;

	private Integer limit;

	private Integer offset;

	public void ignorePageSize() {
		this.setPageSize(0);

	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}

