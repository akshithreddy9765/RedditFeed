### The architectural techniques used:
1. Uncle Bob's Clean Artchitecture with SOLID principles
2. Separate presentation, domain, and data modules to enforce independent layers
3. Dagger 2 for dependency injection
4. RxJava 2 for asynchronous data operations
5. Retrofit for web service integration
6. Junit, Kluent(Kotlin Extension) and Mockito for unit tests


Reddit Feed architecture was heavily influenced by Uncle Bob's Clean Architecture.
The core principles of the clean approach can be summarized as followed:
* **The application code is separated into layers:** These layers define the separation of concerns inside the code base.
* **The layers follow a strict dependency rule:** Each layer can only interact with the layers below it.
* **As we move toward the bottom layer — the code becomes generic:** The bottom layers dictate policies and rules, and the upper layers dictate implementation details such as the database, networking manager, and UI.

This application contains three layers: The Domain Layer, the Data Layer and the Presentation Layer. It follows the dependency rule attached below

![1_3smlpzenpaticxdgcjuhsg](https://user-images.githubusercontent.com/17843062/51222111-dc1c1380-1901-11e9-88b4-58fb5a0d063d.jpeg)


## Domain Layer
The domain layer sits at the very bottom of our code base. Here, we define our domain entities, interfaces and use cases for the upper layers to use. We keep things generic as much as we could to protect the core functionality from changes, leaving the hassle of dealing with implementations details to the upper layers. 

## Data Layer
The data layer sits between the domain layer and the presentation layer. Here, we define our data providers implementation details. We still try to abstract the different components and hide their implementation from one to another to support changes and easily test the core functionality.

## Presentation Layer
The presentation layer connects all the different pieces into a single, functioning unit that is the application. Here, we’ll find Activities and Fragments, the UI and presenters under an MVP architecture, mappers, and dependency injection framework that’s wires everything across the application.
