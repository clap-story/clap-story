package clap.clapStory.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contact;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

}
