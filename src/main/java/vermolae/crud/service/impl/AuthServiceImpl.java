package vermolae.crud.service.impl;


//@Service
//@Transactional
public class AuthServiceImpl{
//        implements AuthService {

//    @Autowired
//    protected UserDAO userDAO;
//
//    //    @Autowired
////    protected ContractDAO contractDAO;
////    @Getter
////    public class Role implements GrantedAuthority {
////        private String role;
////
////        Role(String role) {
////            this.role = role;
////        }
////
////        @Override
////        public String getAuthority() {
////            return this.role;
////        }
////    }
//
//    public class UserPrincipal implements UserDetails {
//        private int id;
//        private String password;
//        private String username; //email
//        private List<Role> authorities;
//        private boolean enabled;
//        private boolean accountNonExpired = true;
//        private boolean accountNonLocked = true;
//        private boolean credentialsNonExpired = true;
//
//        public long getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        @Override
//        public String getPassword() {
//            System.out.println("GET PASSWORD"+password);
//            return password;
//        }
//
//        public void setPassword(String password) {
//            System.out.println(password);
//            this.password = password;
//        }
//
//        @Override
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        @Override
//        public List<Role> getAuthorities() {
//            return authorities;
//        }
//
//        public void setAuthorities(List<Role> authorities) {
//            this.authorities = authorities;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return enabled;
//        }
//
//        public void setEnabled(boolean enabled) {
//            this.enabled = enabled;
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return accountNonExpired;
//        }
//
//        public void setAccountNonExpired(boolean accountNonExpired) {
//            this.accountNonExpired = accountNonExpired;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return accountNonLocked;
//        }
//
//        public void setAccountNonLocked(boolean accountNonLocked) {
//            this.accountNonLocked = accountNonLocked;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return credentialsNonExpired;
//        }
//
//        public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//            this.credentialsNonExpired = credentialsNonExpired;
//        }
//
//        UserPrincipal(User user) {
//            this.id = user.getId();
//            this.username = user.getEmail();
//            this.password = user.getPassword();
//            System.out.println("PASSWORD: "+ this.password);
//            this.enabled = user.isEnabled();
//            this.authorities = Arrays.asList(new Role(user.getRole().getRole_name()));
//        }
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = null;
//        //username = email or phone
//        if(username.contains("@")) {
//            user = userDAO.getUserByEMAil(username);
////        } else {
////            ContractPO contract = contractDAO.findByPhone(username);
////            if(contract != null)
////                user = contract.getUser();
////        }
//            System.out.println(user);
//        }
//        if(user == null)
//            throw new UsernameNotFoundException(username);
//
//        return new UserPrincipal(user);
//    }
//
//    @Override
//    public User getCurrentUser() {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
////            return userDAO.read((int) principal.getId()).orElse(null);
//        return userDAO.read((int) principal.getId());
//    }
}
