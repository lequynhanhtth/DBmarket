package com.example.dbmarket.serviceImpl;

import com.example.dbmarket.entities.Photo;
import com.example.dbmarket.repository.PhotoRepository;
import com.example.dbmarket.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoRepository photoRepository;
    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void delete(int id) {
        photoRepository.deleteById(id);
    }

    @Override
    public Optional<Photo> findById(int id) {
        return photoRepository.findById(id);
    }

    @Override
    public boolean existById(int id) {
        return photoRepository.existsById(id);
    }

    @Override
    public List<Photo> findByProductId(int id) {
        return photoRepository.findByProductid(id);
    }
}
