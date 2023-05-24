package ru.web.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.web.model.Product;
import ru.web.model.User;
import ru.web.repository.ProductRepo;
import ru.web.repository.UserRepo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;


/**
 * Не забываем добалвять в конструктор наши бины. Проще всего делать их final и писать аннотацию @RequiredArqsConstructor
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class HtmlController {

    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String init(Model model) {
        List<Product> productList = productRepo.getAllProducts();
        model.addAttribute("productList", productList);
        return "index";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addProduct(Model model, Product product) {
        productRepo.saveProduct(product);
        List<Product> productsList = productRepo.getAllProducts();
        model.addAttribute("productsList", productsList);
        return "index";
    }

    @RequestMapping(value = "/products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable("id") Integer id) {
        Product product = productRepo.getProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @RequestMapping(value = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(Model model, @PathVariable("id") Integer id) {
        Product product = productRepo.deleteProductById(id);
        List<Product> productsList = productRepo.getAllProducts();
        model.addAttribute("productsList", productsList);
        return "edit";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model, User user) {
        try {
            User userByEmail = userRepo.getUserByEmail(user.getEmail());
            if (userByEmail.getPassword().equals(user.getPassword())){
                model.addAttribute("userAuth", userByEmail);
                // далее на страницаз можно выводить информацию авторизованного пользовтаеля, если необходимо
                // Второй вариант оптарвить пользотваеля в сессию, тоже неплохо, чтоб он на всех страницах был
                request.getSession().setAttribute("userAuth", userByEmail);
                return "redirect:/products";
            } else {
                model.addAttribute("error", "Не верный email или пароль");
                return "login";
            }
        } catch (Exception e) {
            log.error("Ошибка во время авторизации. Не найден пользователь.");
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signIn(Model model, User user) {
        userRepo.saveUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signIn(Model model) {
        return "signin";
    }
}