package com.shijiwei.shoppingmall.login.utils;


import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.List;

import com.shijiwei.shoppingmall.login.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * MyBatis工具类
 */
public class MyBatisUtil {

    private static ThreadLocal<SqlSession> threadLocal = new
            ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;

    //静态块加载src目录下的mybatis配置文件
    static{
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 禁止外界通过new方法创建
     */
    private MyBatisUtil(){}

    /*
     * 获取sqlsession
     */
    public static SqlSession getSqlSession()
    {
        //从当前线程中获取sqlSession对象
        SqlSession sqlSession = threadLocal.get();

        //判断SqlSession对象是否为空
        if(sqlSession==null)
        {
            //在SqlSessionFactory对象非空的情况下，获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            //将SqlSession对象与当前线程绑定在一起
            threadLocal.set(sqlSession);
        }

        return sqlSession;
    }

    /*
     * 关闭sqlsession与当前线程分开
     */
    public static void closeSqlSession()
    {
        //从当前线程中获取SqlSession对象
        SqlSession sqlSession = threadLocal.get();

        if(sqlSession != null)
        {
            //关闭SqlSession对象
            sqlSession.close();
            //分开当前线程与SqlSession对象的关系，目的是尽早进行垃圾回收
            threadLocal.remove();
        }
    }

    /*
     * 测试方法
     */
    public static void main(String[] args) {
        Connection conn = MyBatisUtil.getSqlSession().getConnection();
        if(conn==null)
        {
            System.out.println("连接为空");
        }
        else
        {
            System.out.println("连接不为空");
            SqlSession sqlSession = null;
            try{
                sqlSession = MyBatisUtil.getSqlSession();
                //事务开始（默认）

                //读取StudentMapper.xml配置文件中的sql语句，对应的sql语句由{名称空间.sql的id指定}
                List<User> users = sqlSession.selectList("UserNamespace.selectAll");
                System.out.println("  users = " +  users.size() + " | " + users.get(0).toString());

                //事务提交
                sqlSession.commit();
            }catch(Exception e){
                e.printStackTrace();
                //事务回滚
                sqlSession.rollback();
                throw e;
            }finally{
                MyBatisUtil.closeSqlSession();
            }

        }
    }
}
