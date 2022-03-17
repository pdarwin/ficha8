package uma.requalificar.ficha8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.ficha8.dto.ListaResposta;
import uma.requalificar.ficha8.model.Andar;
import uma.requalificar.ficha8.model.Loja;
import uma.requalificar.ficha8.service.ServiceCC;
import uma.requalificar.ficha8.service.ServiceLoja;

@RestController
public class ControlLoja
{

	private final ServiceLoja sLoja;

	@Autowired
	public ControlLoja(ServiceLoja sLoja)
	{
		this.sLoja = sLoja;
	}
	
	@GetMapping("/getAllLoja")
	public List<Loja> getAllLoja()
	{
		return sLoja.getAllLoja();
	}

	@PostMapping("/addLoja/{andar_id}")
	public ResponseEntity<ListaResposta> addLoja(@RequestBody Loja loja, @PathVariable String andar_id)
	{

		ListaResposta sResponse = new ListaResposta();

		if (loja.getId() != null)
		{
			sResponse.addMsg("ID andar não nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}
		
		if ((loja.getNome() == null))
		{
			sResponse.addMsg("Nome da loja nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}

		if (andar_id == null || andar_id.isBlank())
		{
			sResponse.addMsg("ID do andar não preenchido.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}

		String msg = sLoja.addLoja(loja, andar_id);

		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		} else
		{
			sResponse.setStatusOk(true);
			sResponse.setLista(getAllLoja());
			return ResponseEntity.status(HttpStatus.OK).body(sResponse);
		}

	}

}
