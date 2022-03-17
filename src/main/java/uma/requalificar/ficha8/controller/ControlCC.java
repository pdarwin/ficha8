package uma.requalificar.ficha8.controller;

import java.util.List;
import java.util.Optional;

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
import uma.requalificar.ficha8.model.CC;
import uma.requalificar.ficha8.service.ServiceCC;

@RestController
public class ControlCC
{

	private final ServiceCC scc;

	@Autowired
	public ControlCC(ServiceCC scc)
	{
		this.scc = scc;
	}

	@PostMapping("/addCentroComercial")
	public ResponseEntity<ListaResposta> addCC(@RequestBody CC cc)
	{

		ListaResposta sResponse = new ListaResposta();

		if (cc.getId() != null)
		{
			sResponse.addMsg("ID não nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}

		if ((cc.getNome() == null))
		{
			sResponse.addMsg("Nome nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}

		String msg = scc.addCC(cc);

		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		} else
		{
			sResponse.setStatusOk(true);
			sResponse.setLista(scc.getAllCentroComercial());
			return ResponseEntity.status(HttpStatus.OK).body(sResponse);
		}

	}

	@GetMapping("/getAllCentroComercial")
	public List<CC> getAllCentroComercial()
	{
		return scc.getAllCentroComercial();
	}

	@GetMapping("/getCentroComercialById/{id}")
	public Optional<CC> CentroComercialById(@PathVariable String id)
	{

		return scc.getCentroComercialById(id);

	}

	@DeleteMapping("/deleteCentroComercial/{id}")
	public ResponseEntity<SimpleResponse> deleteCC(@PathVariable String id)
	{

		SimpleResponse sResponse = new SimpleResponse();

		String msg = scc.deleteCC(id);

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
