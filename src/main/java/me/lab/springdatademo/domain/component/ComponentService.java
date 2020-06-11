package me.lab.springdatademo.domain.component;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    private final ComponentRepository componentRepository;

    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public Component findById(Long id){
        return componentRepository.findById(id).orElseThrow();
    }

    public List<Component> findAll(){
        return componentRepository.findAll();
    }

    public Component save(Component component){
        return componentRepository.save(component);
    }

    public void delete(Long id){
        componentRepository.deleteById(id);
    }
}
