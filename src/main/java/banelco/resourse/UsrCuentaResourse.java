package com.bpservice.webservicebanelco.resourse;
import com.bpservice.webservicebanelco.model.UsuarioCuenta;
import com.bpservice.webservicebanelco.repository.UsrCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // This means that this class is a Controller
@RequestMapping(path="/usrCuenta") // This means URL's start with /usrCuenta (after Application path)
public class UsrCuentaResourse {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UsrCuentaRepository usrCuentaRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUsrCuenta (@RequestParam Integer idUsuario,
                                                 @RequestParam Integer idBanco,
                                                 @RequestParam Integer cbu,
                                                 @RequestParam Float saldo,
                                                 @RequestParam String codigoComercio) {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        UsuarioCuenta n = new UsuarioCuenta();
        n.setCBU(cbu);
        n.setCodigoComercio(codigoComercio);
        n.setIdBanco(idBanco);
        n.setIdUsuario(idUsuario);
        n.setSaldo(saldo);

        usrCuentaRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UsuarioCuenta> getAllMovTipos() {
        // This returns a JSON or XML with the users
        return usrCuentaRepository.findAll();
    }
}



