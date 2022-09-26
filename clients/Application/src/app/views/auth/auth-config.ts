/*
infrateam and application team
 */
import { AuthConfigurationService } from './auth-configuration.service';


export function configureAuth(authConfigService: AuthConfigurationService) {
  return authConfigService.Configure();
}

