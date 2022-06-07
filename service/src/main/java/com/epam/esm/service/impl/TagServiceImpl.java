package com.epam.esm.service.impl;

import com.epam.esm.entity.Tag;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.repository.impl.TagRepositoryImpl;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepositoryImpl tagRepository;

    @Autowired
    public TagServiceImpl(TagRepositoryImpl tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag create(Tag tag) throws ServiceException {
        Tag addedTag = tagRepository.create(tag);
        if (addedTag.getId() < 0) {
            throw new ServiceException("The tag can not be added at the moment");
        }
        return addedTag;
    }

    @Override
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public boolean exist(Tag tag) {
        return tagRepository.findByName(tag.getName()).isPresent();
    }

    @Override
    public Long findByName(String name) throws ServiceException {
        Optional<Tag> tagOptional = tagRepository.findByName(name);
        if (tagOptional.isEmpty()) {
            throw new ServiceException(String.format("There is no tag with name %s", name));
        }
        return tagOptional.get().getId();
    }
}
