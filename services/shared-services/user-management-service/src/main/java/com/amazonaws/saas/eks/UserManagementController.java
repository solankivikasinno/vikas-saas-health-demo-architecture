/*
infrateam and application team
 */
package com.amazonaws.saas.eks;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.saas.eks.auth.TokenManager;
import com.amazonaws.saas.eks.dto.TenantUserDto;
import com.amazonaws.saas.eks.dto.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserManagementController {
	private static final Logger logger = LogManager.getLogger(UserManagementController.class);

	@Autowired
	private TokenManager tokenManager;

	/**
	 * Method to retrieve all users from the Cognito user pool.
	 * 
	 * @param HttpServletRequest request
	 * @return List<User>
	 */
	@GetMapping(value = "users", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getUsers(HttpServletRequest request) {
		UserManagementService userManagement = new UserManagementService();
		List<User> users = null;
		String userPoolId = null;

		try {
			userPoolId = tokenManager.extractUserPoolIdFromJwt(request);

			if (userPoolId != null) {
				users = userManagement.getUsers(userPoolId);
			}
		} catch (Exception e) {
			logger.error("UserManagement getUsers operation failed:" + e);
		}

		return users;
	}

	/**
	 * Method to create a new user in the User pool.
	 * 
	 * @param User
	 * @param request
	 * @return User
	 */
	@PostMapping(value = "users", produces = { MediaType.APPLICATION_JSON_VALUE })
	public User createUser(@RequestBody User user, HttpServletRequest request) {
		UserManagementService userManagement = new UserManagementService();
		User newUser = null;
		TenantUserDto tenantUserDto = null;

		try {
			tenantUserDto = tokenManager.extractDataFromJwt(request);

			if (tenantUserDto != null) {
				newUser = userManagement.createUser(tenantUserDto, user);
			}
		} catch (Exception e) {
			logger.error("UserManagement create user operation failed:" + e);
		}

		return newUser;
	}

	/**
	 * Method to update user's data in the user pool.
	 * 
	 * @param userName
	 * @param status
	 * @param request
	 */
	@PutMapping(value = "users/{userName}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void updateUser(@PathVariable("userName") String userName, @RequestBody UserStatusCheck status,
			HttpServletRequest request) {
		UserManagementService service = new UserManagementService();
		String userPoolId = null;

		User user = new User();
		user.setUserName(userName);

		try {
			userPoolId = tokenManager.extractUserPoolIdFromJwt(request);

			if (userPoolId != null) {
				if (status != null && status.isEnabled() != null) {
					service.updateUser(user, userPoolId, status.isEnabled().toString());
				}
			}
		} catch (Exception e) {
			logger.error("UserManagement Update user operation failed:" + e);
		}
	}

	static class UserStatusCheck {
		private Boolean enabled;

		public Boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}
	}

	static class ProviderUserEmail {
		private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}
}
