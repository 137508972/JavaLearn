package com.demo.viewModel;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import com.demo.domain.User;

public class WelComeModel {
	private List<User> uList;
	private int pageSize;
	private int pageCount;
	private int currentPage;
	private Map<String, String> pageLinkDic;
	public Map<String, String> getPageLinkDic() {
		return pageLinkDic;
	}
	public void setPageLinkDic(Map<String, String> pageLinkDic) {
		this.pageLinkDic = pageLinkDic;
	}
	public List<User> getuList() {
		return uList;
	}
	public void setuList(List<User> uList) {
		this.uList = uList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
