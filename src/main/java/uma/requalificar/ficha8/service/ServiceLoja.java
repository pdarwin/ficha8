package uma.requalificar.ficha8.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.ficha8.model.Andar;
import uma.requalificar.ficha8.model.CC;
import uma.requalificar.ficha8.model.Loja;
import uma.requalificar.ficha8.repository.AndarRepository;
import uma.requalificar.ficha8.repository.CCRepository;
import uma.requalificar.ficha8.repository.LojaRepository;

@Service
public class ServiceLoja
{

	private final LojaRepository lRepository;
	private final AndarRepository aRepository;

	@Autowired
	public ServiceLoja(LojaRepository lRepository, AndarRepository aRepository)
	{
		this.lRepository = lRepository;
		this.aRepository = aRepository;
	}

	public List<Loja> getAllLoja()
	{
		List<Loja> lojas = new ArrayList<>();
		lRepository.findAll().forEach(lojas::add);

		return lojas;
	}

	public String addLoja(Loja loja, String andar_id)
	{
		if (loja.getNome().isBlank())
			return "Nome da loja não preenchido.";
		
		if (loja.getArea()<= 0)
			return "A área da loja tem de ser maior que zero.";

		try
		{
			Long andar_idaux = parseLong(andar_id);

			if (aRepository.findById(andar_idaux).isEmpty())
				return "Andar não encontrado.";

			Andar andar = aRepository.findById(andar_idaux).get();
			
			if (andar.getLojas().size() > 1)
				return "O n.º de andar excede o máximo permitido para este centro comercial.";

			loja.setAndar(andar);
			lRepository.save(loja);
			return "";

		} catch (NumberFormatException e)
		{
			return "ID de andar inválido";
		}
	}	

//	public String deleteAndar(String id)
//	{
//		try
//		{
//			Long id_long = parseLong(id);
//
//			if (id == null || id_long == NaN || aRepository.findById(id_long).isEmpty())
//			{
//				return "ID de andar inexistente ou fora de formato.";
//			}
//
//			Andar andar = aRepository.findById(id_long).get();
//			aRepository.delete(andar);
//			return "";
//
//		} catch (Exception e)
//		{
//			return "o ID tem de ser um n.º longo.";
//		}
//
//	}

}
