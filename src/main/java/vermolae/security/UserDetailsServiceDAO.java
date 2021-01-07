package vermolae.security;

//@Service("userDetailsService")
public class UserDetailsServiceDAO {
//        implements UserDetailsService {
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Override
//    public UserDetails loadUserByUsername(final String eMail) throws UsernameNotFoundException {
//        User user;
//        try {
//            user = this.userDAO.getUserByEMAil(eMail);
//            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(user.getRole().getRole_name()));
//            return new org.springframework.security.core.userdetails.User(eMail, user.getPasswordHash(),
//                    true, true, true, true, authorities);
//        } catch (CustomDAOException ex) {
//            //TODO logger
//            System.out.println(ex);
//            throw new UsernameNotFoundException(eMail + " not found");
//        } catch (Exception ex) {
//            //TODO logger
//            System.out.println(ex);
//            return null;
//        }
//
//    }
}

