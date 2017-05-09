package practica.jasper.backend.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import practica.jasper.backend.dao.hibernate.HibernateDAO;
import practica.jasper.backend.dao.interfaces.LogAuditoriaDAO;
import practica.jasper.backend.model.LogAuditoria;

@Stateless
public class LogService {
	@Inject @HibernateDAO
	LogAuditoriaDAO logAuditoriaDAO;

	@Transactional
	public List<LogAuditoria> findAll() {
		List<LogAuditoria> logs = logAuditoriaDAO.findAll(LogAuditoria.class);
		return logs;
	}
}
