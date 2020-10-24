package springmvc.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.User;
//@Repository this annotation tell that its data access class to spring that conntect with database 
@Repository   
public class UserDao{
    @Autowired
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int saveUser(User user) {
		
		int id =(Integer)this.hibernateTemplate.save(user);
		
		return id;
	}

	
	

}
