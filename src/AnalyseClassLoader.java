import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

/**
 * Created by chunya on 2016/4/20.
 */
public class AnalyseClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, NotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        loader.loadClass("F:\\2DFIRE_PLACE\\weixin-meal\\src\\main\\java\\com\\twodfire\\wechat\\api\\BindingController.java");
//        Javac javac = new Javac(new CtClass("xdcxc"));
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath("F:/2DFIRE_PLACE/weixin-meal/src/main/java");
        CtClass cc = pool.get("com.twodfire.wechat.api.BindingController");
        CtField[] fields = cc.getFields();
        for (CtField field:fields) {
            System.out.println(field.getName());
        }
    }
}
