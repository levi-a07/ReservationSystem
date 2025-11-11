MIND MAP:
1. Start with the default behavior
If you don’t create a SecurityConfig, Spring Boot gives you sensible defaults:
A default SecurityFilterChain is created.
A default UserDetailsService with a single random user is generated.
A default password is printed in the console.
Session management, CSRF, login page, etc., are preconfigured
2.  Why create SecurityFilterChain 
   @Bean
   SecurityFilterChain securityFilterChain(HttpSecurity http)
   What it does: Tells Spring Security how to protect HTTP endpoints.

Default one exists, but you create your own to:

Allow/deny requests (authorizeHttpRequests)

Customize login (form login, basic auth, etc.)

Enable/disable CSRF

Control session creation (stateless for REST APIs)

Remember: The filter chain is the first thing that handles incoming requests.

Mental shortcut:

“Filter chain = rules for all HTTP traffic.”
3️⃣ Why create UserDetailsService
@Bean
UserDetailsService userDetailsService()


What it does: Provides users and their credentials to the authentication system.

Spring Boot can auto-create a default one, but:

You want custom usernames, passwords, or roles.

You may want users from memory, database, or API.

Remember: UserDetailsService = where Spring looks for users.

Mental shortcut:

“Filter chain is the gate, UserDetailsService is the guard’s notebook of usernames and passwords.”

4️⃣ Why/when to create AuthenticationProvider
@Bean
AuthenticationProvider authenticationProvider()


What it does: Actually performs authentication (checks credentials).

Default provider exists, but creating your own lets you:

Use custom hashing logic

Authenticate against DB, LDAP, JWT, or external API

Combine multiple authentication mechanisms

Relationship: SecurityFilterChain delegates to the AuthenticationManager, which uses AuthenticationProvider, which in turn uses UserDetailsService to fetch user info.

Mental shortcut:

“Filter chain asks ‘is this request allowed?’ → provider says ‘is the user who they claim to be?’ → UserDetailsService supplies the user data.”



Think in terms of flow of a request:
SecurityFilterChain → protects endpoints and decides which requests need authentication.
AuthenticationProvider → performs the actual authentication logic.
UserDetailsService → provides user info to the provider.
PasswordEncoder → used by the provider to match passwords.