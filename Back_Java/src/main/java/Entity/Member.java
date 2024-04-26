package Entity;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String gender;
    private String address;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String maritalstatus;
    private String alivestatus;

    // 构造函数
    public Member() {
    }

    // 构造函数

    public Member(String id, String name, String address, LocalDate birthDate, LocalDate deathDate, String maritalstatus, String alivestatus) {

    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getAlivestatus() {
        return alivestatus;
    }

    public void setAlivestatus(String alivestatus) {
        this.alivestatus = alivestatus;
    }
}