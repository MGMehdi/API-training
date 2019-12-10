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
 */
@RestController
@CrossOrigin("*")
public class Controller {
    DataBaseHelper db = new DataBaseHelper();
    @GetMapping("/api/helloworld")
    public ResponseEntity helloworld()
    {
        return ResponseEntity.ok("Hello World Rest");
    }

    @GetMapping("/api/client/id/{id}")
    public ResponseEntity findByid(@PathVariable(name="id") int id){
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
    public ResponseEntity deleteClient(@RequestParam(name="mail") String mail) {
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