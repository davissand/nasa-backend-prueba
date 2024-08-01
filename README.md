Endpoint para obtener datos de la base de datos:

http://localhost:8080/api/nasa-information?page=0&size=2

Ejemplo de respuesta:
```json
{
    "content": [
        {
            "id": 100,
            "href": "https://images-assets.nasa.gov/image/200907190005HQ/collection.json",
            "center": "HQ",
            "title": "Glenn Lecture With Crew of Apollo 11",
            "nasa_id": "200907190005HQ",
            "created_at": "2024-08-01T16:22:13.727462"
        },
        {
            "id": 99,
            "href": "https://images-assets.nasa.gov/image/200907190015HQ/collection.json",
            "center": "HQ",
            "title": "Glenn Lecture With Crew of Apollo 11",
            "nasa_id": "200907190015HQ",
            "created_at": "2024-08-01T16:22:13.726418"
        }
    ],
    "pageNumber": 0,
    "pageSize": 2,
    "totalItems": 100,
    "totalPages": 50
}
```

Si cambiamos el parametro size, podemos controlar la cantidad de items que queremos en la respuesta
