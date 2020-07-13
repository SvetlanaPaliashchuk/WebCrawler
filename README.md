# WebCrawler
Web crawler that traverses websites following predefined link depth (8 by default) and max visited pages limit (10000 by default). Web crawler starts from predefined URL (seed) and follows links found to dive deeper. The main purpose of this crawler to detect the presence of some terms on the page and collect statistics.

## Features
- Implementation of layered architecture (dao, service, controller). All layers are independent which provides project extensibility. If one of the layers is changed the others don't know about it. Single responsibility principle is supported.
- Communication between layers through interfaces.
- Design patterns (singleton, factory, command).
- Junit for tests.
- Maven for build project.

