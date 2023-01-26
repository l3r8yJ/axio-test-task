package com.l3r8y.axiotesttask.service.impl;

import com.l3r8y.axiotesttask.dto.RequestDTO;
import com.l3r8y.axiotesttask.repository.RequestRepository;
import com.l3r8y.axiotesttask.service.RequestService;
import com.l3r8y.axiotesttask.util.RequestMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;

    @Autowired
    public RequestServiceImpl(final RequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RequestDTO> all() {
        return this.repository
            .findAll()
            .stream()
            .map(RequestMapper::transform)
            .collect(Collectors.toList());
    }
}
