package uma.requalificar.ficha8.service;

import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.ficha8.model.CC;
import uma.requalificar.ficha8.repository.CCRepository;

@Service
public class ServiceCC {

	private final CCRepository cRepository;
	
    @Autowired
    public ServiceCC (CCRepository cRepository) 
    {
        this.cRepository = cRepository;
    }
    
    public String addCC (CC cc) 
    {
    	if (cc.getNome().isBlank())
    	{
        	return "Nome não preenchido.";
    	}

    	cRepository.save(cc);
    	return "";
    }
    
    public List<CC> getAllCentroComercial()
    {
    	List<CC> ccs = new ArrayList<>();
        cRepository.findAll().forEach(ccs::add);

        return ccs;
    }
    
    public Optional<CC> getCentroComercialById(String id)
    {
        try {
			return cRepository.findById(parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return null;
		}
    }

}
