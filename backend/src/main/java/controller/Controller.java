package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import database.DataBaseHelper;
import objects.Client;

/**
 * Controller
 * Les différentes méthodes sont appelé en fonction de la méthode d'envoie html et du lien
 */

@RestController //Défini la classe comme controleur
@CrossOrigin(origins = "http://localhost:3000") //Lie le backend au frontend via le lien du frontend

public class Controller {
    DataBaseHelper db = new DataBaseHelper();
    @GetMapping("/api/helloworld")
    public ResponseEntity helloworld()
    {
        return ResponseEntity.ok("Hello World Rest");
    }

    @GetMapping("/api/client/id/{id}")
    public ResponseEntity findByid(@PathVariable(name="id") int id){    //PathVariable = lien qui change
        return ResponseEntity.ok(id);
    }

    @GetMapping("/api/client/mail/{mail}")
    public ResponseEntity findClient(@PathVariable(name="mail") String mail){
        System.out.println(mail);
        Client client = new Client(mail);
        db.GetClient(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/api/client/delete")
    public ResponseEntity deleteClient(@RequestParam(name="mail") String mail) {    //RequestParam = paramètre envoyé mais pas visible dans le lien
        Client client = new Client(mail);
        db.GetClient(client);
        db.DeleteClient(client);
        return ResponseEntity.ok("DELETE");
        
    }


    // @GetMapping("/api/client")
    // public ResponseEntity findUsers(@RequestBody String mail){
    //     System.out.println(mail);
    //     Client client = new Client(mail);
    //     db.GetClient(client);
    //     return ResponseEntity.ok(client);
    // }

    @PostMapping("/api/create")
    public ResponseEntity parametrage(@RequestParam(name="name") String name, @RequestParam(name="mail") String mail){
        Client client = new Client(name, mail);
        db.AddClient(client);
        return ResponseEntity.ok(client.get_id());
    }
    
}