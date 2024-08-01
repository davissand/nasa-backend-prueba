package com.nasa.prueba.david.NasaApiPrueba.aplicacion.taskscheduler;

import com.nasa.prueba.david.NasaApiPrueba.dominio.entities.NasaData;
import com.nasa.prueba.david.NasaApiPrueba.infraestructura.repository.NasaRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduledTask {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    NasaRepository nasaRepository;

    //Definiendo la funcion programada, en este caso se va a ejecutar cada 60000 milisegundos, o sea cada segundo
 //@Scheduled(fixedRate = 60000)
    public void saveNasaAPIData() {
        String baseURL = "https://images-api.nasa.gov/search?q=apollo 11";
        List<NasaData> nasaItems = new ArrayList<>();
        try {
            String response = restTemplate.getForObject(baseURL, String.class);
            if (response != null) {
                JSONObject jsonResponse = new JSONObject(response);
                JSONObject collection = jsonResponse.getJSONObject("collection");
                JSONArray items = collection.getJSONArray("items");

                //iteramos en el arreglo items
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    String href = item.getString("href");

                    //Accedemos al atributo data
                    JSONArray dataArray = item.getJSONArray("data");
                    if (dataArray.length() > 0) {
                        //accedemos a la primera posicion del arreglo
                        JSONObject data = dataArray.getJSONObject(0);
                        String center = data.optString("center");
                        String title = data.optString("title");
                        String nasaId = data.optString("nasa_id");

                        // Se crea un objeto y se agrega al arreglo que almacena los items
                        NasaData nasaItem = new NasaData(href, center, title, nasaId);
                        nasaItems.add(nasaItem);
                    }
                }
              if(!nasaItems.isEmpty()){
                  nasaRepository.saveAll(nasaItems);
                  System.out.println("Se guardaron los datos en la BD");
              }else{
                  System.out.println("No se encontraron datos con ese parametro de busqueda");
              }
            }

        } catch (Exception e) {
                System.err.println("Error al Obtener datos de la api");

        }


    }
}
