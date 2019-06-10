package persistence;

import domain.Account;
import domain.Item;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sf = null;

    private static String resource = "mybatis-config.xml";

    public static SqlSessionFactory getSqlSessionFactory(){

        if(sf == null)
        {
            try{
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sf = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return sf;
    }

    public static void main(String[] args) {

        SqlSession session = getSqlSessionFactory().openSession();

        AccountDAO accountDAO = session.getMapper(AccountDAO.class);

        Account login  = new Account();
        login.setUsername("j2ee");
        login.setPassword("123");

        Account result = accountDAO.getAccountByUsernameAndPassword(login);
        System.out.println(result.getBannerName());

        ItemDAO itemDAO = session.getMapper(ItemDAO.class);

        Item item = itemDAO.getItem("EST-1");
        System.out.println(item.getListPrice());
    }
}
