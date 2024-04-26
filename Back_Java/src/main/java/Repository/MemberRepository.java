package Repository;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Entity.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @NotNull
    List<Member> findAll();

    List<Member> findMembersByGeneration(int generation);

    List<Member> getNthGenerationMembers(int n);

    List<Member> findMembersByName(String name);

    List<Member> findMembersByBirthDate(LocalDate birthDate);

    List<Member> findMembersByRelationship(String name1, String name2);

    Member saveChild(Member parent, Member child);

    void deleteMemberAndDescendants(Long id);

    void updateMember(Member member);

   /*@Query("SELECT m FROM Member m ORDER BY m.birthDate")*/
    List<Member> sortMembersByBirthDate();

   /* @Query("SELECT m FROM Member m WHERE m.birthDate = CURRENT_DATE") */
    List<Member> displayMembersWithBirthdayToday();
}
