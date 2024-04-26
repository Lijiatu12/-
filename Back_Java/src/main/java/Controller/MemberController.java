package Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import Entity.Member;
import Service.MemberService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {


    @Autowired
    private static MemberService memberService;

    @PostMapping
    public void saveChild(@RequestBody Member member ,@RequestBody Member member2) {
          memberService.saveChild(member ,member2);
    }

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }




    @GetMapping("/generation/{n}")
    public List<Member> getNthGenerationMembers(@PathVariable int n) {
        return memberService.getNthGenerationMembers(n);
    }

    @GetMapping("/search/name/{name}")
    public List<Member> findByName(@PathVariable String name) {
        return memberService.findByName(name);
    }
    

  @GetMapping("/search/birthdate/{birthdate}")
public List<Member> searchByBirthDate(@RequestParam("birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthDate) {
    return memberService.searchByBirthDate(birthDate);
}




    @GetMapping("/relationship")
    public List<Member> searchByRelationship(@RequestParam String name1, @RequestParam String name2) {
        return memberService.searchByRelationship(name1, name2);
    }


    @DeleteMapping("/{id}")
    public void deleteMemberAndDescendants(@PathVariable Long id) {
        memberService.deleteMemberAndDescendants(id);
    }

    @PutMapping
    public void updateMember(@RequestBody Member member) {
        memberService.updateMember(member);
    }

    @GetMapping("/sort/birthdate")
    public static List<Member> sortMembersByBirthDate() {
        return memberService.sortMembersByBirthDate();
    }
}
/*
@PostMapping("/login")
public Result<String> login(){

}*/