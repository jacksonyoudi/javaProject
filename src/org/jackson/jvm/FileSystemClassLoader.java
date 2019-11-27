package org.jackson.jvm;

import java.io.*;


/**
 * 同一个类，使用不同的类加载器，也认为是不同的对象
 * 自定义加载器
 *      应用加载器
 *      扩展加载器
 *      引导加载器
 */
public class FileSystemClassLoader extends ClassLoader {
    //
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        // 先查询有没有已经加载了这个类
        Class<?> c = findLoadedClass(name);
        if (null != c) {
            return c;
        } else {
            // 父类加载
            ClassLoader parent = this.getParent();
            c = parent.loadClass(name);
            if (c != null) {
                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return null;
    }

    private byte[] getClassData(String classname) {
        String path = rootDir + "/" + classname.replace('.', '/') + ".class";
        // IOUtils
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1) {
                baos.write(buffer, 0, temp);
                baos.flush();
            }
            return baos.toByteArray();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }
}
