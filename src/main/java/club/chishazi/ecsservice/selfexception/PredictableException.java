package club.chishazi.ecsservice.selfexception;

/**
 * 可预知异常，主要用于返回错误信息及回滚事务
 * @author pis
 */
public class PredictableException extends RuntimeException {
    public PredictableException() {
        super();
    }
    public PredictableException(String message) {
        super(message);
    }
}
