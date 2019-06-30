package com.notes.boot.dict.mybatis.session;

import com.notes.boot.dict.mybatis.config.MapperStatement;
import com.notes.boot.dict.mybatis.config.MybatisConfiguration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 1. 把配置文件加载到内存
 * 2. 工厂类生产sqlsession
 *
 * @author code
 * @Title: SqlSessionFactory
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/301:08 PM
 */
public class SqlSessionFactory {
    /**
     * 该对象在整个mybatis运行周期里面是全局唯一的
     * 由该类生产的全部sqlsession对象都会必须带上该实例信息
     */
    private MybatisConfiguration conf = new MybatisConfiguration();

    public SqlSessionFactory() {
        loadDBConfig();
        loadMapperConfig();
    }

    /**
     * mapper.xml映射文件所在目录
     */
    private static final String MAPPER_CONFIG_LOCATION = "mappers";
    private static final String DB_CONFIG_FILE = "app_dev.properties";

    /**
     * 加载mapper.xml配置
     */
    private void loadMapperConfig() {

        InputStream dbInputStream = SqlSessionFactory.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE);

        Properties p = new Properties();

        try {
            p.load(dbInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        conf.setJdbcDriver(p.getProperty("jdbc.driverClass"))
                .setJdbcUrl(p.getProperty("jdbc.url"))
                .setJdbcUsername(p.getProperty("jdbc.username"))
                .setJdbcPassword(p.getProperty("jdbc.password"));

    }

    /**
     * 加载数据库连接配置
     */
    private void loadDBConfig() {

        URL resource = SqlSessionFactory.class.getClassLoader().getResource(MAPPER_CONFIG_LOCATION);
        File mapper = new File(resource.getFile());
        if (mapper.isDirectory()) {
            File[] listFiles = mapper.listFiles();
            Arrays.stream(listFiles).forEach(file -> {
                loadMapperFile(file);
            });
        }

    }

    /**
     * 解析mapper.xml文件
     *
     * @param file
     */
    private void loadMapperFile(File file) {
        //创建 SAXReader 对象
        SAXReader reader = new SAXReader();

        try {
            //通过 read方法读取一个文件，转换为document对象
            Document document = reader.read(file);
            //获取根节点元素对象 <mapper>
            Element root = document.getRootElement();
            //获取命名空间
            String namespace = root.attribute("namespace").getData().toString();
            //获取select子节点列表
            List<Element> selects = root.elements("select");
            //遍历select节点，将信息记录到MapperStatement对象，并登记到MybatisConfiguration对象中
            selects.forEach(select -> {
                //实例化 MapperStatement
                MapperStatement mapperStatement = new MapperStatement();
                //读取ID属性
                String id = select.attribute("id").getData().toString();
                //读取resultType属性
                String resultType = select.attribute("resultType").getData().toString();
                //读取SQL语句信息
                String sql = select.getData().toString();

                String sourceId = namespace + "." + id;

                //给mapperStatement赋值
                mapperStatement.setNamespace(namespace)
                        .setResultType(resultType)
                        .setSourceId(sourceId)
                        .setSql(sql);

                //注册到 MybatisConfiguration 对象中
                conf.getMapperStatementMap().put(sourceId, mapperStatement);


            });

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public SqlSession openSession(){
        return new DefaultSqlSession(conf);
    }
}
