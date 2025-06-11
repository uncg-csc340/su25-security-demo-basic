# su25-security-demo-basic
Spring Security - Basic demo project
## This should be the last thing that you add to your project, after everything else is working.
## Notes:
- This repository includes a dependency to [Spring Security](). This is how it handles authentication and authorization.
     - When you start at Spring Initializr and add a dependency to Spring Security.
     - The rest of the dependencies should already look familiar: Spring Web, FreeMarker.
- Once the security dependency is included, Security must be configured. The following are the elements needed for that:
     -   A User service class [AppUserDetailsService]()
         - It implements UserDetailsService. This will make it possible to authenticate our users using their usernames and passwords. For this demo, we have [hardcoded]() users.
         - Each User has username, password, and a set of roles.
  -  A Security configuration class - [Security Config]()
      -   Annotated with `@Configuration` and `@EnableWebSecurity`
      -   A [filter chain](). This is where the rules for authorization are configured.
      -   For this example, all requests that start with `/admin` are only allowed for people who have the MASTER roles. Requests that start with `/mod` are for people with either KNIGHT or MASTER roles.
      -   Any other requests must be authenticated, meaning everyone needs to login before they can do anything on the app.
      -   There are other rules for authorization [here]()
      -   Provide a login configuration. This can either be [default or customized](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html).
      -   Add an [exception handler](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html). If a request is not authorized based on the rules defined above, the app will send a GET request to /403. You can customize this whatever you want but you MUST have the endpoint mapped in some controller.
      -   Configure an authentication manager. We are using the BCryptPasswordEncoder from Spring Security, and the previously mentioned AppUserDetailsService to enforce the above rules for any user who logs in.
