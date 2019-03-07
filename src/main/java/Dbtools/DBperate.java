package Dbtools;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBperate {
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private static  DataSource dataSource = null;

    //获取连接
    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if(con==null){
            dataSource = new ComboPooledDataSource("mvcApp");
            con = dataSource.getConnection();
            tl.set(con);
        }
        return tl.get();
    }

    //封装增删改 和查询方法
    public static List<Map> DBquery(String sql,List valList) throws SQLException {

        Connection con = getConnection();
        PreparedStatement pstat = con.prepareStatement(sql);

        List<Map> resultList = new ArrayList<Map>();


        //进行赋值
        if (valList != null && valList.size()!=0) {
            for (int i = 0; i <valList.size() ; i++) {
                pstat.setObject(i+1,valList.get(i));
            }
        }


        ResultSet rs = pstat.executeQuery();
        //获取本次查询的列数
        int columnCount = rs.getMetaData().getColumnCount();
        System.out.println(columnCount);
        while (rs.next()) {
            Map map = new HashMap();
            for (int i = 0; i <columnCount ; i++) {
                System.out.println("----------->"+"执行成功！");
                //map中放入取出的值
                map.put(rs.getMetaData().getColumnName(i+1),rs.getObject(i+1));
            }
            resultList.add(map);
        }
        rs.close();
        pstat.close();
        con.close();
        return  resultList;
    }

    //增删改方法
    public static int DBupdate(String sql,List valList) throws SQLException {
        Connection con = getConnection();
        PreparedStatement pstat = con.prepareStatement(sql);

        if (valList != null) {
            for (int i = 0; i <valList.size() ; i++) {
                pstat.setObject(i+1,valList.get(i));
            }
        }
        int num = pstat.executeUpdate();
        pstat.close();
        con.close();
        return  num;
    }
}
