package app.repository;

import app.DTO.UserFilterDTO;
import app.entity.RewardsStats;
import app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
@Transactional
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int updateUser(Integer userId, String login, Date horodatage) {
        User u = entityManager.find(User.class, userId);
        if (u == null) {
            return 0;
        }
        u.setLogin(login);
        u.setHorodatage(horodatage);
        entityManager.flush();
        return 1;
    }

    private List<Predicate> getFiltersPredidate (
            Root<User> user, CriteriaBuilder cb,
            HashMap<String, UserFilterDTO> filters) {
        List<Predicate> predicates = new ArrayList<>();

        for(Map.Entry<String, UserFilterDTO> entry : filters.entrySet()) {
            if(entry.getValue().getMatchMode().equals("contains") && entry.getKey().equals("global")) {
                Predicate idPredicate =
                        cb.like(user.get("id").as(String.class), "%" + entry.getValue().getValue() + "%");
                Predicate loginPredicate =
                        cb.like(user.get("login"), "%" + entry.getValue().getValue() + "%");
                Predicate elorankingPredicate =
                        cb.like(user.get("eloranking").as(String.class), "%" + entry.getValue().getValue() + "%");
                Predicate codeiconePredicate =
                        cb.like(user.get("icone").get("codeIcone"), "%" + entry.getValue().getValue() + "%");
                predicates.add(cb.or(loginPredicate, idPredicate, elorankingPredicate, codeiconePredicate));
            }
            if (entry.getValue().getMatchMode().equals("gt") && entry.getKey().equals("eloranking")) {
                predicates.add(cb.gt(user.get(entry.getKey()), Integer.parseInt(entry.getValue().getValue())));
            }
            if(entry.getValue().getMatchMode().equals("contains") && entry.getKey().equals("login")) {
                predicates.add(cb.like(user.get("login"), "%" + entry.getValue().getValue() + "%"));
            }
            if(entry.getValue().getMatchMode().equals("in") && entry.getKey().equals("icone.codeIcone")) {
                String value = entry.getValue().getValue();
                List<String> values =
                        new ArrayList<String>(Arrays.asList(
                                value.replace("[", "")
                                        .replace("]", "")
                                        .split(", ")));
                // la valeur envoyée est celle de l'id : on applique donc un filtre sur idicone
                predicates.add(user.get("icone").get("idicone").in(values));
            }
        }
        return predicates;
    }

    @Override
    public long count(HashMap<String, UserFilterDTO> filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);

        // filtrage
        List<Predicate> predicates = getFiltersPredidate(user, cb, filters);
        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<User> typedQuery = entityManager.createQuery(cq);
        return typedQuery.getResultList().size();
    }

    @Override
    public List<User> findAllFiltered(Pageable pageable, HashMap<String, UserFilterDTO> filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);

        // filtrage
        List<Predicate> predicates = getFiltersPredidate(user, cb, filters);
        cq.where(predicates.toArray(new Predicate[0]));

        // sorting
        cq.orderBy(QueryUtils.toOrders(pageable.getSort(), user, cb));

        // paging
        TypedQuery<User> typedQuery = entityManager.createQuery(cq);
        typedQuery.setFirstResult((int) (pageable.getOffset()));
        typedQuery.setMaxResults(pageable.getPageSize());

        // recuperation resultat
        return typedQuery.getResultList();
    }

    @Override
    public boolean deleteByLoginStartsWith(String loginLike) {
        boolean result = false;
        try {
            if(loginLike!=null && loginLike.length() > 2) {
                String sql = "delete from User where login like :loginLike";
                entityManager.createQuery(sql)
                        .setParameter("loginLike", loginLike+"%")
                        .executeUpdate();
                entityManager.flush();
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return result;
        }
    }

    @Override
    public List<RewardsStats> getRewardsStats() {
        String sql = "select ri.codeicone as reward, count(*) as count " +
                "from users u " +
                "inner join reficone ri on u.idicone = ri.idicone " +
                "group by u.idicone " +
                "order by ri.idicone";
        List<RewardsStats> results = jdbcTemplate.query(sql,
                (RowMapper) (rs, rowNum) -> {
                    RewardsStats result = new RewardsStats();
                    result.setReward(rs.getString("reward"));
                    result.setCount(rs.getLong("count"));
                    return result;
                });

        /*List<Object[]> results2Objects = entityManager.createNativeQuery(sql).getResultList();
        List<RewardsStats> results2 = new ArrayList<>();
        for(Object[] curObj : results2Objects) {
            results2.add(
                    new RewardsStats(
                            (String) curObj[0],
                            new Long(curObj[1].toString())
                    )
            );
        }*/

        return results;
    }

}
