/*
infrateam and application team
 */
package com.amazonaws.saas.eks;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.saas.eks.dto.AuthConfig;
import com.amazonaws.saas.eks.dto.Tenant;
import com.amazonaws.saas.eks.dto.TenantDetails;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TenantManagementController {
	private static final Logger logger = LogManager.getLogger(TenantManagementController.class);

	/**
	 * Method to create a new tenant in the system. This is called from the Tenant
	 * Registration Service
	 * 
	 * @param tenant
	 * @return TenantDetails
	 */
	@RequestMapping("/tenant/create")
	public TenantDetails createTenant(@RequestBody TenantDetails tenant) {
		TenantManagementService mgmt = new TenantManagementService();

		return mgmt.createTenant(tenant);
	}

	/**
	 * Method to return all tenants. This method is accessed from the Admin site.
	 * 
	 * @return List<Tenant>
	 */
	@GetMapping(value = "tenants", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Tenant> getTenants() {
		TenantManagementService register = new TenantManagementService();

		return register.getTenants();
	}

	/**
	 * Method to update a single tenant's data. This method is accessed from the
	 * Admin site.
	 * 
	 * @param tenant
	 * @return Tenant
	 */
	@PutMapping(value = "tenants", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Tenant updateTenant(Tenant tenant) {
		TenantManagementService updateTenant = new TenantManagementService();

		return updateTenant.updateTenant(tenant);
	}

	/**
	 * Method to retrieve the Tenant user's configuration data. This is used during
	 * login from the tenant's SaaS application.
	 * 
	 * @param tenantId
	 * @return AuthConfig
	 */
	@RequestMapping(path = "/auth-info", method = RequestMethod.GET)
	public AuthConfig getAuthInfo(HttpServletRequest request) {
		String tenantId = "";
		AuthConfig result = null;

		String origin = request.getHeader("origin");
		logger.info("Origin name => " + origin);

		if (origin == null || origin.equals("http://localhost:4200")) {
			// TODO this is test code and should be deleted unless we create a test tenant
			// with every install
			origin = "http://testcompany4.foo.com";
		}

		try {
			logger.info("Host name => " + origin);
			URI uri = new URI(origin);
			String domain = uri.getHost();
			String[] parts = domain.split("\\.");
			tenantId = parts[0];
			logger.info("Tenant Id => " + tenantId);

			TenantManagementService mgmt = new TenantManagementService();
			result = mgmt.auth(tenantId);
		} catch (URISyntaxException ex) {
			logger.error(ex.toString());
		}

		return result;
	}

}
