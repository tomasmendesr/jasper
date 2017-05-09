package practica.jasper.backend.dao.hibernate;


import javax.ejb.Stateless;

import practica.jasper.backend.dao.hibernate.HibernateDAO;
import practica.jasper.backend.dao.interfaces.LogAuditoriaDAO;
import practica.jasper.backend.model.LogAuditoria;

@Stateless
@HibernateDAO
public class LogAuditoriaDAOImpl extends AbstractDAOImpl<LogAuditoria> implements LogAuditoriaDAO{

}
