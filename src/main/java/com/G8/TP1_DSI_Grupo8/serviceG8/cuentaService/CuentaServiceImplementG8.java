package com.G8.TP1_DSI_Grupo8.serviceG8.cuentaService;
import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContratoG8;
import com.G8.TP1_DSI_Grupo8.entityG8.CuentaG8;
import com.G8.TP1_DSI_Grupo8.repositoryG8.ContactoRepositoryG8;
import com.G8.TP1_DSI_Grupo8.repositoryG8.ContratoRepositoryG8;
import com.G8.TP1_DSI_Grupo8.repositoryG8.CuentaRepositoryG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CuentaServiceImplementG8 implements CuentaServiceInterfaceG8 {

    @Autowired
    private CuentaRepositoryG8 cuentaRepository;

    @Autowired
    private ContratoRepositoryG8 contratoRepositoryG8;

    @Autowired
    private ContactoRepositoryG8 contactoRepositoryG8;

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
    public CuentaG8 crearCuentaDesdeClientePotencial(Long idCliente, CuentaG8 cuenta) {
        try {
            // Crear cuenta
            CuentaG8 cuentaNueva = new CuentaG8();
            cuentaNueva.setNombreCuenta(cuenta.getNombreCuenta());
            cuentaNueva.setDescripcionCuenta(cuenta.getDescripcionCuenta());
            cuentaNueva.setTelefonoCuenta(cuenta.getTelefonoCuenta());
            cuentaNueva.setDireccionFacturacion(cuenta.getDireccionFacturacion());


            // Guardar la cuenta
            cuenta = cuentaRepository.save(cuenta);

            // Crear contrato
            ContratoG8 contrato = new ContratoG8();
            contrato.setCuenta(cuenta);
            contratoRepositoryG8.save(contrato);

            // Crear contacto
            ContactoG8 contacto = new ContactoG8();
            contacto.setCuenta(cuenta);
            contacto.setDireccionContacto("Por definir");
            contacto.setDetallesContacto("Titular");
            contactoRepositoryG8.save(contacto);

            return cuenta;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al crear cuenta desde cliente potencial", e);
        }
    }
}
