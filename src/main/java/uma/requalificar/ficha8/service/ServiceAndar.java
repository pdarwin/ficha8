package uma.requalificar.ficha8.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.ficha8.model.Andar;
import uma.requalificar.ficha8.model.CC;
import uma.requalificar.ficha8.repository.AndarRepository;
import uma.requalificar.ficha8.repository.CCRepository;

@Service
public class ServiceAndar
{

	private final AndarRepository aRepository;
	private final CCRepository cRepository;

	@Autowired
	public ServiceAndar(AndarRepository aRepository, CCRepository cRepository)
	{
		this.aRepository = aRepository;
		this.cRepository = cRepository;
	}

	public List<Andar> getAllAndar()
	{
		List<Andar> andares = new ArrayList<>();
		aRepository.findAll().forEach(andares::add);

		return andares;
	}

	public String addAndar(Andar andar, String cc_id)
	{
		if (andar.getNumero_max_lojas() <= 0)
			return "Cada andar tem de ter pelo menos uma loja.";

		try
		{
			Long cc_idaux = parseLong(cc_id);

			if (cRepository.findById(cc_idaux).isEmpty())
				return "Centro comercial não encontrado.";

			CC cc = cRepository.findById(cc_idaux).get();

			if (andar.getNumero_andar() > cc.getNumero_max_andar())
				return "O n.º de andar excede o máximo permitido para este centro comercial.";

			andar.setCc(cc);
			aRepository.save(andar);
			return "";

		} catch (NumberFormatException e)
		{
			return "ID de centro comercial inválido";
		}
	}

	public String deleteAndar(String id)
	{
		try
		{
			Long id_long = parseLong(id);

			if (id == null || id_long == NaN || aRepository.findById(id_long).isEmpty())
			{
				return "ID de andar inexistente ou fora de formato.";
			}

			Andar andar = aRepository.findById(id_long).get();
			aRepository.delete(andar);
			return "";

		} catch (Exception e)
		{
			return "o ID tem de ser um n.º longo.";
		}

	}

}
