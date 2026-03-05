package com.milton.gestionar_usuario.services;

import com.milton.gestionar_usuario.dto.OrderCreateDTO;
import com.milton.gestionar_usuario.dto.OrderDTO;
import com.milton.gestionar_usuario.entity.Order;
import com.milton.gestionar_usuario.entity.User;
import com.milton.gestionar_usuario.exception.OrderNotFoundException;
import com.milton.gestionar_usuario.exception.UserNotFoundException;
import com.milton.gestionar_usuario.repository.OrderRepository;
import com.milton.gestionar_usuario.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    public OrderDTO create(OrderCreateDTO dto){

        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado."));

        Order order = new Order();
        order.setDescription(dto.getDescription());
        order.setUser(user);

        Order saved = orderRepository.save(order);

        return new OrderDTO(saved.getIdOrder(), saved.getDescription(), saved.getUser().getIdUser());
    }


    public List<OrderDTO> getOrdersByUser(Long userId){

        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado."));

        return orderRepository.findByUser(user).stream().map(order -> new OrderDTO(
                order.getIdOrder(), order.getDescription(), order.getUser().getIdUser()
        )).toList();
    }

    public List<OrderDTO> getAll(){

        List<Order> resultado = orderRepository.findAll();

        if(resultado.isEmpty()){
            throw new OrderNotFoundException("No se han encontrado orders.");
        }

        return resultado.stream().map(order -> new OrderDTO(
                order.getIdOrder(),
                order.getDescription(),
                order.getUser().getIdUser()
        )).toList();
    }

    public List<OrderDTO> getByDescriptionContaining(String text){

        List<Order> resultado = orderRepository.findByDescriptionContaining(text);

        if(resultado.isEmpty()){
            throw new OrderNotFoundException("No se han encontrado ordenes con esta descripción.");
        }

        return resultado.stream().map(order -> new OrderDTO(
                order.getIdOrder(),
                order.getDescription(),
                order.getUser().getIdUser()
        )).toList();
    }

    public void delete(Long id){
        if(!orderRepository.existsById(id)){
            throw new OrderNotFoundException("Orden no encontrada.");
        }

        orderRepository.deleteById(id);
    }
}
