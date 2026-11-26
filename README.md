
# Dienstplan API

REST-API für die Dienstplanung in der Persönlichen Assistenz und Pflege, entwickelt mit Spring Boot.

> 🚧 **In Entwicklung.** Die Mitarbeiterverwaltung ist fertig. Schichtarten, Monatspläne, Schichten und Schichtwünsche folgen.

## Motivation

<!-- Diesen Teil selbst schreiben: warum du das Projekt baust und welches Problem es aus deiner Praxis löst. -->

## Tech-Stack

- **Java 25**, **Spring Boot 4**
- **Spring Web MVC**: REST-API
- **Spring Data JPA / Hibernate**: Persistenz
- **PostgreSQL 17**: Datenbank
- **Flyway**: versionierte Datenbank-Migrationen
- **Jakarta Bean Validation**: Validierung der Anfragen
- **JUnit 5, Mockito, AssertJ**: Unit-Tests
- **Testcontainers**: Integrationstests gegen eine echte PostgreSQL-Datenbank
- **Docker Compose**: Datenbank für die lokale Entwicklung

## Architektur

Der Code ist **nach Features** organisiert, mit einem Paket pro Fachbereich (z. B. `employee`). Innerhalb jedes Features gibt es feste Schichten:

```
Controller  →  Service  →  Repository  →  PostgreSQL
    ↑ ↓
 DTOs (Request / Response) + Mapper
```

- **Controller**: nur HTTP und Validierung
- **Service**: Geschäftslogik
- **Repository**: Datenzugriff über Spring Data JPA
- **DTOs**: trennen die API vom Datenbankmodell
- **Zentrale Fehlerbehandlung**: einheitliche Fehlerantworten im Format `ProblemDetail` (RFC 9457)

## Lokal starten

### Voraussetzungen

- Java 25
- Docker Desktop (muss laufen)

### Anwendung starten

```bash
./mvnw spring-boot:run
```

Unter Windows: `mvnw.cmd spring-boot:run`

Spring Boot startet den PostgreSQL-Container aus `compose.yaml` automatisch, und Flyway führt beim Start alle Migrationen aus.

Health-Check: http://localhost:8080/actuator/health

### Tests ausführen

```bash
./mvnw test
```

Die Integrationstests starten über Testcontainers einen eigenen PostgreSQL-Container. Eine lokale Datenbank ist dafür nicht nötig.

## API

| Methode | Endpunkt | Beschreibung | Antworten |
|---|---|---|---|
| GET | `/api/employees` | Alle Mitarbeiter abrufen | 200 |
| GET | `/api/employees/{id}` | Einen Mitarbeiter per ID abrufen | 200, 404 |
| POST | `/api/employees` | Mitarbeiter anlegen | 201, 400 |

Beispielanfragen stehen in [`employees.http`](employees.http) und lassen sich direkt in IntelliJ IDEA ausführen.

### Beispiel: Validierungsfehler

```json
{
  "type": "about:blank",
  "title": "Bad Request",
  "status": 400,
  "detail": "Validation failed",
  "instance": "/api/employees",
  "errors": ["firstName: must not be blank"]
}
```

## Roadmap

- [x] Mitarbeiterverwaltung (Anlegen und Abrufen, Validierung, Fehlerbehandlung, Tests)
- [ ] Schichtarten und Monatspläne
- [ ] Schichten mit Konfliktprüfung (Überschneidungen, Vertragsstunden)
- [ ] Verfügbarkeiten und Schichtwünsche
- [ ] Authentifizierung und Rollen mit Spring Security (JWT)
- [ ] API-Dokumentation mit OpenAPI / Swagger
- [ ] CI-Pipeline mit GitHub Actions
