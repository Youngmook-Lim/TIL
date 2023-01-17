package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

            System.out.println("============");

//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//            //영속
//            em.persist(member);
//            em.detach(member);
//            em.remove(member);

//            Member findMember = em.find(Member.class, 101L);
//            System.out.println(findMember.getId() + " " + findMember.getName());
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println(findMember2 == findMember);

//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
//            Member findMember = em.find(Member.class, 2L);
//            findMember.setName("HelloJPA");
//            em.remove(findMember);

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member m : result) {
//                System.out.println(m.getName());
//            }

            tx.commit();
        } catch (Exception e) {
//            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
