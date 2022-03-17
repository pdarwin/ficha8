package uma.requalificar.ficha8.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.ficha8.model.Andar;
import uma.requalificar.ficha8.model.CC;
import uma.requalificar.ficha8.repository.AndarRepository;
import uma.requalificar.ficha8.repository.CCRepository;

@Service
public class ServiceCC
{

	private final CCRepository cRepository;
	private final AndarRepository aRepository;

	@Autowired
	public ServiceCC(CCRepository cRepository, AndarRepository aRepository)
	{
		this.cRepository = cRepository;
		this.aRepository = aRepository;
	}

	public String addCC(CC cc)
	{
		if (cc.getNome().isBlank())
			return "Nome não preenchido.";

		if (cc.getNumero_max_andar() <= 0)
			return "Cada centro comercial tem de ter pelo menos um andar.";

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
		try
		{
			return cRepository.findById(parseLong(id));
		} catch (NumberFormatException e)
		{
			return null;
		}
	}

	public String deleteCC(String id)
	{
		try
		{
			Long cc_id = parseLong(id);

			if (id == null || cc_id == NaN || cRepository.findById(cc_id).isEmpty())
			{
				return "ID de Centro Comercial inexistente ou fora de formato.";
			}

			CC cc = cRepository.findById(cc_id).get();

			List<Andar> andares = new ArrayList<>();

			aRepository.findAll().forEach(andares::add);
			for (Andar andar : andares)
			{
				if (andar.getCc().getId() == cc_id)
				{
					aRepository.delete(andar);
				}
			}

			cRepository.delete(cc);
			return "";

		} catch (Exception e)
		{
			return "o ID tem de ser um n.º longo.";
		}

	}

}
