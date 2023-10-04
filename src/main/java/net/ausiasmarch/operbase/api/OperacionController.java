package net.ausiasmarch.operbase.api;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.operbase.bean.OperacionBean;
import net.ausiasmarch.operbase.entity.OperacionEntity;
import net.ausiasmarch.operbase.repository.OperacionRepository;

@RestController
@RequestMapping("/calc")
public class OperacionController {

    @Autowired
    OperacionRepository oOperacionRepository;

    @GetMapping("/{id}")
    public ResponseEntity<OperacionEntity> get(@PathVariable Long id) {        
        return ResponseEntity.ok(oOperacionRepository.findById(id).get());        
    }


    @PostMapping()
    public ResponseEntity<OperacionEntity> create(@RequestBody OperacionBean operacionBean) {
        double operando1 = operacionBean.getOperando1();
        double operando2 = operacionBean.getOperando2();
        String operador = operacionBean.getOperador();

        // Realizar la operación según el operador
        double resultado = calcularResultado(operando1, operando2, operador);

        // Construir la cadena de operación
        String operacion = operando1 + " " + obtenerOperadorSimbolo(operador) + " " + operando2 + " = " + resultado;

        // Crear una nueva entidad OperacionEntity y establecer la operación
        OperacionEntity oOperacionEntity = new OperacionEntity();
        oOperacionEntity.setOperacion(operacion);

        // Guardar la entidad en la base de datos
        return ResponseEntity.ok(oOperacionRepository.save(oOperacionEntity));
    }

    private double calcularResultado(double operando1, double operando2, String operador) {
        // Implementar la lógica para calcular el resultado según el operador
        double resultado = 0.0;
        if ("suma".equalsIgnoreCase(operador) || "+".equals(operador)) {
            resultado = operando1 + operando2;
        } else if ("resta".equalsIgnoreCase(operador) || "-".equals(operador)) {
            resultado = operando1 - operando2;
        } else if ("multiplicacion".equalsIgnoreCase(operador) || "*".equals(operador)) {
            resultado = operando1 * operando2;
        } else if ("division".equalsIgnoreCase(operador) || "/".equals(operador)) {
            if (operando2 != 0) {
                resultado = operando1 / operando2;
            } else {
                // Manejar la división por cero aquí si es necesario
            }
        }
        return resultado;
    }

    private String obtenerOperadorSimbolo(String operador) {
        // Mapear el nombre del operador a su símbolo correspondiente
        switch (operador.toLowerCase()) {
            case "suma":
                return "+";
            case "resta":
                return "-";
            case "multiplicacion":
                return "*";
            case "division":
                return "/";
            default:
                return operador; // Si no se encuentra un símbolo correspondiente, devolver el operador original
        }
    }

}
