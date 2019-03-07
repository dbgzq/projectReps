package mapper;

import entity.MembersInfo;

import java.util.List;
import java.util.Map;

public interface MembersInfoMapper {
    //根据id查询一个对象
    MembersInfo getMember(int id);
    //根据一个对象部分信息查询一个对象
    MembersInfo getMemberByMem(MembersInfo m);
    //传入一个map获取一个对象信息
    MembersInfo getMemberByMap(Map map);
    //传入数组
    List<MembersInfo> getMemberByArr(int[] idArr);
    //传入数组
    List<MembersInfo> getMemberByList(List list);
    //查询所有对象
    List<MembersInfo> getMembers();
    //查询所有的记录条数
    int getCount();
    //传入map返回一个map
    List<Map> getMaoInfo(Map map);
    List<MembersInfo> getMemberByBean(MembersInfo m1,MembersInfo m2);




    //新增一个对象
    int addMember(MembersInfo m);

    //删除一个对象
    int delMember(int id);
    //传入map
    int delMemberforName(Map map);
    //传入两个同类型的参数
    int delMembers(int id,int id2,int id3);
    //修改一个对象
    int modifyMember(MembersInfo m);
}
