package vermolae.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vermolae.crud.service.serviceApi.ContractService;
import vermolae.crud.service.serviceApi.RoleService;
import vermolae.crud.service.serviceApi.UserService;

import vermolae.crud.service.serviceImpl.ContractServiceImpl;
import vermolae.crud.service.serviceImpl.RoleServiceImpl;
import vermolae.crud.service.serviceImpl.UserServiceImpl;
import vermolae.dao.dao_new.ContractDAO;
import vermolae.entity.Contract;
import vermolae.entity.Role;
import vermolae.entity.User;
import vermolae.exeptions.CustomDAOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Controller
public class HomeController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;
    //    @Autowired
//    UserDao userDao;
    @Autowired
    ContractServiceImpl contractService;
    @Autowired
    ContractDAO contractDAO;
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model) {
        Contract contract = new Contract();
        contract.setId(1L);
        contract.setNumber("88005553535");
        model.addAttribute("contract",contract);
        contractService.createEntity(contract);
        //        contractDAO.create(contract);
//        System.out.println("Success");
        return "home";
    }


    @RequestMapping(value = "/adminNewClient", method = RequestMethod.GET)
    @Scope("session")
    public String adminNewClientPost(HttpServletRequest req, Model model) {
        Role role = new Role("AAAAAAA");
        User user = new User("q", "q", "q", "q", "q", "q", "q@q.q", "q", "q", role);
//        User user = userService.getEntityById(12L);
//        user.setEmail("email@testemail.com");
        userService.createEntity(user);


        return "home";
    }

}