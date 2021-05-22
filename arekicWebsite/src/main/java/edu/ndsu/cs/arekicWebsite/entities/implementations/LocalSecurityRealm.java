package edu.ndsu.cs.arekicWebsite.entities.implementations;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

import edu.ndsu.cs.arekicWebsite.entities.interfaces.UserAccount;
import edu.ndsu.cs.arekicWebsite.services.UserAccountService;

public class LocalSecurityRealm extends AuthorizingRealm {
	private UserAccountService userAccountService; 

	public LocalSecurityRealm(UserAccountService uas) {
		this.userAccountService = uas;
		// Create a UserAccount to add to the database since we don’t have pages to do this
		UserAccount user = userAccountService.createNewUserAccount();
		user.setUserID("jdoe");
		user.setName("John Doe");
		user.setPassword("password");
		user.setEmailAddress("john.doe@mysite.net");
		userAccountService.updateUserAccount(user);
	}
	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		UserAccount userAccount = userAccountService.getUserAccountByUserID(username);
		
		if(userAccount != null) {
			// Get the hashed password and the salt used for the hash
			SimpleByteSource salt = new SimpleByteSource(userAccount.getPasswordSalt());
			String hash = userAccount.getPasswordHash();
			// Assemble the necessary information Shiro needs to check the entered password 
			return new SimpleAuthenticationInfo(username, hash, salt, this.getName());
		}
		else {
			return null;
		}
	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// This should never be null or empty, but just return if it's invalid for some reason
		if(principals == null || principals.isEmpty()) {
			return null;
		}
		
		// The primary principal will be the username when logging in
		String username = (String) principals.getPrimaryPrincipal();
		UserAccount userAccount = userAccountService.getUserAccountByUserID(username);
		
		// Add roles as appropriate 
		if(userAccount != null) {
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			List<String> roles = userAccount.getRoles();
			for(String role : roles) {
				authorizationInfo.addRole(role);
			}
			return authorizationInfo;
		}
		else {
			return null; 
		}
	}
}

