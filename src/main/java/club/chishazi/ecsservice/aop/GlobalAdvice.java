package club.chishazi.ecsservice.aop;

import club.chishazi.ecsservice.selfexception.PredictableException;
import club.chishazi.ecsservice.utils.ApiResponse;
import club.chishazi.ecsservice.utils.ResponseCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * controller接口全局处理
 * @author han
 */
@RestControllerAdvice(basePackages = "club.chishazi.ecsservice.controller")
public class GlobalAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger logger = LoggerFactory.getLogger(GlobalAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 全局返回
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiResponse) {
            //如果本身是APIResponse则直接返回
            return body;
        }
        //如果本身不是APIResponse则进行封装
        ApiResponse<Object> res = new ApiResponse<>(ResponseCode.SUCCESS, body);
        if (body instanceof String) {
            //String类型比较特殊，需要额外处理
            ObjectMapper objectMapper = new ObjectMapper();
            String resStr;
            try {
                resStr = objectMapper.writeValueAsString(res);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            response.getHeaders().add("Content-Type", "application/json");
            return resStr;
        }
        return res;
    }

    /**
     * 全局异常
     */
    @ExceptionHandler(value = {Exception.class})
    public ApiResponse<Object> globalException(Exception e) {
        logger.error("捕获全局异常", e);
        if (e instanceof PredictableException) { //自定义的可预知异常设定为FAIL而非INTERNAL_SERVER_ERROR
            return new ApiResponse<>(ResponseCode.FAIL, e.getMessage());
        } else {
            return new ApiResponse<>(ResponseCode.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
