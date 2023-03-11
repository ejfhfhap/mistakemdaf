package com.main.branche.util;

public class Pager {
	
	// mapper에서 쓰기전용
	private Integer bookNumber;
	
	public Integer getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}
	//검색 종류(사용할 컬럼)
	private String kind;
	// 검색어
	private String search;
	
	//현재 페이지에 출력할 데이터 갯수
	private Integer perPage;
	
	public String getKind() {
		if(kind == null) {
			kind = "contents";
		}
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) {
			search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	//한 블럭당 출력할 번호의 갯수
	private Integer perBlock;
	
	// 현재 페이지 번호
	private Integer page;
	
	// db조회
	private Integer startRow;
	private Integer lastRow;
	
	// 전체 행 갯수
//	private Integer totalCount;
	
	// jsp 출력용
	private Integer startNum;
	private Integer lastNum;
	private Integer totalPage;
	
	private boolean before;
	private boolean after;
//	public Integer getTotalCount() {
//		return totalCount;
//	}
//
//	public void setTotalCount(Integer totalCount) {
//		this.totalCount = totalCount;
//	}
	
	
	public void makeNum(Integer totalCount) {
		// 전체 row의 갯수
		
		// 총 페이지의 갯수
		totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage+=1;
		}
		
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		// 한번에 보여줄 페이지 번호갯수
		
		
		// 한번에 보여줄 페이지 블럭 갯수
		int totalBlock = (totalPage / this.getPerBlock());
		if(totalPage % this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		// 현재 페이지 블럭 번호
		int curBlock = this.getPage() / this.getPerBlock();
		if(this.page % perBlock != 0) {
			curBlock++;
		}
		
		// 현재 블럭 번호의 시작 번호와 끝 번호 계산
		this.startNum = ((curBlock-1) * this.getPerBlock()) + 1;
		this.lastNum = curBlock * this.getPerBlock();
		
		this.after=true;
		if(curBlock == totalBlock) {
			lastNum = totalPage;
			this.after=false;
		}
		
		if(curBlock == 1) {
			this.before = true;
		}
	}
	public Integer getPerBlock() {
		if(this.perBlock == null || this.perBlock < 1) {
			this.perBlock = 5;
		}
		
		return perBlock;
	}
	public void setPerBlock(Integer perBlock) {
		this.perBlock = perBlock;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	// startRow lastRow 계산 하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public Boolean getAfter() {
		return after;
	}

	public void setAfter(Boolean after) {
		this.after = after;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 20;
		}
		
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1;
		}
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getLastRow() {
		return lastRow;
	}
	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}
	
	
	
}
