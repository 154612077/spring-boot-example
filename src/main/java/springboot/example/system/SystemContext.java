package springboot.example.system;

public class SystemContext {
    private static ThreadLocal<Integer> pageSize = new ThreadLocal();
    private static ThreadLocal<Integer> firstResult = new ThreadLocal();
    private static ThreadLocal<String> sort = new ThreadLocal();
    private static ThreadLocal<String> order = new ThreadLocal();
    private static ThreadLocal<String> language = new ThreadLocal();

    public static void removePageSize() {
        pageSize.remove();
    }

    public static void removeFirstResult() {
        firstResult.remove();
    }

    public static void removeSort() {
        sort.remove();
    }

    public static void removeOrder() {
        order.remove();
    }

    public static void removeLanguage() {
        language.remove();
    }

    public static Integer getPageSize() {
        return (Integer)pageSize.get();
    }

    public static void setPageSize(Integer _pageSize) {
        pageSize.set(_pageSize);
    }

    public static Integer getFirstResult() {
        return (Integer)firstResult.get();
    }

    public static void setFirstResult(Integer _firstResult) {
        firstResult.set(_firstResult);
    }

    public static String getSort() {
        return (String)sort.get();
    }

    public static void setSort(String _sort) {
        sort.set(_sort);
    }

    public static String getOrder() {
        return (String)order.get();
    }

    public static void setOrder(String _order) {
        order.set(_order);
    }

    public static String getLanguage() {
        return (String)language.get();
    }

    public static void setLanguage(String _language) {
        language.set(_language);
    }
}
