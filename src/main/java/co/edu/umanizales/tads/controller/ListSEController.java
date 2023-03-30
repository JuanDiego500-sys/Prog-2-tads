package co.edu.umanizales.tads.controller;

import co.edu.umanizales.tads.controller.dto.ResponseDTO;
import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/listse")
public class ListSEController {
    @Autowired
    private ListSEService listSEService;

    //to get all the list se--------------------------------------------------------------------
    @GetMapping(path = "/getList")
    public ResponseEntity<ResponseDTO> getKids() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listSEService.getKids(), null), HttpStatus.OK);
    }

    //to delete a kid with the id---------------------------------------------------------------
    @GetMapping(path = "/deleteKid/{id}")
    public ResponseEntity<ResponseDTO> deleteKid(@PathVariable String id) {
        listSEService.deleteKid(id);
        return new ResponseEntity<>(new ResponseDTO(
                200, "Niño eliminado", null), HttpStatus.OK);
    }

    //to order the list by gender---------------------------------------------------------------
    @GetMapping(path = "/orderByGender")
    public ResponseEntity<ResponseDTO> orderByGender() {
        listSEService.orderByGender();
        return new ResponseEntity<>(new ResponseDTO(
                200, "Niños ordenados", null), HttpStatus.OK);
    }

    //to lose positions in the list se----------------------------------------------------------
    @GetMapping(path = "/losePositions/{id}")
    public ResponseEntity<ResponseDTO> losePositions(@PathVariable String id, int lose) {
        listSEService.losePositions(id, lose);
        return new ResponseEntity<>(new ResponseDTO(
                200, "Niño agregado en posicion decidida", null), HttpStatus.OK);
    }
    //to exchange the edges of the list----------------------------------------------------------
    @GetMapping(path = "/exchange_list_se")
    public ResponseEntity<ResponseDTO> exchangeExtremes() {
        listSEService.exchangeExtremes();
        return new ResponseEntity<>(new ResponseDTO(
                200, "se han intercambiado los extremos", null), HttpStatus.OK);
    }
    //method to invert the list------------------------------------------------------------------
    @GetMapping(path = "/invert_list")
    public ResponseEntity<ResponseDTO> invertList() {
        listSEService.invertList();
        return new ResponseEntity<>(new ResponseDTO(
                200, "lista invertida", null), HttpStatus.OK);
    }
    //method to put the kids to the beginning and the girls to the end--------------------------------
    @GetMapping(path = "/kids_to_beginning")
    public ResponseEntity<ResponseDTO> putKidsToBeginning() {
        listSEService.putKidsToBeginning();
        return new ResponseEntity<>(new ResponseDTO(
                200, "niños agregados al inicio y niñas agregadas al final", null), HttpStatus.OK);
    }
    //method to delete kids by age--------------------------------------------------------------------
    @GetMapping(path = "/delete_kid_by_age/{age}")
    public ResponseEntity<ResponseDTO> losePositions(@PathVariable byte age) {
        listSEService.deleteKidByAge(age);
        return new ResponseEntity<>(new ResponseDTO(
                200, "Niños con esa edad eliminados", null), HttpStatus.OK);
    }
    //method to get the average age of the kids--------------------------------------------------------
    @GetMapping(path = "/get_average_age")
    public ResponseEntity<ResponseDTO> get_average_age() {
        return new ResponseEntity<>(new ResponseDTO(
                200, "el promedio de edad de los niños es: "+ listSEService.getAverageAge() , null), HttpStatus.OK);
    }

}//end of list se controller-----------------------------------------------------------------------------------
