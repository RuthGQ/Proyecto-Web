package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Carro;
import com.autoxtreme.demo3.repository.ICarroRepository;
import com.autoxtreme.demo3.repository.IMarcaRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.HashMap;

@Controller
public class CarroController {
	
	private Map<Integer, String> descripcionMarcaMap;
    @Autowired
    private ICarroRepository repoCar;
    @Autowired /*crea los metodos get y set, constructores*/
	private IMarcaRepository repoMar;
    
    @GetMapping("/carro")
    public String cargarPagCarro(Model model){
        model.addAttribute("carro", new Carro());
		descripcionMarcaMap = crearDescripcionMarcaMap();
		model.addAttribute("descripcionMarcaMap", descripcionMarcaMap);
        model.addAttribute("lstMarca", repoMar.findAll());
        model.addAttribute("lstCarros", repoCar.findAll());
        return "crud-carros";
    }
    
    @GetMapping("/carro/listado")
    public String generarListaCarros(Model model){
        model.addAttribute("carro", new Carro());
        descripcionMarcaMap = crearDescripcionMarcaMap();
		model.addAttribute("descripcionMarcaMap", descripcionMarcaMap);
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
	
	/* crear el controlador para actualizar un nuevo producto
		@PostMapping("/actualizar")
		public String actualizarCarro(@ModelAttribute Carro carro, Model model) {
			// leer los datos ingresados
			try {
				repoCar.save(carro);
				model.addAttribute("carro", repoCar.findById(carro.getIdCarro()));
		        model.addAttribute("lstMarca", repoMar.findAll());
		        model.addAttribute("lstCarros", repoCar.findAll());
				model.addAttribute("mensaje", "Felicidades Actualización exitosa!!!: " + carro.getIdCarro());
			} catch(Exception e) {
				model.addAttribute("mensaje", "Lo sentimos, no se pudo actualizar :(");
			}		
			return "crud-carros";
		}*/
	
	private Map<Integer, String> crearDescripcionMarcaMap() {
        Map<Integer, String> map = new HashMap<>();
        // Agrega las entradas del mapa según la tabla tb_marca
        map.put(1,"Audi");
        map.put(2,"Suzuki");
        map.put(3,"Haval");
        map.put(4,"Great Wall");
        map.put(5,"Honda");
        map.put(6,"Mazda");
        map.put(7,"Changan");
        map.put(8,"Mercedes-Benz");
        // Añade más entradas para otros ID de marca y descripciones
        return map;
    }
	
    // crear el controlador para grabar un nuevo carro
 	@PostMapping("/carro/agregarActualizar")
 	public String guardaryActualizarCarro(@RequestParam("IdCarro") int idCarro,@ModelAttribute Carro carro, 
 			@RequestParam(value = "descripcion",required=false) String des,
 			@RequestParam(value = "origen",required=false) String origen,
 			@RequestParam(value = "combustible",required=false) String combustible,
 			@RequestParam(value = "precio",required=false) Double precio,
 			@RequestParam(value = "stock",required=false) Integer stock,
 			@RequestParam(value = "IdMarca",required=false) Integer idmarca, 
 			@RequestParam("accion") String accion, Model model) {
 	 	try {	
 	 		// leer los datos ingresados
 	 		System.out.println(carro);
 	 		model.addAttribute("lstMarca", repoMar.findAll());
 			model.addAttribute("lstCarros", repoCar.findAll());
 			carro.setIdCarro(idCarro);
 			if (validarDes(des)) {
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
 			

 			if (accion.equals("Agregar")) {
 			    // Verificar si el carro ya tiene un ID asignado
 			    if (carro.getIdCarro() != 0) {
 			        // Si ya tiene un ID asignado, significa que es una actualización y no una creación nueva
 			        model.addAttribute("mensaje2", "No se puede guardar como un carro nuevo. Utilice el botón 'Actualizar'.");
 			        return "crud-carros";
 			    }
 			    repoCar.save(carro);
 			    model.addAttribute("lstMarca", repoMar.findAll());
			    model.addAttribute("lstCarros", repoCar.findAll());
			    descripcionMarcaMap = crearDescripcionMarcaMap();
				model.addAttribute("descripcionMarcaMap", descripcionMarcaMap);
 			    model.addAttribute("mensaje", "Se registró correctamente el carro con el código: " + carro.getIdCarro());
 			} else if (accion.equals("Actualizar")) {
 			    // Verificar si el carro no tiene un ID asignado

 			    if (carro.getIdCarro() == 0) {
 			        // Si no tiene un ID asignado, significa que no se puede actualizar ya que no existe en la base de datos
 			        model.addAttribute("mensaje2", "No se puede actualizar un carro que no existe. Utilice el botón 'Guardar'.");
 			        return "crud-carros";
 			    }
 			    repoCar.save(carro);
 			    model.addAttribute("lstMarca", repoMar.findAll());
 			    model.addAttribute("lstCarros", repoCar.findAll());
 			    descripcionMarcaMap = crearDescripcionMarcaMap();
 				model.addAttribute("descripcionMarcaMap", descripcionMarcaMap);
 			    model.addAttribute("mensaje", "¡Actualización exitosa! ID del Carro: " + carro.getIdCarro());		
 			}
		  
 		  return "crud-carros";
 		} catch(Exception e) {
 			model.addAttribute("mensaje", e.getMessage());
 			return "crud-carros";
 		}		
 	}
 	
 	@PostMapping("/cargaActualizarCarro")
 	public String cargaActualizarCarro(@RequestParam("IdCarro") int idCarro, Model model) {
 	    Optional<Carro> optionalCarro = repoCar.findById(idCarro);
 	    if (optionalCarro.isEmpty()) {
 	        model.addAttribute("mensaje2", "El carro con ID " + idCarro + " no existe.");
 	        model.addAttribute("lstMarca", repoMar.findAll());
 	        model.addAttribute("lstCarros", repoCar.findAll());
 	        return "crud-carros";
 	    }
 	    Carro carro = optionalCarro.orElse(null);
 	    model.addAttribute("carro", carro);
 	   descripcionMarcaMap = crearDescripcionMarcaMap();
		model.addAttribute("descripcionMarcaMap", descripcionMarcaMap);
 	    model.addAttribute("lstMarca", repoMar.findAll());
 	    model.addAttribute("lstCarros", repoCar.findAll());
 	    return "crud-carros";
 	}
	
	
	@GetMapping("/eliminarCarro")
	public String eliminarCarro(@ModelAttribute Carro carro, Model model) {
		// leer los datos ingresados
		try {
			repoCar.deleteById(carro.getIdCarro());
			model.addAttribute("lstMarca", repoMar.findAll());
			model.addAttribute("lstCarros", repoCar.findAll());
			descripcionMarcaMap = crearDescripcionMarcaMap();
			model.addAttribute("descripcionMarcaMap", descripcionMarcaMap);
			model.addAttribute("mensaje", "Eliminado: " + carro.getIdCarro());
		} catch (Exception e) {
			model.addAttribute("mensaje", "Lo sentimos, no se pudo eliminar :(");
		}
		return "crud-carros";
	}
    
}
