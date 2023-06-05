package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Carro;
import com.autoxtreme.demo3.repository.ICarroRepository;
import com.autoxtreme.demo3.repository.IMarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarroController {
    @Autowired
    private ICarroRepository repoCar;
    @Autowired /*crea los metodos get y set, constructores*/
	private IMarcaRepository repoMar;
    
    @GetMapping("/carro")
    public String cargarPagCarro(Model model){
        model.addAttribute("carro", new Carro());
        model.addAttribute("lstMarca", repoMar.findAll());
        model.addAttribute("lstCarros", repoCar.findAll());
        return "crud-carros";
    }
    
    @GetMapping("/carro/listado")
    public String generarListaCarros(Model model){
        model.addAttribute("carro", new Carro());
        model.addAttribute("lstMarca", repoMar.findAll());
        model.addAttribute("lstCarros", repoCar.findAll());
        return "crud-carros";
    }
    
	@GetMapping("/cargaActualizarCarro")
	public String cargaActualizarCarro(@ModelAttribute Carro carro, Model model) {
		model.addAttribute("carro", new Carro());
		model.addAttribute("carro", repoCar.findById(carro.getIdCarro()));
		model.addAttribute("lstMarca", repoMar.findAll());
        model.addAttribute("lstCarros", repoCar.findAll());
		return "crud-carros";
	}
	
	public static boolean validarDes(String texto){
		boolean valido = true;
		   if(texto.isEmpty() || texto==null) {
			   valido = false;
			} 
		   else if(!texto.substring(0,texto.length()).matches("^[a-zA-Z0-9 ]*$")){
		      valido = false;
		   }
		   return valido;
	}
	
	public static boolean validarOrigen(String texto){
		boolean valorg = true;
		   if(texto.isEmpty() || texto==null) {
			   valorg = false;
			} 
		   else if(!texto.substring(0,texto.length()).matches("^[a-zA-Z ]*$")){
			   valorg = false;
		   }
		   return valorg;
	}
	
	public static boolean validarCombustible(String texto){
		boolean valcomb = true;
		   if(texto.isEmpty() || texto==null) {
			   valcomb = false;
			} 
		   else if(!texto.substring(0,texto.length()).matches("^[a-zA-Z ]*$")){
			   valcomb = false;
		   }
		   return valcomb;
	}
	public static boolean validarPrecio(double precio){
		String prec = String.valueOf(precio);
		boolean validaPrecio = true;

		if (prec.trim().isEmpty()) {
			validaPrecio = false;
		}
		if (!prec.matches("[0-9]*+([.][0-9]{1,2})?")) {
			validaPrecio = false;
		}
		
		return validaPrecio;
	}	
	
	public static boolean validarStock(int stock){ {
		String stk = String.valueOf(stock);
		boolean validarStock = true;

			if (stk.trim().isEmpty()) {
				validarStock = false;
			}

			else if (!stk.matches("[1-9]+[0-9]*")) {
				validarStock = false;
			}

			return validarStock;
		}
	}
    // crear el controlador para grabar un nuevo carro
 	@PostMapping("/carro/agregar")
 	public String agregarCarro(@ModelAttribute Carro carro, 
 			@RequestParam(value = "descripcion",required=false) String des,
 			@RequestParam(value = "origen",required=false) String origen,
 			@RequestParam(value = "combustible",required=false) String combustible,
 			@RequestParam(value = "precio",required=false) Double precio,
 			@RequestParam(value = "stock",required=false) Integer stock,
 			@RequestParam(value = "IdMarca",required=false) int idmarca, Model model) {
 		// leer los datos ingresados
 		System.out.println(carro);
 		model.addAttribute("lstMarca", repoMar.findAll());
		model.addAttribute("lstCarros", repoCar.findAll());
 	 	try {			
 			if (validarDes(des) == true) {
				carro.setDescripcion(des);
			}
			else {
				model.addAttribute("mensaje2", "Registrar un texto válido en la descripción: "+ carro.getDescripcion());	
				return "crud-carros";
			}
 			
 			if (carro.getIdMarca() != -1) {
				carro.setIdMarca(idmarca);
			}
			else {
				model.addAttribute("mensaje2", "Ingrese un categoria válida: "+ carro.getIdMarca());
				return "crud-carros";
			}
 			
 			if (validarOrigen(origen)) {
				carro.setOrigen(origen);
			}
			else {
				model.addAttribute("mensaje2", "Registrar un texto válido en el origen: "+ carro.getOrigen());
				return "crud-carros";
			}
 			
 			if (validarCombustible(combustible)) {
				carro.setCombustible(combustible);
			}
			else {
				model.addAttribute("mensaje2", "Registrar un texto válido en el combustible: "+ carro.getCombustible());
				return "crud-carros";
			}
 			
 			if (validarPrecio(precio)) {
 				carro.setPrecio(precio);
			}
			else {
				model.addAttribute("mensaje2", "Ingrese un precio válido: "+ carro.getPrecio());
				return "crud-carros";
			}
 			
 			if (validarStock(stock)) {
				carro.setStock(stock);
			}
			else {
				model.addAttribute("mensaje2", "Ingrese un stock válido: "+ carro.getStock());
				return "crud-carros";
			}
 			repoCar.save(carro);
 			//Fijo esto debe mostrar despues de agregar
 	 		model.addAttribute("lstMarca", repoMar.findAll());
 		    model.addAttribute("lstCarros", repoCar.findAll());
 		   model.addAttribute("mensaje", "Se registro correctamente el carro con el código: "+ carro.getIdCarro());
 		  return "crud-carros";
 		} catch(Exception e) {
 			model.addAttribute("mensaje", e.getMessage());
 		}		
 		return "crud-carros";
 	}
 	
	// crear el controlador para actualizar un nuevo producto
	@PostMapping("/actualizar")
	public String actualizarCarro(@ModelAttribute Carro carro, Model model) {
		// leer los datos ingresados
		try {
			repoCar.save(carro);
			model.addAttribute("lstMarca", repoMar.findAll());
		    model.addAttribute("lstCarros", repoCar.findAll());
			model.addAttribute("mensaje", "Felicidades Actualización exitosa!!!: " + carro.getIdCarro());
		} catch(Exception e) {
			model.addAttribute("mensaje", "Lo sentimos, no se pudo actualizar :(");
		}		
		return "crud-carros";
	}
	
	
	@GetMapping("/eliminarCarro")
	public String eliminarCarro(@ModelAttribute Carro carro, Model model) {
		// leer los datos ingresados
		try {
			repoCar.deleteById(carro.getIdCarro());
			model.addAttribute("lstMarca", repoMar.findAll());
			model.addAttribute("lstCarros", repoCar.findAll());
			model.addAttribute("mensaje", "Eliminado: " + carro.getIdCarro());
		} catch (Exception e) {
			model.addAttribute("mensaje", "Lo sentimos, no se pudo eliminar :(");
		}
		return "crud-carros";
	}
    
}
