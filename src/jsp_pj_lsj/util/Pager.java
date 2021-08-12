package jsp_pj_lsj.util;

public enum Pager {
    INSTANCE;
    
    private int cnt; // 글 갯수
    private int startPage; // 보여지는 시작 페이징 번호
    private int endPage; // 보여지는 마지막 페이징 번호
    private int currentPage; // 현재 페이지
    private int pageCnt; // 페이지 갯수
    private int block; // 한번에 보이는 페이지 숫자
    private int size; // 페이지 사이즈(출력 갯수)
    
    private int start; // 페이지 시작 번호
    private int end; // 페이지 끝 번호
    private int number; // 글 번호
    
    private Pager() {
        this.size = 10;
        this.block = 3;
    }
    
    public void setCnt(int cnt) {
        this.cnt = cnt;
        pageCnt = (cnt / size) + (cnt % size > 0 ? 1 : 0);
    }
    
    public void setPageNum(int pageNum) {
        this.currentPage = pageNum;
        init();
    }
    
    public int getStart() {
        return start;
    }
    
    public int getEnd() {
        return end;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int getStartPage() {
        return startPage;
    }
    
    public int getEndPage() {
        return endPage;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(int pageCnt) {
        this.pageCnt = pageCnt;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCnt() {
        return cnt;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void init() {
        start = (currentPage - 1) * size + 1;
        end = (start + size) - 1;
        number = cnt - (currentPage - 1) * size;
        
        startPage = (currentPage / block) * block + 1;
        if (currentPage % block == 0) startPage -= block;
        
        endPage = startPage + block - 1;
        if (endPage > pageCnt) endPage = pageCnt;
    }
}
