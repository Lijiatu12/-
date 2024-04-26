package Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Member;
import Repository.MemberRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;



@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

   
   

    // 获取所有成员信息
    public List<Member> findAll(){

        return memberRepository.findAll();
    }


    // 获取所有成员信息

    //获取第n代人的信息
      public List<Member> getNthGenerationMembers(int n) {


        return memberRepository.findMembersByGeneration(n); 

      }




    // 获取所有成员信息

    //获取第n代人的信息
  
    // 根据姓名查询,并输出成员信息
  
    public List<Member> findByName ( String name ){

        return memberRepository.findMembersByName(name);
    }



// 获取所有成员信息

    //获取第n代人的信息

    // 根据姓名查询,并输出成员信息
  // 实现根据出生日期查询成员名单的方法

    public List<Member> searchByBirthDate( LocalDate birthDate) {
      
        return memberRepository.findMembersByBirthDate(birthDate);
    }



// 获取所有成员信息

    //获取第n代人的信息

    // 根据姓名查询,并输出成员信息
    // 实现根据出生日期查询成员名单的方法
  // 实现输入两人姓名，确定其关系的方法
      public List<Member> searchByRelationship(String name1 ,String name2) {
      
            return memberRepository.findMembersByRelationship(name1, name2);
    }




    //获取第n代人的信息

    // 根据姓名查询,并输出成员信息
    // 实现根据出生日期查询成员名单的方法
    // 实现输入两人姓名，确定其关系的方法
    // 某成员添加孩子
   public  Member saveChild(Member parent, Member child){

        return memberRepository.saveChild(parent, child);
    }
    


    //获取第n代人的信息

    // 根据姓名查询,并输出成员信息
    // 实现根据出生日期查询成员名单的方法
    // 实现输入两人姓名，确定其关系的方法
    // 某成员添加孩子

    // 删除某成员及后代
    public void deleteMemberAndDescendants(Long id){
        memberRepository.deleteMemberAndDescendants(id);

    }




    //获取第n代人的信息

    // 根据姓名查询,并输出成员信息
    // 实现根据出生日期查询成员名单的方法
    // 实现输入两人姓名，确定其关系的方法
    // 某成员添加孩子

    // 删除某成员及后代
    // 修改某人的信息
    public  void  updateMember(Member member){

      memberRepository.updateMember(member);


    }






    //获取第n代人的信息

    // 根据姓名查询,并输出成员信息
    // 实现根据出生日期查询成员名单的方法
    // 实现输入两人姓名，确定其关系的方法
    // 某成员添加孩子

    // 删除某成员及后代
    // 修改某人的信息
    // 实现按出生日期对家谱中所有人排序的方法
    public List<Member> sortMembersByBirthDate() {

        return memberRepository.sortMembersByBirthDate();
    }





    //获取第n代人的信息

    // 根据姓名查询,并输出成员信息
    // 实现根据出生日期查询成员名单的方法
    // 实现输入两人姓名，确定其关系的方法
    // 某成员添加孩子

    // 删除某成员及后代
    // 修改某人的信息
    // 实现按出生日期对家谱中所有人排序的方法
 //查询生日当天的健在成员

    public List<Member> getMembersWithBirthdayToday() {
    List<Member> allMembers = memberRepository.findAll();
    LocalDate today = LocalDate.now();
    List<Member> membersWithBirthdayToday = new ArrayList<>();

    for (Member member : allMembers) {
        if (member.getBirthDate().equals(today.toString())) {
            membersWithBirthdayToday.add(member);
        }
    }

    return membersWithBirthdayToday;




}


    



}
