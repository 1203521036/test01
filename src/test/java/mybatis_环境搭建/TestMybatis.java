package mybatis_环境搭建;


import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.shsxt.po.User;

public class TestMybatis {

	@Test
	public void test() {
		/**
		 * 1.读取mybatis.xml文件
		 * 2.加载配置信息  获取SqlSessionFactory 对象
		 * 3.获取SqlSession
		 * 4.执行查询  输出结果
		 * 5.关闭SqlSession
		 */
		InputStream is=null;
		SqlSessionFactory sqlSessionFactory=null;
		SqlSession sqlSession=null;
		
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
			sqlSession = sqlSessionFactory.openSession();
			
			User user = sqlSession.selectOne("com.shsxt.mapper.UserMapper.queryUserById", 1);
			
			System.out.println(user);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=sqlSession){
				sqlSession.close();
			}
			
		}
		
		
		
		
		
		
	}

}
