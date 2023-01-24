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
            //저장
            Team team = new Team();
            team.setName("TeamA");
//            team.getMembers().add(member); // 이거 안됌
            em.persist(team);

            Member2 member = new Member2();
            member.setUsername("member1");
            // 한쪽만 해주라 (둘 중 하나만 정해라)
//            member.changeTeam(team);
            em.persist(member);

//            team.getMembers().add(member); // 이거 안해도 되지만 해주는게 좋음
            // 한쪽만 해준 것 (연관관계 편의 메소드)
            team.addMember(member);

            em.flush();
            em.clear();

            Member2 findMember = em.find(Member2.class, member.getId());
//            Team findTeam = em.find(Team.class, findMember.getTeamId());
//            Team findTeam = findMember.getTeam();
//            System.out.println(findTeam.getName());

            // member의 team 바꾸기
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

//            List<Member2> members = findMember.getTeam().getMembers();
//
//            for (Member2 m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

            //////////////////////////////////////////////

//            Member member = new Member();
//            member.setId("ID_A");
//            member.setUsername("A");
//            member.setRoleType(RoleType.ADMIN);


//            Member member1 = new Member();
//            member1.setUsername("B");
//            Member member2 = new Member();
//            member2.setUsername("C");
//
//            System.out.println("============");
//            em.persist(member); // 1, 51
//            em.persist(member1); // MEM
//            em.persist(member2); // MEM
//            System.out.println(member.getId());
//            System.out.println(member1.getId());
//            System.out.println(member2.getId());
//            System.out.println("============");

            // DQ SEQ = 1  |  1
            // DQ SEQ = 51  |  2
            // DQ SEQ = 51  |  3

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//            em.detach(member);

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);


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
