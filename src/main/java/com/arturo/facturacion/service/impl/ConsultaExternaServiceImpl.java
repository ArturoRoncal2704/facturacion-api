package com.arturo.facturacion.service.impl;

import com.arturo.facturacion.dto.ReniecResponse;
import com.arturo.facturacion.dto.SunatResponse;
import com.arturo.facturacion.service.ConsultaExternaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ConsultaExternaServiceImpl implements ConsultaExternaService {

    private final RestTemplate restTemplate;

    //URLs públicas de la API
    private static final String URL_DNI = "https://api.apis.net.pe/v1/dni?numero=";
    private static final String URL_RUC = "https://api.apis.net.pe/v1/ruc?numero=";

    @Override
    public ReniecResponse consultarDni(String dni) {
        try {
            return restTemplate.getForObject(URL_DNI + dni, ReniecResponse.class);

        }catch (Exception e){
            throw new RuntimeException("El DNI " + dni + " no existe o la API de la RENIEC está caída.");
        }
    }

    @Override
    public SunatResponse consultarRuc(String ruc) {
        try{
            return restTemplate.getForObject(URL_RUC + ruc, SunatResponse.class);
        }catch (Exception e){
            throw new RuntimeException("El RUC " + ruc + " no existe o la API de la SUNAT está caída.");
        }
    }
}
