package co.edu.umanizales.tads.service;

import co.edu.umanizales.tads.controller.dto.KidDTO;
import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.model.ListSE;
import co.edu.umanizales.tads.model.Node;
import co.edu.umanizales.tads.exception.ListSEException;
import lombok.Data;
import org.springframework.stereotype.Service;


@Service
@Data
public class ListSEService {
    private ListSE kids;
    //constructor methods-------------------------------------------------------------------
    public ListSEService() {
        kids = new ListSE();
    }
    //all the calls of the methods------------------------------------------------------------
    public void deleteKid(String id){
        kids.deleteKid(id);
    }
    public void orderByGender()throws ListSEException {
        kids.orderByGender();
    }
    public void addToBeginning(Kid kid){kids.addToStart(kid);}
    public void addInPos(Kid kid,int pos){kids.addInPos(kid,pos);}
    public void losePositions(String id, int lose)throws ListSEException {
        kids.losePositions(id,lose);
    }
    public void earnPositions(String id, int earn)throws ListSEException {kids.earnPositions(id,earn);}
    public void exchangeExtremes() {
        kids.exchangeExtremes();
    }
    public void invertList(){kids.invertList();}
    public void putKidsToBeginning()throws ListSEException{kids.putKidsToBeginning();}
    public void deleteKidByAge(byte age){kids.deleteByAge(age);}

    public Node getKids()
    {
        return kids.getHead();
    }
    public void add(Kid kid) throws ListSEException{kids.add(kid);}
    public void sendKidsToEndByChar(char user)throws ListSEException{kids.sendKidsToEndByChar(user);}
    public double getAverageAge(){return kids.getAverageAge();}
    public String generateReportByAge(){
        return kids.generateReportByAge();
    }
    public int getCountKidsByLocationCode(String code){
        return kids.getCountKidsByLocationCode(code);
    }
    public int verifyId(KidDTO kid){return kids.verifyId(kid);}
    public int getCountKidsByLocationCodeAndMale(String code){return kids.getCountKidsByLocationCodeAndMale(code);}
    public int getCountKidsByLocationCodeAndFemale(String code){return kids.getCountKidsByLocationCodeAndFemale(code);}

}
