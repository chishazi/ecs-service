package club.chishazi.ecsservice.dto.result;

/**
 * 分页结果
 * @author han
 */
public class PageResult<T> {

    private T result;

    private Long total;

    public PageResult(T result, Long total) {
        this.result = result;
        this.total = total;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "result=" + result +
                ", total=" + total +
                '}';
    }
}
