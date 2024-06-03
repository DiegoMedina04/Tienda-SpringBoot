package store.demostore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import store.demostore.interfaces.PositionServiceInterface;
import store.demostore.models.entities.PositionEntity;

import store.demostore.repositories.PositionRepository;

@Service
public class PositionService implements PositionServiceInterface {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<PositionEntity> findAll() {
        return (List<PositionEntity>) positionRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        PositionEntity position = positionRepository.findById(id).orElse(null);
        if (position == null) {
            return ResponseEntity.badRequest().body("Cargo no encontrado");
        }
        return ResponseEntity.ok().body(position);
    }

    @Override
    public ResponseEntity<?> save(PositionEntity position) {
        PositionEntity newPosition = positionRepository.save(position);
        return ResponseEntity.ok().body(newPosition);
    }

    @Override
    public ResponseEntity<?> update(String id, PositionEntity position) {
        PositionEntity positionToUpdate = positionRepository.findById(id).orElse(null);
        if (positionToUpdate == null) {
            return ResponseEntity.badRequest().body("Cargo no encontrado");
        }

        positionToUpdate.setName(position.getName());
        positionToUpdate.setDescription(position.getDescription());
        return ResponseEntity.ok().body(positionRepository.save(positionToUpdate));
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        PositionEntity position = positionRepository.findById(id).orElse(null);
        if (position == null) {
            return ResponseEntity.badRequest().body("Cargo no encontrado");
        }

        positionRepository.delete(position);
        return ResponseEntity.ok().body("Cargo eliminado");
    }

}
