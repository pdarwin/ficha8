package uma.requalificar.ficha8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.ficha8.repository.AndarRepository;
import uma.requalificar.ficha8.repository.CCRepository;
import uma.requalificar.ficha8.repository.LojaRepository;

@Service
public class ServiceLoja {

	private final LojaRepository lRepository;
	
    @Autowired
    public ServiceLoja (LojaRepository lRepository) 
    {
        this.lRepository = lRepository;
    }

}
