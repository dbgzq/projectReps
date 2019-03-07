package test;

import entity.MembersInfo;
import mapper.MembersInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream(resource);
            //通过sqlSessionBuilder的builder()获得sqlSessionFactory对象，再调用openSession()方法
            sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();

            System.out.println(sqlSession);
            MembersInfoMapper mapper = sqlSession.getMapper(MembersInfoMapper.class);


                /*//1.根据id返回一个对象信息
                MembersInfo member = mapper.getMember(4);
                System.out.println(member.getId()+"  "+member.getmName()+" "
                +member.getmAge()+" "+member.getmAddress()+" "+member.getmEmail());*/

                /*//2.插入一个对象
                MembersInfo m = new MembersInfo();
                m.setmAge(18);
                m.setmAddress("北京朝阳");
                m.setmEmail("408726@163.com");
                m.setMgender("男");
                m.setmName("巩志权");
                int i = mapper.addMember(m);
                System.out.println("插入成功----->"+i);*/

                /*for (int i = 0; i <50 ; i++) {
                    MembersInfo m = new MembersInfo();
                    m.setId(i+1);
                    m.setmAge(18);
                    m.setmAddress("北京朝阳");
                    m.setmEmail("408726@163.com");
                    m.setMgender("男");
                    m.setmName("巩志权"+i);
                    int num = mapper.addMember(m);
                }
*/
                /*//3.删除一个对象
                int i = mapper.delMember(1);
                System.out.println("删除---->"+i);
                //3.2
                Map map = new HashMap();
                map.put("id", 10);
                map.put("mName","巩志权xiugai");
                map.put("dd",1);
                int i = mapper.delMemberforName(map);*/
            //3.3
            //mapper.delMembers(19,20,21);

                /*/4.修改一个用户
                MembersInfo m = new MembersInfo();
                m.setId(10);
                m.setmAge(18);
                m.setmAddress("北京朝阳");
                m.setmEmail("408726@163.com");
                m.setMgender("男");
                m.setmName("巩志权xiugai");
                int num = mapper.modifyMember(m);
                System.out.println("修改---->"+num);*/

                /*//5.查询集合
                List<MembersInfo> members = mapper.getMembers();
                for (MembersInfo member: members) {
                    System.out.println(member.getId()+"  "+member.getmName()+" "
                            +member.getmAge()+" "+member.getmAddress()+" "+member.getmEmail());
                }*/

                /*//6.查询时传入一个javaBean
                MembersInfo m = new MembersInfo();
                m.setId(10);
                m.setmName("巩志");
                MembersInfo member = mapper.getMemberByMem(m);
                System.out.println(member.getId()+"  "+member.getmName()+" "
                        +member.getmAge()+" "+member.getmAddress()+" "+member.getmEmail());*/
                /*//7.传入一个map查询出对象信息
                Map map = new HashMap();
                map.put("id",10);
                map.put("mAge",18);
                MembersInfo member = mapper.getMemberByMap(map);
                System.out.println(member.getId()+"  "+member.getmName()+" "
                        +member.getmAge()+" "+member.getmAddress()+" "+member.getmEmail());*/
                /*//8.传入数组
                int[] idArr ={1,2,4,10};
                List<MembersInfo> memberByArr = mapper.getMemberByArr(idArr);
                for (MembersInfo member: memberByArr) {
                    System.out.println(member.getId() + "  " + member.getmName() + " "
                            + member.getmAge() + " " + member.getmAddress() + " " + member.getmEmail());
                }*/
                /*//9.传入list<Map>类型
                List<Map<String,String>> mems = new ArrayList<Map<String,String>>();
                Map map = new HashMap();
                map.put("id","10");
                Map map1 = new HashMap();
                map1.put("id","4");
                mems.add(map);
                mems.add(map1);
                List<MembersInfo> memberByList = mapper.getMemberByList(mems);
                for (MembersInfo member: memberByList) {
                    System.out.println(member.getId() + "  " + member.getmName() + " "
                            + member.getmAge() + " " + member.getmAddress() + " " + member.getmEmail());
                }*/
            MembersInfo m1 = new MembersInfo();
            m1.setId(23);
            MembersInfo m2 = new MembersInfo();
            m2.setId(25);
            List<MembersInfo> memberByBean = mapper.getMemberByBean(m1, m2);
            for (int i = 0; i < memberByBean.size(); i++) {
                MembersInfo m = memberByBean.get(i);
                System.out.println(m.getId() + " " + m.getmName());
            }

        /*        //10.返回int
                int count = mapper.getCount();
                System.out.println("返回的记录条数------->"+count);*/
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (sqlSession != null)
                    sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
