# Sistema de Trazabilidad de Alimentos - Banco de Alimentos

Sistema distribuido basado en arquitectura de microservicios para la gestión, registro y trazabilidad de donaciones y entregas de alimentos hacia centros comunitarios.

## Arquitectura General del Sistema

El ecosistema está compuesto por 4 microservicios de negocio independientes y 1 API Gateway perimetral, implementando el patrón **Database-per-Service**:

| Componente | Puerto | Base de Datos (Neon PostgreSQL) | Responsabilidad Principal |
|---|---|---|---|
| **api-gateway** | `8080` | *(Sin persistencia)* | Enrutamiento centralizado y seguridad perimetral |
| **donacion-service** | `8081` | `db_donaciones` | Registro de donantes y cabeceras/ítems de donaciones |
| **inventario-service** | `8082` | `db_inventario` | Control de stock en depósito y vencimiento de lotes |
| **distribucion-service** | `8083` | `db_distribucion` | Gestión de comedores y registro de entregas |
| **trazabilidad-service** | `8084` | `db_trazabilidad` | Cadena histórica del alimento desde origen a destino |

### Diagrama de Arquitectura
![Diagrama de Arquitectura](docs/diagrama-arquitectura.png)

---

## Modelo de Dominio y Desacoplamiento

Las entidades se encuentran desacopladas entre servicios. La comunicación y referencia entre contextos delimitados (*Bounded Contexts*) no utiliza claves foráneas físicas (`FK`), sino identificadores lógicos numéricos (`itemDonacionId`).

### Diagrama de Clases
![Diagrama de Clases](docs/diagrama-clases.png)

---

## Estado de Avance: Sprint 1 (`donacion-service`)

El microservicio `donacion-service` se encuentra operativo en el puerto `8081` con persistencia mediante Spring Data JPA y validación de tipos por DTOs.

### Endpoints Disponibles

#### 1. Donantes (`/api/donantes`)
* **`POST /api/donantes`**: Registra un nuevo donante.
  ```json
  {
    "nombre": "Distribuidora Alimentos SA",
    "documento": "30-71234567-9",
    "email": "contacto@distribuidora.com",
    "telefono": "3814001122",
    "tipoDonante": "EMPRESA"
  }
