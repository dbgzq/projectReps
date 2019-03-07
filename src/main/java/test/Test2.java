package test;

import Dbtools.DBperate;
import redis.clients.jedis.Jedis;

import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
    /*    String sql = "select * from membersinfo";
        try {
            //DBperate.DBquery(sql, null);
            sql = "delete from membersinfo where id = ?";
            List paramList = new ArrayList();
            paramList.add(22);
            System.out.println(DBperate.DBupdate(sql,paramList));
            System.out.println(DBperate.getConnection());
            System.out.println(DBperate.getConnection());
            System.out.println(DBperate.getConnection());
            System.out.println(DBperate.getConnection());
            System.out.println(DBperate.getConnection());
            System.out.println(DBperate.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("yimiao","gong");
        System.out.println(jedis.get("yimiao"));
        jedis.expire("yimiao",20);
        System.out.println(jedis.del("yimiao"));


    }
}
