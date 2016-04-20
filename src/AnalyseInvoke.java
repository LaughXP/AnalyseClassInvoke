import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunya on 2016/4/18.
 */
public class AnalyseInvoke {

    private static List<String> searchClass(String rootPath,String packagePath,boolean childPackage) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(packagePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                if (childPackage) {
                    myClassName.addAll(searchClass(rootPath,childFile.getPath(), childPackage));
                }
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.replace(rootPath, "");
                myClassName.add(childFilePath.replace("\\",".").replace(".java",""));
            }
        }
        return myClassName;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String rootPath = "F:\\2DFIRE_PLACE\\weixin-meal\\src\\main\\java\\";
        String packageName = "com.twodfire.wechat";

        System.out.println(searchClass(rootPath,rootPath + packageName.replace(".","\\"),true));
        Class clazz = Class.forName(rootPath + "com\\twodfire\\wechat\\api\\BindingController.java");
        Object obj = clazz.newInstance();
        System.out.println(clazz.getFields());
    }
}
