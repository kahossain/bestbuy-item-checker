package com.zahidhossain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public int from;
    public int to;
    public int currentPage;
    public int total;
    public int totalPages;
    public String queryTime;
    public String totalTime;
    public boolean partial;
    public String canonicalUrl;
    public List<Product> products;
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public boolean isPartial() {
		return partial;
	}
	public void setPartial(boolean partial) {
		this.partial = partial;
	}
	public String getCanonicalUrl() {
		return canonicalUrl;
	}
	public void setCanonicalUrl(String canonicalUrl) {
		this.canonicalUrl = canonicalUrl;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		StringBuilder builder;
		builder = new StringBuilder();
		builder.append("Root [products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}
}
