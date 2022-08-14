package org.automation.jmeter.cofig;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;

import static org.automation.jmeter.cofig.JavaProperties.FILE_SEPARATOR;

public class ContextLoader {
    private final String fileName;

    public ContextLoader(final String file) {
        this.fileName = file;
    }

    public <T> T load(Class<T> aClass, final String folder) throws Exception {
        final String name = folder+FILE_SEPARATOR+this.fileName;
        T instance = aClass.newInstance();

        Properties prop = load(name);
        for (Field field : aClass.getDeclaredFields()) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), aClass);
            Method m = pd.getWriteMethod();
            Class[] types = m.getParameterTypes();
            Object value = prop.getProperty(field.getName());
            m.invoke(instance, types[0].cast(value));
        }
        return instance;
    }
    public Properties load() throws IOException {
        return load(this.fileName);
    }
    public Properties loadFromFolder(final String folderName) throws IOException {
        return load(folderName+FILE_SEPARATOR+this.fileName);
    }


    private Properties load(final String filePath) throws IOException {
        Properties properties = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
        properties.load(is);
        return properties;
    }

    public Map loadAsMap() throws IOException {
        return (Map)load();
    }
}
