import com.snowflakemx.dashmetrics.*

class BootStrap {

    def init = { servletContext ->
	
		def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError:true)
		def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError:true)
		
		def user1 = User.findByUsername('bobby') ?: new User(username: 'bobby', enabled: true, password: 'pass', firstName: 'Oscar', lastName: 'Ramirez' ).save(failOnError:true)
		
		
		if (!user1.authorities.contains(userRole)) {
			UserRole.create user1, userRole, true
			
		}
		
		def user2 = User.findByUsername('admin') ?: new User(username: 'admin', enabled: true, password: 'pass', firstName: 'Admin', lastName: '.' ).save(failOnError:true)
		
		if (!user2.authorities.contains(userRole)) {
			UserRole.create user2, userRole, true
			
		}
		
		
		if (!user2.authorities.contains(adminRole)) {
			UserRole.create user2, adminRole, true
			
		}
		
		assert User.count() == 2
		assert Role.count() == 2
		assert UserRole.count() == 3
    }

    def destroy = {
    }
}
