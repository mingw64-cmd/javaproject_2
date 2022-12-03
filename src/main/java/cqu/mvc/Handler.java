package cqu.mvc;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 保存控制类的信息
 */
public class Handler {

    private Object controller;
    private Method method;
    private Pattern pattern;
    private String requestType;

    public Handler(Object controller, Method method, Pattern pattern,String requestType) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
        this.requestType =requestType;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }
    public void setMethod(Method method) {
        this.method = method;
    }
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }
    public Method getMethod() {
        return method;
    }
    public String getRequestType() {
        return requestType;
    }
    public Pattern getPattern() {
        return pattern;
    }

}