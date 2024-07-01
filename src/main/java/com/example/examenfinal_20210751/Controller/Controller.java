package com.example.examenfinal_20210751.Controller;

import com.example.examenfinal_20210751.Entity.Distribuidora;
import com.example.examenfinal_20210751.Entity.Genero;
import com.example.examenfinal_20210751.Entity.Juego;
import com.example.examenfinal_20210751.Respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class Controller {
    @Autowired
    JuegoRepository juegoRepository;

    @Autowired
    GeneroRepository generoRepository;

    @Autowired
    EditoraRepository editoraRepository;

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    DistribuidoraRepository distribuidoraRepository;

    @Autowired
    PlataformaRepository plataformaRepository;

    @GetMapping(value = {"listarJuegos"})
    public ResponseEntity<HashMap<String,Object>> listasJuegos(){
        HashMap<String, Object> respuesta = new HashMap<>();

        try {
            List<Juego> lista = juegoRepository.findAll();
            if (!lista.isEmpty()){
                respuesta.put("result","succes");
                respuesta.put("data",lista);
            }else{
                respuesta.put("msg","La lista está vacia");
            }
            return ResponseEntity.ok().body(respuesta);
        }catch (Exception e){
            respuesta.put("result","error");
            return ResponseEntity.badRequest().body(respuesta);
        }
    }


    @PostMapping(value = {"/Crear"})
    public ResponseEntity<HashMap<String, Object>> agregarJuegos(@RequestBody Juego juego){
        HashMap<String, Object> respuesta = new HashMap<>();

        //validamos todo

        if (juego.getNombre()!=null){

            if(juego.getDescripcion()!=null){

                if (juego.getImage()!=null){

                    if (juego.getPrecio()!=null){

                        if (juego.getGenero()!=null){

                            juego.setGenero(generoRepository.findByNombre(juego.getGenero().getNombre()));

                            if(juego.getPlataforma()!=null){
                                juego.setPlataforma(plataformaRepository.findByNombre(juego.getPlataforma().getNombre()));

                                if(juego.getEditora()!=null){
                                    juego.setEditora(editoraRepository.findByNombre(juego.getEditora().getNombre()));

                                    if (juego.getDistribuidora()!=null){
                                        juego.setDistribuidora(distribuidoraRepository.findByNombre(juego.getDistribuidora().getNombre()));

                                        juegoRepository.save(juego);
                                        respuesta.put("result","success");
                                        respuesta.put("data","new_id: " + juego.getId());
                                        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
                                    }else{
                                        respuesta.put("result","error");
                                        respuesta.put("msg","debe llenar todos los parámetros");
                                        return ResponseEntity.badRequest().body(respuesta);
                                    }
                                }else{
                                    respuesta.put("result","error");
                                    respuesta.put("msg","debe llenar todos los parámetros");
                                    return ResponseEntity.badRequest().body(respuesta);
                                }

                            }else{
                                respuesta.put("result","error");
                                respuesta.put("msg","debe llenar todos los parámetros");
                                return ResponseEntity.badRequest().body(respuesta);
                            }

                        }else{
                            respuesta.put("result","error");
                            respuesta.put("msg","debe llenar todos los parámetros");
                            return ResponseEntity.badRequest().body(respuesta);
                        }
                    }else{
                        respuesta.put("result","error");
                        respuesta.put("msg","debe llenar todos los parámetros");
                        return ResponseEntity.badRequest().body(respuesta);
                    }

                }else{
                    respuesta.put("result","error");
                    respuesta.put("msg","debe llenar todos los parámetros");
                    return ResponseEntity.badRequest().body(respuesta);
                }
            }else{
                respuesta.put("result","error");
                respuesta.put("msg","debe llenar todos los parámetros");
                return ResponseEntity.badRequest().body(respuesta);
            }

        }else{
            respuesta.put("result","error");
            respuesta.put("msg","debe llenar todos los parámetros");
            return ResponseEntity.badRequest().body(respuesta);
        }

    }



    @PutMapping(value = {"/Actualizar"})
    public ResponseEntity<HashMap<String, Object>> actualizarJuegos(@RequestBody Juego juegoReci){
        HashMap<String, Object> respuesta = new HashMap<>();

        if (juegoReci.getId()!=null && juegoReci.getId()>0) {

            Optional<Juego> byId = juegoRepository.findById(juegoReci.getId());

            if (byId.isPresent()){

                if (juegoReci.getNombre()!=null){

                    if(juegoReci.getDescripcion()!=null){

                        if (juegoReci.getImage()!=null){

                            if (juegoReci.getPrecio()!=null){

                                if (juegoReci.getGenero()!=null){

                                    juegoReci.setGenero(generoRepository.findByNombre(juegoReci.getGenero().getNombre()));

                                    if(juegoReci.getPlataforma()!=null){
                                        juegoReci.setPlataforma(plataformaRepository.findByNombre(juegoReci.getPlataforma().getNombre()));

                                        if(juegoReci.getEditora()!=null){
                                            juegoReci.setEditora(editoraRepository.findByNombre(juegoReci.getEditora().getNombre()));

                                            if (juegoReci.getDistribuidora()!=null){
                                                juegoReci.setDistribuidora(distribuidoraRepository.findByNombre(juegoReci.getDistribuidora().getNombre()));

                                                juegoRepository.save(juegoReci);
                                                respuesta.put("result","success");
                                                respuesta.put("data","update_id:" + juegoReci.getId());
                                                return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
                                            }else{
                                                respuesta.put("result","error");
                                                respuesta.put("msg","debe llenar todos los parámetros");
                                                return ResponseEntity.badRequest().body(respuesta);
                                            }
                                        }else{
                                            respuesta.put("result","error");
                                            respuesta.put("msg","debe llenar todos los parámetros");
                                            return ResponseEntity.badRequest().body(respuesta);
                                        }

                                    }else{
                                        respuesta.put("result","error");
                                        respuesta.put("msg","debe llenar todos los parámetros");
                                        return ResponseEntity.badRequest().body(respuesta);
                                    }

                                }else{
                                    respuesta.put("result","error");
                                    respuesta.put("msg","debe llenar todos los parámetros");
                                    return ResponseEntity.badRequest().body(respuesta);
                                }
                            }else{
                                respuesta.put("result","error");
                                respuesta.put("msg","debe llenar todos los parámetros");
                                return ResponseEntity.badRequest().body(respuesta);
                            }

                        }else{
                            respuesta.put("result","error");
                            respuesta.put("msg","debe llenar todos los parámetros");
                            return ResponseEntity.badRequest().body(respuesta);
                        }
                    }else{
                        respuesta.put("result","error");
                        respuesta.put("msg","debe llenar todos los parámetros");
                        return ResponseEntity.badRequest().body(respuesta);
                    }

                }else{
                    respuesta.put("result","error");
                    respuesta.put("msg","debe llenar todos los parámetros");
                    return ResponseEntity.badRequest().body(respuesta);
                }
            }else{
                respuesta.put("result", "error");
                respuesta.put("msg", "parámetros incorrrectos");
                return ResponseEntity.badRequest().body(respuesta);
            }
        }else{
            respuesta.put("result", "error");
            respuesta.put("msg", "parámetros incorrrectos");
            return ResponseEntity.badRequest().body(respuesta);
        }
        //validamos todo



    }


}
