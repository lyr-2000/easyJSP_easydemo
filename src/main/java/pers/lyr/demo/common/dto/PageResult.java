package pers.lyr.demo.common.dto;



import java.util.List;

/**
 * @Author lyr
 * @create 2020/7/14 0:53
 */

public class PageResult<T> {
    //总记录数
    /**
     * 总数
     */
    private Long total;
    /**
     *
     */
    private Integer totalPage;
    //记录
    /**
     * 数据列
     */
    private List<T> rows;
    /**
     * 返回的提示
     */
    private String msg;
    /**
     * 是否有前一页
     */
    private Boolean hasPre;
    /**
     * 是否还有下一页
     */
    private Boolean hasNext;


    public Long getTotal() {
        return total;
    }

    public PageResult<T> setTotal(Long total) {
        this.total = total;
        return this;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public PageResult<T> setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public List<T> getRows() {
        return rows;
    }

    public PageResult<T> setRows(List<T> rows) {
        this.rows = rows;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public PageResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Boolean getHasPre() {
        return hasPre;
    }

    public PageResult<T> setHasPre(Boolean hasPre) {
        this.hasPre = hasPre;
        return this;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public PageResult<T> setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
        return this;
    }
}
