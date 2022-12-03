package cqu.ioc.BeanUtil;

/**
 * 保存一个bean的定义信息，基本按老师讲的抄过来
 */
public class Bean {
    private String id;
    private Class clz;

    public Bean(String id, Class clz) {
        this.id = id;
        this.clz = clz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class getClazz() {
        return clz;
    }

    public void setClazz(Class clz) {
        this.clz = clz;
    }

    public Object getInstance() {
        try {
            return clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}