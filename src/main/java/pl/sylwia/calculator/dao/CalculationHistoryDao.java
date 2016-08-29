package pl.sylwia.calculator.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pl.sylwia.calculator.domain.CalculationHistory;

@Repository
public class CalculationHistoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(CalculationHistory calculationHistory) {
		sessionFactory.getCurrentSession().save(calculationHistory);
	}

	public void delete(CalculationHistory calculationHistory) {
		sessionFactory.getCurrentSession().delete(calculationHistory);
	}

	public List<CalculationHistory> getAllHistory() {
		return sessionFactory.getCurrentSession().createCriteria(CalculationHistory.class).list();
	}

	public void cleanAll() {
		for (CalculationHistory entry : getAllHistory())
			sessionFactory.getCurrentSession().delete(entry);
	}

}
