package com.ustc.zwxu.lc.reply.web.domain;

public class BaseQuery {
	final public static int DEFAULT_START = 1;
	final public static int DEFAULT_LIMIT = 10;
	final public static int DEFAULT_TOTAL = -1;

	protected Integer start = DEFAULT_START;
	protected Integer limit = DEFAULT_LIMIT;
	protected Integer total = DEFAULT_TOTAL;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}

