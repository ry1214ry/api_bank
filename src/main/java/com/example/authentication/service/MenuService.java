package com.example.authentication.service;

import com.example.authentication.model.Menu;
import com.example.authentication.repository.MenuRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public Menu createMenu(Menu menu) {
        return repository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return repository.findAll();
    }

    public Menu getMenuById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu record not found with id: " + id));
    }

    public Menu updateMenu(Integer id, Menu updatedDetails) {
        Menu existingMenu = getMenuById(id);

        existingMenu.setKh(updatedDetails.getKh());
        existingMenu.setEn(updatedDetails.getEn());
        existingMenu.setCh(updatedDetails.getCh());
        existingMenu.setKhLink(updatedDetails.getKhLink());
        existingMenu.setEnLink(updatedDetails.getEnLink());
        existingMenu.setChLink(updatedDetails.getChLink());
        existingMenu.setStatus(updatedDetails.getStatus());
        existingMenu.setActiv(updatedDetails.getActiv());

        return repository.save(existingMenu);
    }

    public void deleteMenu(Integer id) {
        Menu existingMenu = getMenuById(id);
        repository.delete(existingMenu);
    }
}