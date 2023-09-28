package clap.clapStory.domain;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepository {

    private final EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public void update(Long id, Member updateParam) {
        Member findMember = em.find(Member.class, id);
        findMember.setName(updateParam.getName());
        findMember.setPassword(updateParam.getPassword());
        findMember.setEmail(updateParam.getEmail());
        findMember.setContact(updateParam.getContact());
        findMember.setPosts(updateParam.getPosts());
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public List<Member> findAll() {
        String jpql = "select m from Member m";

        List<Member> result = em.createQuery(jpql, Member.class)
                .getResultList();
        return result;
    }
}
