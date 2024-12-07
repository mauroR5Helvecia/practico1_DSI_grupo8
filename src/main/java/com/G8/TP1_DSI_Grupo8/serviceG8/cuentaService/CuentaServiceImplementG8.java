package com.G8.TP1_DSI_Grupo8.serviceG8.cuentaService;
import com.G8.TP1_DSI_Grupo8.DTOG8.CrearCuentaDTOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ClientePotencialG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContratoG8;
import com.G8.TP1_DSI_Grupo8.entityG8.CuentaG8;
import com.G8.TP1_DSI_Grupo8.DAOG8.CuentaDAOG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.ContratoService.ContratoServiceImplement;
import com.G8.TP1_DSI_Grupo8.serviceG8.clientePotencialG8.ClientePotencialServiceImplementG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.contactoServiceG8.ContactoServiceImplementG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImplementG8 implements CuentaServiceInterfaceG8 {

    @Autowired
    private CuentaDAOG8 cuentaRepository;

    @Autowired
    private ContratoServiceImplement contratoService;

    @Autowired
    private ContactoServiceImplementG8 contactoServiceImplementG8;

    @Autowired
    private ClientePotencialServiceImplementG8 clientePotencialServiceImplementG8;

    @Override
    public List<CuentaG8> obtenerTodas() {
        try {
            return cuentaRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al obtener todas las cuentas", e);
        }
    }

    @Override
    public CuentaG8 guardar(CuentaG8 cuenta) {
        try {
            if (cuenta.getNombreCuenta() == null || cuenta.getNombreCuenta().trim().isEmpty()) {
                throw new RuntimeException("El nombre de la cuenta no puede ser vacio.");
            }
            return cuentaRepository.save(cuenta);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al guardar la cuenta", e);
        }
    }

    @Override
    public CuentaG8 buscarPorId(Long idCuenta) {
        try {
            return cuentaRepository.findById(idCuenta)
                    .orElseThrow(() -> new RuntimeException("cuenta no encontrada"));
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar la cuenta con ID: " + idCuenta, e);
        }
    }




    @Override
    public CuentaG8 crearCuentaDesdeClientePotencial(CrearCuentaDTOG8 cuentaDTO) {
        try {
            // Obtener el cliente potencial
            Optional<ClientePotencialG8> cliente = clientePotencialServiceImplementG8.findById(cuentaDTO.getIdCliente());

            // Crear la cuenta
            CuentaG8 cuenta = new CuentaG8();
            cuenta.setNombreCuenta(cuentaDTO.getNombreCuenta());
            cuenta.setDescripcionCuenta(cuentaDTO.getDescripcionCuenta());
            cuenta.setTelefonoCuenta(cuentaDTO.getTelefonoCuenta());
            cuenta.setDireccionFacturacion(cuentaDTO.getDireccionFacturacion());


            cuenta = cuentaRepository.save(cuenta);

            // Crear el contrato asociado
            ContratoG8 contrato = new ContratoG8();
            contrato.setCuenta(cuenta);
            contrato.setAprobacionContrato("Aprobado");
            contrato.setEstadoContrato("Activo");
            contratoService.guardar(contrato);

            // Crear el contacto como titular de la cuenta
            ContactoG8 contacto = new ContactoG8();
            contacto.setCuenta(cuenta);
            contacto.setDireccionContacto(cuenta.getDireccionFacturacion());
            contacto.setDetallesContacto(cuentaDTO.getTelefonoCuenta());
            contactoServiceImplementG8.guardar(contacto);

            return cuenta;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al crear la cuenta desde cliente potencial", e);
        }
    }

    @Override
    public Optional<CuentaG8> findById(Long idCuenta) {
        return cuentaRepository.findById(idCuenta);
    }

}
