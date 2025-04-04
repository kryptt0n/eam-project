package com.eam.order_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    // Constructor injection
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Display the add order form
     *
     * @param model The model
     * @return The template name
     */
    @GetMapping("/add")
    public String showAddOrderForm(Model model) {
        model.addAttribute("order", new OrderDto());
        model.addAttribute("actions", Arrays.asList(Action.values()));
        return "add-order";
    }

    /**
     * Process the order form submission
     *
     * @param order The order from form
     * @return Redirect to order list
     */
    @PostMapping("/add")
    public String addOrder(@ModelAttribute OrderDto order) {
        Order newOrder = new Order(order.getCount(), order.getStock(), order.getAccount(), order.getAction());
        orderRepository.save(newOrder);
        System.out.println(order.getExchangeType());
        ObjectMapper mapper = new ObjectMapper();
        File fl = new File("target/orders.json");
        try {
            mapper.writeValue(fl, newOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        return "redirect:/orders/list";
    }

    /**
     * Display all orders
     *
     * @param model The model
     * @return The template name
     */
    @GetMapping("/list")
    public String listOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "order-list";
    }

    /**
     * Display order details
     *
     * @param id    The order ID
     * @param model The model
     * @return The template name or redirect
     */
    @GetMapping("/{id}")
    public String viewOrder(@PathVariable String id, Model model) {
        Optional<Order> orderOpt = orderRepository.findById(id);

        if (orderOpt.isPresent()) {
            model.addAttribute("order", orderOpt.get());
            return "order-detail";
        } else {

            return "redirect:/orders/list";
        }
    }

    /**
     * Delete an order and redirect to order list
     *
     * @param id The order ID
     * @return Redirect to order list
     */
    @GetMapping("/{id}/delete")
    public String deleteOrder(@PathVariable String id) {
        orderRepository.deleteById(id);
        return "redirect:/orders/list";
    }

    /**
     * Home page - redirect to order list
     *
     * @return Redirect to order list
     */
    @GetMapping("/")
    public String home() {
        return "redirect:/orders/list";
    }

    /**
     * Root path - redirect to order list
     *
     * @return Redirect to order list
     */
    @GetMapping
    public String root() {
        return "redirect:/orders/list";
    }
}
