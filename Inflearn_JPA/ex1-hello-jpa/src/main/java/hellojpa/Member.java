package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
//@Entity(name = "Member") // 기본값
//@Table(name = "MBR") // "MBR"이란 테이블과 매핑
//@Table(uniqueConstraints =)
@SequenceGenerator(name = "member_seq_generator",
        sequenceName = "member_seq",
        initialValue = 1,
        allocationSize = 50)
//@TableGenerator(name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ",
//        allocationSize = 1)
public class Member {

    @Id // 직접할당
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "member_seq_generator")
//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Column(unique = true, length = 10)
    @Column(name = "name", insertable = true, updatable = false, nullable = false) //not null
//    @Column(columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    //    @Column(precision = , scale = )
    private Integer age;

    @Enumerated(EnumType.STRING)
    // EnumType.ORDINAL은 쓰지말자 (순서를 기록함)
    private RoleType roleType;

//    @Temporal(TemporalType.TIMESTAMP) // 요즘 많이 안씀
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime tesLocalDateTime;

    @Lob
    private String description;

    @Transient // DB랑 관련없이 메모리에서만 쓰겠다
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
