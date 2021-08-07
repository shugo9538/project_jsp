package jsp_pj_lsj.util;

public class Pager {
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
    
    public Pager() {
        this.size = 10;
        this.block = 3;
    }
    
    public Pager(int size, int block) {
        this.size = size;
        this.block = block;
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
