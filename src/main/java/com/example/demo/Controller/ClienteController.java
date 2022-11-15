package com.example.demo.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.Cliente;
import com.example.demo.Service.ClienteImp;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
	private ClienteImp CDao;

	// @GetMapping("/")
	// public String Listar(@RequestParam Map<String,Object> params, Model model,Cliente cliente){
	// 	int page=params.get("page") != null ? (Integer.valueOf(params.get("page").toString())-1) :0;
	// 	PageRequest pageRequest= PageRequest.of(page,10);
	// 	Page<Cliente> pageCliente= CDao.getAll(pageRequest);
	// 	int totalpage=pageCliente.getTotalPages();
	// 	if (totalpage>0) {
	// 		List<Integer> pages=IntStream.rangeClosed(1, totalpage).boxed().collect(Collectors.toList());
	// 		model.addAttribute("pages", pages);
	// 	}
	// 	model.addAttribute("cliente", cliente);
	// 	model.addAttribute("listcliente", pageCliente.getContent());
	// 	System.out.println(pageCliente.getSize());
	// 	return "Cliente/cliente";
	// }
	@GetMapping("/")
	public String Listar(Model model,Cliente cliente){
		Date date=new Date();
		List<Cliente> c=CDao.listar();
		LocalDate fecha_nacimiento=LocalDate.parse(c.get(1).getNacimiento().toString());
		long diff = ChronoUnit.YEARS.between(fecha_nacimiento, LocalDate.now());
		model.addAttribute("fechahoy", date);
		model.addAttribute("cliente", cliente);
		model.addAttribute("listcliente", CDao.listar());
		System.out.println(diff);
		return "Cliente/cliente";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(name="file",required = false) MultipartFile foto,
	Cliente cliente,Model model,RedirectAttributes flash, String username) {
		if(!foto.isEmpty()){
			String ruta="../POSTAMEDICA/src/main/resources/static/IMG/FOTOS";
			try {
				byte[] bytes=foto.getBytes();
				Path rutaabsoluto=Paths.get(ruta+"/"+foto.getOriginalFilename());
				Files.write(rutaabsoluto, bytes);
				cliente.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {
			// TODO: handle exception
			}
			CDao.guardar(cliente);
			flash.addFlashAttribute("correcto","Se subio todo");
		}
		return "redirect:/Cliente/";	
	}

}
