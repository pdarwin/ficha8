package uma.requalificar.ficha8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.ficha8.dto.ListaResposta;
import uma.requalificar.ficha8.dto.SimpleResponse;
import uma.requalificar.ficha8.model.Andar;
import uma.requalificar.ficha8.service.ServiceAndar;

@RestController
public class ControlAndar
{

	private final ServiceAndar sAndar;

	@Autowired
	public ControlAndar(ServiceAndar sAndar)
	{
		this.sAndar = sAndar;
	}

	@GetMapping("/getAllAndar")
	public List<Andar> getAllAndar()
	{
		return sAndar.getAllAndar();
	}

	@PostMapping("/addAndar/{cc_id}")
	public ResponseEntity<ListaResposta> addAndar(@RequestBody Andar andar, @PathVariable String cc_id)
	{

		ListaResposta sResponse = new ListaResposta();

		if (andar.getId() != null)
		{
			sResponse.addMsg("ID andar não nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}

		if (cc_id == null || cc_id.isBlank())
		{
			sResponse.addMsg("ID do centro comercial não preenchido.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}

		String msg = sAndar.addAndar(andar, cc_id);

		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		} else
		{
			sResponse.setStatusOk(true);
			sResponse.setLista(getAllAndar());
			return ResponseEntity.status(HttpStatus.OK).body(sResponse);
		}

	}

	@DeleteMapping("/deleteAndar/{id}")
	public ResponseEntity<SimpleResponse> removePessoa2(@PathVariable String id)
	{

		SimpleResponse sResponse = new SimpleResponse();

		String msg = sAndar.deleteAndar(id);

		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		} else
		{
			sResponse.setStatusOk(true);
			return ResponseEntity.status(HttpStatus.OK).body(sResponse);
		}

	}

}
