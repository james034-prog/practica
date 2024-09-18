package com.api.practica;

import com.api.practica.Exception.SaldoInsuficienteException;
import com.api.practica.Service.MovimientoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovimientoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovimientoService movimientoService;

    @Test
    public void registrarMovimiento_SaldoInsuficiente() throws Exception {
        Mockito.when(movimientoService.registrarMovimiento(1L, -1000.0))
                .thenThrow(new SaldoInsuficienteException("Saldo no disponible"));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/movimientos")
                        .param("cuentaId", "1")
                        .param("monto", "-1000"))
                .andExpect(status().isBadRequest())
                .andExpect((ResultMatcher) content().string("Saldo no disponible"));
    }
}
