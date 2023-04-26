package co.edu.umanizales.tads.controller;

import co.edu.umanizales.tads.controller.dto.PetByLocationDTO;
import co.edu.umanizales.tads.controller.dto.ResponseDTO;
import co.edu.umanizales.tads.model.Location;
import co.edu.umanizales.tads.model.Pet;
import co.edu.umanizales.tads.service.ListDEService;
import co.edu.umanizales.tads.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path= "list_de")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;
    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/get_list")
    public ResponseEntity<ResponseDTO> getPets() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listDEService.getPets(), null), HttpStatus.OK);
    }
    @GetMapping(path = "/delete_pet/{id}")
    public ResponseEntity<ResponseDTO> deletePet(@PathVariable String name) {
        listDEService.deletePet(name);
        return new ResponseEntity<>(new ResponseDTO(
                200, "Mascota eliminado", null), HttpStatus.OK);
    }

    @GetMapping(path = "/add_pet_to_beginning")
    public ResponseEntity<ResponseDTO> addPetToBeginning(Pet pet) {
        listDEService.addPetToBeginning(pet);
        return new ResponseEntity<>(new ResponseDTO(
                200, "Mascota eliminado", null), HttpStatus.OK);
    }

    @GetMapping(path = "/pets_by_locations/{age}")
    public ResponseEntity<ResponseDTO> getKidsByLocation(@PathVariable byte age){
        List<PetByLocationDTO> petByLocationDTOS = new ArrayList<>();
        for(Location loc: locationService.getLocations()){
            if (listDEService.getPets().getData().getAge() > age) {
                int count = listDEService.getCounPetsByLocationCode(loc.getCode());
                int male = listDEService.getCountPetsByLocationCodeAndMale(loc.getCode());
                int female = listDEService.getCountPetsByLocationCodeAndFemale(loc.getCode());
                if (count > 0) {
                    petByLocationDTOS.add(new PetByLocationDTO(loc, female, male, count));
                }
            }
        }
        return new ResponseEntity<>(new ResponseDTO(
                200,petByLocationDTOS,
                null), HttpStatus.OK);
    }
    @GetMapping(path = "/pets_by_department/{age}")
    public ResponseEntity<ResponseDTO> getKidsByDepartment(@PathVariable byte age){
        List<PetByLocationDTO> petByLocationDTOS = new ArrayList<>();
        for(Location loc: locationService.getLocationsByCodeSize(5)){
            if (listDEService.getPets().getData().getAge() > age) {
                int count = listDEService.getCounPetsByLocationCode(loc.getCode());
                int male = listDEService.getCountPetsByLocationCodeAndMale(loc.getCode());
                int female = listDEService.getCountPetsByLocationCodeAndFemale(loc.getCode());
                if (count > 0) {
                    petByLocationDTOS.add(new PetByLocationDTO(loc, female, male, count));
                }
            }
        }
        return new ResponseEntity<>(new ResponseDTO(
                200,petByLocationDTOS,
                null), HttpStatus.OK);
    }

    @GetMapping(path = "/pets_by_city/{age}")
    public ResponseEntity<ResponseDTO> getKidsByCity(@PathVariable byte age){
        List<PetByLocationDTO> petByLocationDTOS = new ArrayList<>();
        for(Location loc: locationService.getLocationsByCodeSize(8)){
            if (listDEService.getPets().getData().getAge() > age) {
                int count = listDEService.getCounPetsByLocationCode(loc.getCode());
                int male = listDEService.getCountPetsByLocationCodeAndMale(loc.getCode());
                int female = listDEService.getCountPetsByLocationCodeAndFemale(loc.getCode());
                if (count > 0) {
                    petByLocationDTOS.add(new PetByLocationDTO(loc, female, male, count));
                }
            }
        }
        return new ResponseEntity<>(new ResponseDTO(
                200,petByLocationDTOS,
                null), HttpStatus.OK);
    }
}//end of ListDE controller----------------------------------------