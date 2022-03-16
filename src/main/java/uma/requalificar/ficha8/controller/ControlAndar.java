package uma.requalificar.ficha8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.ficha8.service.ServiceCC;

@RestController
public class ControlAndar {

	private final ServiceCC sAll;
	
	@Autowired
	public ControlAndar (ServiceCC sAll)
	{
		this.sAll = sAll;
	}
}
